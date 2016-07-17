package com.mch.swat3.entity;


import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityFlashbang extends EntityThrowable{

	public EntityFlashbang(World world, EntityLivingBase thrower) {
		super(world, thrower);
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		// TODO Auto-generated method stub
		
	}
	
	

	

}
