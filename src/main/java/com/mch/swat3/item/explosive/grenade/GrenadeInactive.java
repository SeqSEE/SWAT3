package com.mch.swat3.item.explosive.grenade;

import com.mch.swat3.creativetab.SWATCreativeTabs;
import com.mch.swat3.init.SWATItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class GrenadeInactive extends GrenadeActive{
	
	public GrenadeInactive(String name, GrenadeType type) {
		super(name, type);
		this.setCreativeTab(SWATCreativeTabs.SWATWeapons);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World worldIn, EntityPlayer playerIn, EnumHand hand) {
		EnumActionResult result;
		Item item;
		switch(this.grenadeType){
		case CONCUSSION:
			item = SWATItems.GRENADE_CONCUSSION_ACTIVE;
			result = EnumActionResult.SUCCESS;
			break;
		case FLASHBANG:
			item = SWATItems.GRENADE_FLASHBANG_ACTIVE;
			result = EnumActionResult.SUCCESS;
			break;
		case SMOKE:
			item = SWATItems.GRENADE_SMOKE_ACTIVE;
			result = EnumActionResult.SUCCESS;
			break;
		case PIPEBOMB:
			item = SWATItems.PIPE_BOMB_ACTIVE;
			result = EnumActionResult.SUCCESS;
			break;
		default:
			item = SWATItems.GRENADE_CONCUSSION_ACTIVE;
			result = EnumActionResult.PASS;
			break;
		}
		if (!worldIn.isRemote){
			playerIn.replaceItemInInventory(playerIn.inventory.currentItem, new ItemStack(item));
		}
		return new ActionResult(result, stack);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int slot, boolean isSelected) {
		
	}

}
