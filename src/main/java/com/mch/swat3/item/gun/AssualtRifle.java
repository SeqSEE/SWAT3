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
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
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
		this.setMaxDamage(maxAmmo);
	}
	
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		stack.getTagCompound().setInteger("delayTicks",200);
		player.setActiveHand(hand);
        return new ActionResult(EnumActionResult.SUCCESS, stack);
	}

	
	//This makes it so when damage is caused to the item it does not animate re-equip.
		@Override
		public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
			return false;
		}
	

	
	@Override
	@Nullable
    public ItemStack onItemUseFinish(ItemStack stack, World worldIn, EntityLivingBase entityLiving) {
		stack.getTagCompound().setInteger("delayTicks",0);
		return stack;
    }
	

	
	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
	    if (stack.getItemDamage() < this.maxAmmo){
	    	if (stack.hasTagCompound()){
	    		if (stack.getTagCompound().hasKey("shootCooldown")){
	    			if (stack.getTagCompound().getInteger("shootCooldown") > 0){
	    				stack.getTagCompound().setInteger("shootCooldown", stack.getTagCompound().getInteger("shootCooldown") - 1);
	    			}
	    			else{
	    				if (stack.getTagCompound().hasKey("delayTicks")){
	    					if (stack.getTagCompound().getInteger("delayTicks") > 0){
	    						if (stack.getTagCompound().getInteger("delayTicks") % 3 == 0){
	    							if (!world.isRemote){
	    								EntityPlayer player = (EntityPlayer)entity;
	    	                			player.getEntityWorld().playSound((EntityPlayer)null, player.posX, player.posY, player.posZ, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.NEUTRAL, 3.5F, 15.0F);
	    	                			EntityGunSlug slug = new EntityGunSlug(player.getEntityWorld(), player);
	    	                			slug.setHeadingFromThrower(player, player.rotationPitch, player.rotationYawHead, 0.0F, 4.5F, 0.2F);
	    	                			entity.getEntityWorld().spawnEntityInWorld(slug);
	    	                			stack.damageItem(1, (EntityLivingBase) entity);
	    							}
	    						}
	    						stack.getTagCompound().setInteger("delayTicks",stack.getTagCompound().getInteger("delayTicks") - 1);
	    					}
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
	 public boolean onEntitySwing(EntityLivingBase entity, ItemStack stack) {
		boolean swing = false;
		int x = entity.getPosition().getX();
		int y = entity.getPosition().getY();
		int z = entity.getPosition().getZ();
		if (entity instanceof EntityPlayer){
			if (!entity.getEntityWorld().isRemote){
				for(int i = 0; i < 3; i++ ){
				        	stack.getTagCompound().setInteger("delayTicks",10);
				        	stack.getTagCompound().setInteger("shootCooldown",1);
				}
				swing = true;
			}
		}	
		return swing;
	}
	
	

}
