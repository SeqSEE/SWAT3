package com.mch.swat3.entity;

import java.util.Random;

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
	private int timer;
	private int fuse;
	private boolean impacted;

	public EntitySmoke(World worldIn) {
		super(worldIn);
	}


    public EntitySmoke(World worldIn, EntityLivingBase shooter, int fuse) {
        this(worldIn, shooter.posX, shooter.posY + (double)shooter.getEyeHeight() - 0.10000000149011612D, shooter.posZ);
        this.shootingEntity = shooter;
        this.fuse = fuse;

 
    }

	public EntitySmoke(World worldIn, double x, double y, double z) {
        this(worldIn);
        this.setPosition(x, y, z);
    }


	@Override
	public void onUpdate(){
		super.onUpdate();
		if (!this.worldObj.isRemote) {
			if(this.fuse > 0){
				--this.fuse;
				this.timer = 100;
			}
			else{
				if (this.timer > 0){
					--this.timer;
				}
				else{
					this.worldObj.createExplosion((Entity)null, this.lastTickPosX, this.lastTickPosY, this.lastTickPosZ, 0.1F, false);
					this.setDead();
				}
				
			}
		}
		if (this.impacted = true){
			for(int i = 0; i < 40; ++i){
				Random random = new Random();
				double x = (random.nextDouble() / 6);
				double y = (random.nextDouble() / 6);
				this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.lastTickPosX + 1.0, this.lastTickPosY + 0.3, this.lastTickPosZ + 1.0, x, rand.nextDouble() / 10, y);
				this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.lastTickPosX, this.lastTickPosY + 0.3, this.lastTickPosZ, x, rand.nextDouble() / 9, y);
				this.worldObj.spawnParticle(EnumParticleTypes.SMOKE_LARGE, this.lastTickPosX - 1.0, this.lastTickPosY + 0.3, this.lastTickPosZ - 1.0, x, rand.nextDouble() / 10, y);
				
			}	
		}
		
	}
	
	@Override
	protected float getGravityVelocity()
    {
        return 0.05F;
    }
	
	public void setTimer(int time){
		this.timer = time;	
	}
	 
	 
	@Override 
	protected void onImpact(RayTraceResult result) {
		if (result.typeOfHit.equals(RayTraceResult.Type.BLOCK)){
			if (!this.worldObj.getBlockState(result.getBlockPos()).getBlock().isAir(this.worldObj.getBlockState(result.getBlockPos()), this.worldObj, result.getBlockPos())){
				this.impacted = true;	
			}
			this.motionX *= -0.10000000149011612D;
            this.motionY *= -0.10000000149011612D;
            this.motionZ *= -0.10000000149011612D;
            this.rotationYaw += 180.0F;
            this.prevRotationYaw += 180.0F;
		}
		if (result.typeOfHit.equals(RayTraceResult.Type.ENTITY)){
			if (this.shootingEntity != result.entityHit){
				this.impacted = true;
			}
			if(this.shootingEntity instanceof EntityPlayer){
				result.entityHit.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.shootingEntity), 0.1F);
			}
		}	
		
	}

}
