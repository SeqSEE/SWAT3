package com.mch.swat3.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityConcussion extends EntityThrowable {
	

	public EntityConcussion(World world) {
		super(world);
		// TODO Auto-generated constructor stub
	}
	
	public EntityConcussion(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
		// TODO Auto-generated constructor stub
	}


	@Override
	protected void onImpact(RayTraceResult result) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onUpdate(){
	   super.onUpdate();
    }
	


}
