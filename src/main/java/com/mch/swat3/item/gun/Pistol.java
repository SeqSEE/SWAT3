package com.mch.swat3.item.gun;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;

public class Pistol extends GunBase{

	public Pistol(String name) {
		super(name);
	}
	
	@Override
	 public boolean onEntitySwing(EntityLivingBase entityLiving, ItemStack stack) {
		int x = entityLiving.getPosition().getX();
		int y = entityLiving.getPosition().getY();
		int z = entityLiving.getPosition().getZ();
		boolean click = true;
		if (click){
			entityLiving.getEntityWorld().playSound(x, y, z, SoundEvents.BLOCK_LEVER_CLICK, SoundCategory.PLAYERS, 1.0F, 0.0F, true);
			click = false;
		
	    }
		 return click;
	}
	
	@Override
	public void onUsingTick(ItemStack stack, EntityLivingBase player, int count) {
		
		
    }

}
