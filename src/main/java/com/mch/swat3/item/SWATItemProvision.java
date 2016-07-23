package com.mch.swat3.item;

import com.mch.swat3.creativetab.SWATCreativeTabs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;


public class SWATItemProvision extends SWATItem{

	public SWATItemProvision(String name, int maxStack) {
		super(name, maxStack);
		this.setCreativeTab(SWATCreativeTabs.SWATProvisions);
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand){
	    player.heal(4.0f); //the number of half-hearts you want to heal
	    stack.stackSize --;
	    if (stack.stackSize == 0){
	        player.inventory.deleteStack(stack);
	    }
	    return new ActionResult(EnumActionResult.PASS, stack);
	}

}
