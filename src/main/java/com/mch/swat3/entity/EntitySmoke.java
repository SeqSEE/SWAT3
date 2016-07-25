package com.mch.swat3.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntitySmoke extends EntityThrowable{
	
	private EntityLivingBase shootingEntity;
	private int timer = 0;
	private boolean smoking;

	public EntitySmoke(World worldIn) {
		super(worldIn);
	}


    public EntitySmoke(World worldIn, EntityLivingBase shooter, int fuse) {
        this(worldIn, shooter.posX, shooter.posY + (double)shooter.getEyeHeight() - 0.10000000149011612D, shooter.posZ);
        this.shootingEntity = shooter;

 
    }

	public EntitySmoke(World worldIn, double x, double y, double z) {
        this(worldIn);
        this.setPosition(x, y, z);
    }


	@Override
	public void onUpdate(){
		super.onUpdate();
		if (!this.worldObj.isRemote){
			if (this.timer > 0){
				--this.timer;
			}
			else{
				this.worldObj.createExplosion((Entity)null, this.lastTickPosX, this.lastTickPosY, this.lastTickPosZ, 0.5F, false);
				this.setDead();
			}
		}
		else{
			for (int i = 0; i < 80; ++i){
				this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.posX, this.posY, this.posZ, rand.nextDouble() * 0.5, rand.nextDouble() * 0.5, rand.nextDouble() * 0.5);
			}
		}
		
	}
	 
	 
	@Override
	protected void onImpact(RayTraceResult result) {
		if (result.typeOfHit.equals(RayTraceResult.Type.BLOCK)){
		    this.motionX *= -0.10000000149011612D;
            this.motionY *= -0.10000000149011612D;
            this.motionZ *= -0.10000000149011612D;
            this.rotationYaw += 180.0F;
            this.prevRotationYaw += 180.0F;
            this.setVelocity(0.0, 0.0, 0.0);
            this.timer = 100;
		}
	}

}
