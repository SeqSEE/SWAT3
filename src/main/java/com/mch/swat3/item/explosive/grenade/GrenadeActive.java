package com.mch.swat3.item.explosive.grenade;

import javax.annotation.Nullable;

import com.google.common.base.Predicate;
import com.mch.swat3.entity.EntityFlashbang;
import com.mch.swat3.entity.EntityGrenade;
import com.mch.swat3.init.SWATItems;
import com.mch.swat3.item.explosive.ThrownBase;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.init.Items;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.stats.StatList;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GrenadeActive extends ThrownBase {

	
	public GrenadeActive(String name) {
		super(name);
		this.setMaxDamage(60);
		
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
			explosionSize = 1.0F;
			world.createExplosion(null, x, y, z, explosionSize, true);
		}
		if (stack.getItem() == SWATItems.GRENADE_FLASHBANG_ACTIVE){
			player.replaceItemInInventory(slot, null);
			explosionSize = 0.25F;
			world.createExplosion(null, x, y, z, explosionSize, true);
			player.addPotionEffect(new PotionEffect(Potion.getPotionById(15), 100, 10 , false, false));
		}
		if (stack.getItem() == SWATItems.GRENADE_SMOKE_ACTIVE){
			//smoke effect goes here
		}
		if (stack.getItem() == SWATItems.PIPE_BOMB_ACTIVE){
			player.replaceItemInInventory(slot, null);
			explosionSize = 0.6F;
			world.createExplosion(null, x, y, z, explosionSize, true);
		}
}

	//This makes it so when damage is caused to the item it does not animate re-equip.
	@Override
	public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
		return !oldStack.getItem().equals(newStack.getItem()) && !slotChanged; 
	}
	
	/*
	 * need to create entity and renderer
	 * 
	 * 
	 * 
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		--stack.stackSize;
		world.playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_SNOWBALL_THROW, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 0.4F + 0.8F));
        if (!world.isRemote) {
	            EntityFlashbang flashbang = ;
	            flashbang.setHeadingFromThrower(player, player.rotationPitch, player.rotationYaw, 0.0F, 1.5F, 1.0F);
	            world.spawnEntityInWorld(flashbang);
	        }

	        player.addStat(StatList.getObjectUseStats(this));
	        return new ActionResult(EnumActionResult.SUCCESS, stack);
	    }
	    */
}
