package com.mch.swat3.entity;

import net.minecraft.block.Block;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityFlashbang extends EntityThrowable{
	
	private EntityLivingBase shootingEntity;
	private int ticksInGround;
	private int xTile;
	private int yTile;
	private int zTile;
	private Block inTile;

	public EntityFlashbang(World worldIn) {
		super(worldIn);
	}


    public EntityFlashbang(World worldIn, EntityLivingBase shooter) {
        this(worldIn, shooter.posX, shooter.posY + (double)shooter.getEyeHeight() - 0.10000000149011612D, shooter.posZ);
        this.shootingEntity = shooter;
 
    }

	public EntityFlashbang(World worldIn, double x, double y, double z) {
        this(worldIn);
        this.setPosition(x, y, z);
    }


	@Override
	public void onUpdate(){
		super.onUpdate();
	}
	 
	 
	@Override
	protected void onImpact(RayTraceResult result) {
		 if (!this.worldObj.isRemote) {
			 this.setDead();
		 }
	}

}
