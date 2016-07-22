package com.mch.swat3.item.gun;

import java.util.List;

import javax.annotation.Nullable;

import com.mch.swat3.entity.EntityConcussion;
import com.mch.swat3.entity.EntityGunSlug;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class Pistol extends GunBase{
	
	private int cooldown;

	public Pistol(String name) {
		super(name);
		this.cooldown = 0;
	}
	
	@Override
	 public boolean onEntitySwing(EntityLivingBase entity, ItemStack stack) {
		boolean swing = false;
		int x = entity.getPosition().getX();
		int y = entity.getPosition().getY();
		int z = entity.getPosition().getZ();
		if (entity instanceof EntityPlayer){
			EntityPlayer player = (EntityPlayer)entity;
			player.getEntityWorld().playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.NEUTRAL, 0.5F, 0.4F / (itemRand.nextFloat() * 4 + 0.8F));
			EntityGunSlug slug = new EntityGunSlug(player.getEntityWorld(), player);
			slug.setHeadingFromThrower(player, player.rotationPitch, player.rotationYawHead, 0.0F, 2.5F, 1.0F);
			if (!entity.getEntityWorld().isRemote){
				entity.getEntityWorld().spawnEntityInWorld(slug);
				swing = true;
			}
		}	
		return swing;
	}

	@Override
	public void onUpdate(ItemStack stack, World worldIn, Entity entityIn, int itemSlot, boolean isSelected){
		super.onUpdate(stack, worldIn, entityIn, itemSlot, isSelected);
    }
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
	
	}

}
