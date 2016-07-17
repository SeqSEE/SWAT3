package com.mch.swat3.entity;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityGrenade extends EntityThrowable{
	
	public EntityGrenade(World world) {
        super(world);
    }

	public EntityGrenade(World world, EntityLivingBase thrower) {
		super(world, thrower);
		
	}
	
	public EntityGrenade(World worldIn, double x, double y, double z)
    {
        super(worldIn, x, y, z);
    }

	@Override
	protected void onImpact(RayTraceResult result) {
		
		
	}

}
