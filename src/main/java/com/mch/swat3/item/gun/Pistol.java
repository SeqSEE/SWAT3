package com.mch.swat3.item.gun;

import java.util.List;

import javax.annotation.Nullable;

import com.mch.swat3.entity.EntityGunSlug;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;

public class Pistol extends GunBase{
	

	public Pistol(String name) {
		super(name);

	}
	

	@Override
	public boolean onEntitySwing(EntityLivingBase entity, ItemStack stack) {
		return super.onEntitySwing(entity, stack);
	}
	
	@Override
	public void onUsingTick(ItemStack stack, EntityLivingBase player, int count) {
		
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
		if (stack.hasTagCompound()) {
				stack.getTagCompound().setInteger("firing", 1);
		}
	}
	

}
