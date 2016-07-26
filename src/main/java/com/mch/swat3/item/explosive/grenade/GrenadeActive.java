package com.mch.swat3.item.explosive.grenade;

import java.util.List;

import com.mch.swat3.entity.EntityConcussion;
import com.mch.swat3.entity.EntityFlashbang;
import com.mch.swat3.entity.EntityPipebomb;
import com.mch.swat3.entity.EntitySmoke;
import com.mch.swat3.item.SWATItem;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;



public class GrenadeActive extends SWATItem {

	public enum GrenadeType {
		CONCUSSION, FLASHBANG, SMOKE, PIPEBOMB
	}

	public GrenadeType grenadeType;
	
	public GrenadeActive(String name, GrenadeType type) {
		super(name, 1);
		this.grenadeType = type;
		this.setMaxDamage(100);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		EnumActionResult result;
		EntityThrowable grenade;
		int fuse = stack.getMaxDamage() - stack.getItemDamage();
		switch(this.grenadeType){
		case CONCUSSION:
			grenade = new EntityConcussion(world, player, fuse);
			result = EnumActionResult.SUCCESS;
			break;
		case FLASHBANG:
			grenade = new EntityFlashbang(world, player, fuse);
			result = EnumActionResult.SUCCESS;
			break;
		case SMOKE:
			grenade = new EntitySmoke(world, player, fuse);
			result = EnumActionResult.SUCCESS;
			break;
		case PIPEBOMB:
			grenade = new EntityPipebomb(world, player, fuse);
			result = EnumActionResult.SUCCESS;
			break;
		default:
			grenade = null;
			result = EnumActionResult.PASS;
			break;
		}
		if (grenade != null && !world.isRemote){
			--stack.stackSize;
			grenade.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.0F, 1.01F);
        	if(!world.isRemote){
			world.spawnEntityInWorld(grenade);
		   	}
        }
		return new ActionResult(result, stack);
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
    		this.detonateInHand(stack, world, player, slot);
    	}
	}
	
	/*
	 * Gets the item and sets the explosion size if there is one
	 */
	public void detonateInHand(ItemStack stack, World world, EntityPlayer player, int slot){
		float explosionSize = 0.0F;
		switch(this.grenadeType){
		case CONCUSSION:
			explosionSize = 0.8F;
			break;
		case FLASHBANG:
			explosionSize = 0.8F;
			break;
		case SMOKE:
			explosionSize = 0.8F;
			break;
		case PIPEBOMB:
			explosionSize = 1.0F;
			break;
		default:
			break;
		}
		this.detonate(world, player, slot, explosionSize);
		
		

	}

	private void detonate(World world, EntityPlayer player, int slot, float explosionSize) {
		player.replaceItemInInventory(slot, null);
		switch(this.grenadeType){
			case CONCUSSION:
				for (BlockPos pos : world.createExplosion((Entity)null, player.posX, player.posY, player.posZ, explosionSize, false).getAffectedBlockPositions()){
					List<EntityLivingBase> players = player.getEntityWorld().getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(pos));
					for (EntityLivingBase target : players){
						target.addPotionEffect(new PotionEffect(Potion.getPotionById(9), 200, 5));
						target.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 200, 5));
					}
				}
				break;
			case FLASHBANG:
				for (BlockPos pos : world.createExplosion((Entity)null, player.posX, player.posY, player.posZ, explosionSize, false).getAffectedBlockPositions()){
					List<EntityLivingBase> players = player.getEntityWorld().getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(pos));
					for (EntityLivingBase target : players){
						target.addPotionEffect(new PotionEffect(Potion.getPotionById(9), 200, 10));
						target.addPotionEffect(new PotionEffect(Potion.getPotionById(15), 200, 10));
					}
				}
				break;
			case SMOKE:
				EntitySmoke grenade = new EntitySmoke(world, player, 0);
				grenade.setLocationAndAngles(player.lastTickPosX, player.lastTickPosY, player.lastTickPosZ, player.rotationYawHead, player.rotationPitch);
				if (!world.isRemote){
					grenade.setTimer(100);
					world.spawnEntityInWorld(grenade);
				}
				break;
			case PIPEBOMB:
				world.createExplosion((Entity)null, player.posX, player.posY, player.posZ, explosionSize, false);
				break;
			default:
			break;
		}
	}
}
