package com.mch.swat3.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityPipebomb extends EntityThrowable{
	
	private EntityLivingBase shootingEntity;
	private int fuse;

	public EntityPipebomb(World worldIn) {
		super(worldIn);
	}

    public EntityPipebomb(World worldIn, EntityLivingBase shooter, int fuse) {
        this(worldIn, shooter.posX, shooter.posY + (double)shooter.getEyeHeight() - 0.10000000149011612D, shooter.posZ);
        this.shootingEntity = shooter;
        this.fuse = fuse;
 
    }

	public EntityPipebomb(World worldIn, double x, double y, double z) {
        this(worldIn);
        this.setPosition(x, y, z);
    }

	@Override
	public void onUpdate(){
		super.onUpdate();
		if (!this.worldObj.isRemote) {
			if(this.fuse > 0){
				this.fuse -= rand.nextInt(2);
			}
			else{
				this.worldObj.createExplosion((Entity)null, this.lastTickPosX, this.lastTickPosY, this.lastTickPosZ, 3.0F, false);
				this.setDead();
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
		}
		if (result.typeOfHit.equals(RayTraceResult.Type.ENTITY)){
			if(this.shootingEntity instanceof EntityPlayer){
				result.entityHit.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.shootingEntity), 0.1F);
			}
		}
	}
	
}
