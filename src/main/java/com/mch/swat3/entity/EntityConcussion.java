package com.mch.swat3.entity;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityConcussion extends EntityThrowable{
	
	private EntityLivingBase shootingEntity;

	public EntityConcussion(World worldIn) {
		super(worldIn);
	}


    public EntityConcussion(World world, EntityLivingBase shooter, int fuse) {
        this(world, shooter.posX, shooter.posY + (double)shooter.getEyeHeight() - 0.10000000149011612D, shooter.posZ);
        this.shootingEntity = shooter;
 
    }

	public EntityConcussion(World worldIn, double x, double y, double z) {
        this(worldIn);
        this.setPosition(x, y, z);
    }


	@Override
	public void onUpdate(){
		super.onUpdate();

	}
		

	 
	 
	@Override
	protected void onImpact(RayTraceResult result) {
		if(!this.worldObj.isRemote){
			List<BlockPos> blocks = this.worldObj.createExplosion((Entity)null, this.lastTickPosX, this.lastTickPosY, this.lastTickPosZ, 4.5F, false).getAffectedBlockPositions();
			for (BlockPos pos : blocks){
				List<EntityPlayer> players = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(pos));
				for (EntityPlayer player : players){
					player.addPotionEffect(new PotionEffect(Potion.getPotionById(15), 20, 1));
				}
			}
		
			this.setDead();
		}
	}

}
