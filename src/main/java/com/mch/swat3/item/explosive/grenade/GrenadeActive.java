package com.mch.swat3.item.explosive.grenade;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;


import com.mch.swat3.entity.EntityGrenade;

import com.mch.swat3.init.SWATItems;
import com.mch.swat3.item.SWATItem;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.Item;
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
		switch(this.grenadeType){
		case CONCUSSION:
			grenade = new EntityGrenade(world, player);
			result = EnumActionResult.SUCCESS;
			break;
		case FLASHBANG:
			grenade = new EntityGrenade(world, player);
			result = EnumActionResult.SUCCESS;
			break;
		case SMOKE:
			grenade = new EntityGrenade(world, player);
			result = EnumActionResult.SUCCESS;
			break;
		case PIPEBOMB:
			grenade = new EntityGrenade(world, player);
			result = EnumActionResult.SUCCESS;
			break;
		default:
			grenade = null;
			result = EnumActionResult.PASS;
			break;
		}
		if (grenade != null && !world.isRemote){
			--stack.stackSize;
			grenade.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 0.5F, 1.01F);
        	world.spawnEntityInWorld(grenade);
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
			explosionSize = 1.0F;
			break;
		case FLASHBANG:
			explosionSize = 0.2F;
			break;
		case SMOKE:
			explosionSize = 0.1F;
			break;
		case PIPEBOMB:
			explosionSize = 1.3F;
			break;
		default:
			break;
		}
		this.detonate(world, player, slot, explosionSize);
		
		

	}

	private void detonate(World world, EntityPlayer player, int slot, float explosionSize) {
		world.createExplosion((Entity)null, player.posX, player.posY, player.posZ, explosionSize, false);
		world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, player.posX, player.posY, player.posZ, 0.0F, 0.0F, 0.0F);
		player.replaceItemInInventory(slot, null);
		
	}
}

	
	/*
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
	*/

	

	    

