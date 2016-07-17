package com.mch.swat3.item.gun;

import java.util.List;

import javax.annotation.Nullable;

import com.mch.swat3.entity.EntityBullet;
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

	public SMG(String name, int maxStack) {
		super(name, maxStack);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack itemStack, World world, EntityPlayer player, EnumHand hand) {
		player.setActiveHand(hand);
		//shoot(world, player);
        return new ActionResult(EnumActionResult.SUCCESS, itemStack);
	
	}

	/*
	private void shoot(World world, EntityPlayer player) {
		if (!world.isRemote){
		ItemStack itemstack = new ItemStack(SWATItems.BULLET);
		ItemBullet itembullet = (ItemBullet) SWATItems.BULLET;
		EntityBullet entitybullet = (EntityBullet) itembullet.createArrow(world, new ItemStack(itembullet), player);
		entitybullet.setAim(player, player.rotationPitch, player.rotationYaw, 0.0F, 2.0F * 3.0F, 1.0F);
		world.spawnEntityInWorld(entitybullet);
		}
	}
	*/

	

}
