package com.mch.swat3.item.gun;

import com.mch.swat3.entity.EntityGunSlug;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.world.World;


public class SMG extends GunBase{

	public SMG(String name) {
		super(name);
	}
	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
	    if (stack.hasTagCompound()){
	    	if (stack.getTagCompound().hasKey("shootCooldown")){
	    		if (stack.getTagCompound().getInteger("shootCooldown") > 0){
	    			stack.getTagCompound().setInteger("shootCooldown", stack.getTagCompound().getInteger("shootCooldown") - 1);
	    		}
	    		else{
	    			if (stack.getTagCompound().hasKey("delayTicks")){
	    	            if (stack.getTagCompound().getInteger("delayTicks") > 0){
	    	                if (stack.getTagCompound().getInteger("delayTicks") % 1 == 0){
	    	                	if (!world.isRemote){
	    	                		EntityPlayer player = (EntityPlayer)entity;
	    	                		player.getEntityWorld().playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.NEUTRAL, 3.5F, 20.0F);
	    	                		EntityGunSlug slug = new EntityGunSlug(player.getEntityWorld(), (EntityLivingBase)player);
	    	                		slug.setHeadingFromThrower(player, player.rotationPitch, player.rotationYawHead, 0.0F, 4.5F, 0.2F);
	    	                		entity.getEntityWorld().spawnEntityInWorld(slug);
	    	                	}
	    	                }
	    	                stack.getTagCompound().setInteger("delayTicks",stack.getTagCompound().getInteger("delayTicks") - 1);
	    	            }
	    	        }
	    		}
	    	}
	    	else {
	    		stack.setTagCompound(new NBTTagCompound());
	    	}
	        
	    }
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		player.setActiveHand(hand);
		int x = player.getPosition().getX();
		int y = player.getPosition().getY();
		int z = player.getPosition().getZ();
		if (!player.getEntityWorld().isRemote){
			for(int i = 0; i < 5; i++ ){
				stack.getTagCompound().setInteger("shootCooldown", stack.getTagCompound().getInteger("shootCooldown") + 3);
			}
		}
        return new ActionResult(EnumActionResult.SUCCESS, stack);
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
				        	stack.getTagCompound().setInteger("delayTicks",15);
				        	stack.getTagCompound().setInteger("shootCooldown",3);
				}
				swing = true;
			}
		}	
		return swing;
	}

	

}
