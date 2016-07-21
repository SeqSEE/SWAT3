package com.mch.swat3.entity;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityLivingBase;

import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class EntitySmoke extends EntityThrowable {
	
	private int timer;
	private int detCount;
	private boolean impacted;
	
	public EntitySmoke(World world) {
		super(world);
		// TODO Auto-generated constructor stub
	}
	
	public EntitySmoke(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
		// TODO Auto-generated constructor stub
	}
	


	@Override
	protected void onImpact(RayTraceResult result) {
		this.detCount = 0;
		this.impacted = true;
		this.timer = 10000;
	}
	
	@Override
	protected float getGravityVelocity()
    {
        return 0.15F;
    }



	private void detonate(World world, double x, double y, double z) {
		double a = world.rand.nextDouble();
		double b = world.rand.nextDouble();
		double c = world.rand.nextDouble();

		double aa = world.rand.nextDouble();
		double bb = world.rand.nextDouble();
		double cc = world.rand.nextDouble();
		world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, false, x + a, y + b, z + c, aa - 0.66 , bb - 0.66, cc - 0.66);
		world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, false, x + a, y + b, z + c, aa - c, bb - b, cc - a);
		
	}
		

	@Override
	public void onUpdate(){
	   super.onUpdate();
	   World world = this.getEntityWorld();
	   if (this.impacted){
		   while(this.timer > 0){
				if((this.timer % 5) == 0){
					this.detonate(this.getEntityWorld(),this.posX, this.posY, this.posZ); 
				}
				--this.timer;		
			}
		   this.setDead();
		} 
	}
}
	
