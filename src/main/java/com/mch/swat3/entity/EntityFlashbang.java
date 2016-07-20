package com.mch.swat3.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityFlashbang extends EntityThrowable{

	public EntityFlashbang(World worldIn, EntityLivingBase throwerIn) {
		super(worldIn, throwerIn);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		// TODO Auto-generated method stub
		
	}

}
