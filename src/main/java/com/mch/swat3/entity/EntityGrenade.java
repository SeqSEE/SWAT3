package com.mch.swat3.entity;

import com.mch.swat3.init.SWATItems;
import com.mch.swat3.item.explosive.grenade.GrenadeActive.GrenadeType;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityGrenade extends EntityThrowable {
	
	public void setGrenadeType(GrenadeType type){
		this.grenadeType = type;
	}
		

	public GrenadeType grenadeType;
	
	public EntityGrenade(World world) {
		super(world);
	}
	
	public EntityGrenade(World world, EntityPlayer player) {
		super(world, player);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
	}

	@Override
	protected void onImpact(RayTraceResult result) {
		
	}
}
