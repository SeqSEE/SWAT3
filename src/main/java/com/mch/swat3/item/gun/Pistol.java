package com.mch.swat3.item.gun;

import java.util.Random;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class Pistol extends GunBase{
	

	public Pistol(String name) {
		super(name);

	}
	

	@Override
	public boolean onEntitySwing(EntityLivingBase entity, ItemStack stack) {
		if (stack.hasTagCompound()) {
			stack.getTagCompound().setFloat("inaccuracy", 1.0F * this.itemRand.nextFloat() * this.itemRand.nextFloat());
		}
		return false;
	}
	
	@Override
	public void onUsingTick(ItemStack stack, EntityLivingBase player, int count) {
		if (stack.hasTagCompound()){
			if (stack.getTagCompound().hasKey("inaccuracy")){
				if (stack.getTagCompound().getFloat("inaccuracy") > 0.0F){
					stack.getTagCompound().setFloat("inaccuracy", stack.getTagCompound().getFloat("inaccuracy") - 0.2F);
				}
			}
			else{
				stack.getTagCompound().setFloat("inaccuracy", 0.98F);
			}
			
		}
	}
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
		if (stack.hasTagCompound()) {
				stack.getTagCompound().setInteger("firing", 1);
		}
	}
	

}
