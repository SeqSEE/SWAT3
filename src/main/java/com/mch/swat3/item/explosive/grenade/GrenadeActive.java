package com.mch.swat3.item.explosive.grenade;

import java.util.ArrayList;
import java.util.List;

import com.mch.swat3.entity.EntityConcussion;
import com.mch.swat3.entity.EntityFlashbang;
import com.mch.swat3.entity.EntityPipebomb;
import com.mch.swat3.entity.EntitySmoke;
import com.mch.swat3.init.SWATItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class GrenadeActive extends GrenadeInactive {

	
	public GrenadeActive(String name) {
		super(name);
		this.setMaxDamage(60);
		
	}
	private List<BlockPos> explosionRadius = new ArrayList();
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
	   
		EnumActionResult result;
		if (!world.isRemote) {
	     	if (stack.getItem() == SWATItems.GRENADE_CONCUSSION_ACTIVE){
	     		--stack.stackSize;
	     		world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_SPLASH_POTION_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	        	EntityConcussion grenade = new EntityConcussion(world, player);
	        	grenade.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
		        world.spawnEntityInWorld(grenade);
	        }
	     	if (stack.getItem() == SWATItems.GRENADE_FLASHBANG_ACTIVE){
	        	--stack.stackSize;
	     		world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_SPLASH_POTION_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	        	EntityFlashbang grenade = new EntityFlashbang(world, player);
		        grenade.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
		        world.spawnEntityInWorld(grenade);
	       	}
	     	if (stack.getItem() == SWATItems.PIPE_BOMB_ACTIVE){
	       		--stack.stackSize;
	       		world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_SPLASH_POTION_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	       		EntityPipebomb grenade = new EntityPipebomb(world, player);
	       		grenade.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
	       		world.spawnEntityInWorld(grenade);
	       	}
	     	if (stack.getItem() == SWATItems.GRENADE_SMOKE_ACTIVE){
	       		--stack.stackSize;
	        	world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_SPLASH_POTION_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
	        	EntitySmoke grenade = new EntitySmoke(world, player);
	        	grenade.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 0.5F, 1.01F);
	        	world.spawnEntityInWorld(grenade);
	       	}

	    }

	    return new ActionResult(EnumActionResult.SUCCESS, stack);
	}
	
	//This makes it so when damage is caused to the item it does not animate re-equip.
		@Override
		public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
			return !oldStack.getItem().equals(newStack.getItem()) && !slotChanged; 
		}
	
	//Using damage for the timer for grenades. This fires only while in the player inventory
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean isSelected) {
    	if (stack.getItemDamage() < stack.getMaxDamage()){
    		//damage the item for countdown effect
    		stack.damageItem(1, (EntityPlayer)entity);
    	}
    	else {
    		//remove the grenade from inventory in needed and create an explosion if needed(smoke?)
    		EntityPlayer player = (EntityPlayer) entity;
    		detonate(stack, world, player, slot);
    	}
	}
	
	/*
	 * Gets the item and sets the explosion size if there is one
	 */
	public void detonate(ItemStack stack, World world, EntityPlayer player, int slot){
		float explosionSize;
		double x = player.posX;
		double y = player.posY + (double)(player.height / 8.0F);
		double z = player.posZ;
		if (stack.getItem() == SWATItems.GRENADE_CONCUSSION_ACTIVE){
			player.replaceItemInInventory(slot, null);
			explosionSize = 2.0F;
			
		}
		if (stack.getItem() == SWATItems.GRENADE_FLASHBANG_ACTIVE){
			player.replaceItemInInventory(slot, null);
			explosionSize = 0.25F;
			Explosion explosion = new Explosion(world, (Entity)null, x, y, z, explosionSize, false, true);
			for (BlockPos pos : explosion.getAffectedBlockPositions()){
				AxisAlignedBB bb = new AxisAlignedBB(pos);
				if (world.getEntitiesWithinAABB(EntityPlayer.class, bb) != null){
					for (EntityPlayer entity: world.getEntitiesWithinAABB(EntityPlayer.class, bb)){
						entity.addPotionEffect(new PotionEffect(Potion.getPotionById(15), 120, 5));
					}
				}
			}	
			
			
			
		}
		if (stack.getItem() == SWATItems.GRENADE_SMOKE_ACTIVE){
			smoke(world, x, y, z);
		}
		if (stack.getItem() == SWATItems.PIPE_BOMB_ACTIVE){
			player.replaceItemInInventory(slot, null);
			explosionSize = 0.6F;
			world.createExplosion(null, x, y, z, explosionSize, true);
		}
		
		
}
	
	private void smoke(World world, double x, double y, double z){
		int timer = 120;
		do {
			double sx = world.rand.nextDouble();
			double sy = world.rand.nextDouble();
			double sz = world.rand.nextDouble();
			double a = world.rand.nextDouble();
			double b = world.rand.nextDouble();
			double c = world.rand.nextDouble();
			
			//EnumParticleTypes particleType, double xCoord, double yCoord, double zCoord, double xSpeed, double ySpeed, double zSpeed
			
			world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, false, x + a, y + b, z + c, sx - 0.1, sy - 0.1, sz - 0.1);
			--timer;
		} while(timer > 0);
		
	}

	

	    
}
