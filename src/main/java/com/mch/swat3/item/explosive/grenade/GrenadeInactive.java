package com.mch.swat3.item.explosive.grenade;

import com.mch.swat3.creativetab.SWATCreativeTabs;
import com.mch.swat3.init.SWATItems;
import com.mch.swat3.item.SWATItem;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class GrenadeInactive extends SWATItem{

	public GrenadeInactive(String name) {
		super(name, 1);
		this.setCreativeTab(SWATCreativeTabs.SWATWeapons);
		
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		EnumActionResult result = EnumActionResult.PASS;
		if (!worldIn.isRemote){
			if (stack.getItem().equals(SWATItems.GRENADE_CONCUSSION)){
				playerIn.replaceItemInInventory(playerIn.inventory.currentItem, new ItemStack(SWATItems.GRENADE_CONCUSSION_ACTIVE));
				result = EnumActionResult.SUCCESS;
			}
			if (stack.getItem().equals(SWATItems.GRENADE_FLASHBANG)){
				playerIn.replaceItemInInventory(playerIn.inventory.currentItem, new ItemStack(SWATItems.GRENADE_FLASHBANG_ACTIVE));
				result = EnumActionResult.SUCCESS;
			}
			if (stack.getItem().equals(SWATItems.GRENADE_SMOKE)){
				playerIn.replaceItemInInventory(playerIn.inventory.currentItem, new ItemStack(SWATItems.GRENADE_SMOKE_ACTIVE));
				result = EnumActionResult.SUCCESS;
			}
			if (stack.getItem().equals(SWATItems.PIPE_BOMB)){
				playerIn.replaceItemInInventory(playerIn.inventory.currentItem, new ItemStack(SWATItems.PIPE_BOMB_ACTIVE));
				result = EnumActionResult.SUCCESS;
			}
		}
		return new ActionResult(result, stack);
	}

}
