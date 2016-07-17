package com.mch.swat3.item.explosive.grenade;

import com.mch.swat3.init.SWATItems;
import com.mch.swat3.item.explosive.ThrownBase;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityTNTPrimed;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class GrenadeActive extends ThrownBase {


	public GrenadeActive(String name) {
		super(name);
		this.setMaxDamage(100);
	}
	
	//Using damage for the timer for grenades. This fires only while in the player inventory
	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entity, int itemSlot, boolean isSelected) {
    	if (stack.getItemDamage() < stack.getMaxDamage()){
    		//damage the item for countdown
    		stack.damageItem(1, (EntityPlayer)entity);
    	}
    	else {
    		//remove the grenade from inventory and create an explosion 
    		entity.replaceItemInInventory(itemSlot, null);
    		float f = 0.5F;
    		entity.getEntityWorld().createExplosion(this.createEntity(entity.getEntityWorld(), entity.entityDropItem(stack, 0), stack), entity.posX, entity.posY + (double)(entity.height / 16.0F), entity.posZ, 4.0F, true);
    	}
	}

	//This makes it so when damaged is caused to the item it does not animate reequip.
	@Override
	 public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
	        return !oldStack.getItem().equals(newStack.getItem()) && !slotChanged; 
	    }

	
	

}
