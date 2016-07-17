package com.mch.swat3.entity;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.world.World;

public abstract class EntityBullet extends Entity implements IProjectile{

	public EntityBullet(World worldIn) {
		super(worldIn);
	}


}