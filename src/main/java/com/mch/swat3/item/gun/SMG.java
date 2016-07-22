package com.mch.swat3.item.gun;

import java.util.List;

import javax.annotation.Nullable;


import com.mch.swat3.init.SWATItems;
import com.mch.swat3.item.bullet.ItemBullet;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;

public class SMG extends GunBase{

	public SMG(String name) {
		super(name);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand) {
		player.setActiveHand(hand);
        return new ActionResult(EnumActionResult.SUCCESS, itemStack);
	}

	

}
