package com.mch.swat3.item.gun;

import java.util.List;

import javax.annotation.Nullable;

import com.mch.swat3.entity.EntityGunSlug;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;

public class AssualtRifle extends GunBase{

	public enum GunType{
		AK_47
	}
	
	private GunType type;
	private int maxAmmo;
	public AssualtRifle(String name, GunType type, int maxAmmo) {
		super(name);
		this.type = type;
		this.maxAmmo = maxAmmo;
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
	    if (stack.hasTagCompound()){
   			if (stack.getTagCompound().hasKey("delayTicks")){
   	            if (stack.getTagCompound().getInteger("delayTicks") > 0){
   	                if (stack.getTagCompound().getInteger("delayTicks") % 3 == 0){
   	                	if (!world.isRemote){
   	                		EntityPlayer player = (EntityPlayer)entity;
   	                		player.getEntityWorld().playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.NEUTRAL, 3.5F, 15.0F);
   	                		EntityGunSlug slug = new EntityGunSlug(player.getEntityWorld(), player);
   	                		slug.setHeadingFromThrower(player, player.rotationPitch, player.rotationYawHead, 0.0F, 4.5F, 0.2F);
   	                		entity.getEntityWorld().spawnEntityInWorld(slug);
   	                	}
   	                }
   	                stack.getTagCompound().setInteger("delayTicks",stack.getTagCompound().getInteger("delayTicks") - 1);
   	            }
   	        }
   		}
        
	    else {
	        stack.setTagCompound(new NBTTagCompound());
	    }
	}
	
	@Override
	 public boolean onEntitySwing(EntityLivingBase entity, ItemStack stack) {
		boolean swing = false;
		int x = entity.getPosition().getX();
		int y = entity.getPosition().getY();
		int z = entity.getPosition().getZ();
		if (entity instanceof EntityPlayer){
			if (!entity.getEntityWorld().isRemote){
				for(int i = 0; i < 3; i++ ){
				        	stack.getTagCompound().setInteger("delayTicks",11);
				}
				swing = true;
			}
		}	
		return swing;
	}
	
	

}
