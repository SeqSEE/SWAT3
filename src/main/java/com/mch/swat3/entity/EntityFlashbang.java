package com.mch.swat3.entity;

import java.util.List;

import com.mch.swat3.init.SWATItems;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityFlashbang extends EntityThrowable {
	
	private boolean impacted;



	public EntityFlashbang(World world) {
		super(world);
		this.impacted = false;
	}
	
	public EntityFlashbang(World world, EntityLivingBase thrower) {
		super(world, thrower);
		this.impacted = false;
	}
	
	private List<BlockPos> pos;
	private List<EntityPlayer> playersAffected;
	
	
	
	@Override
	protected void onImpact(RayTraceResult result) {
		this.impacted = true;
	}

	@Override
	public void onUpdate(){
	   super.onUpdate();
	   if (this.impacted){
		   this.detonate();
	   }
	   
    }

		
	private void detonate() {
		
		float explosionSize = 0.35F;
		this.pos = this.getEntityWorld().createExplosion(this, this.lastTickPosX, this.lastTickPosY, this.lastTickPosZ, explosionSize, true).getAffectedBlockPositions();
		for (BlockPos bpos : this.pos){
			AxisAlignedBB aabb = new AxisAlignedBB(bpos);
			this.playersAffected = this.getEntityWorld().getEntitiesWithinAABB(EntityPlayer.class, aabb);
		}
		for (EntityPlayer affectedPlayer : this.playersAffected){
			affectedPlayer.addPotionEffect(new PotionEffect(Potion.getPotionById(15), 30, 4, false, false));
		}
		
	}
}
