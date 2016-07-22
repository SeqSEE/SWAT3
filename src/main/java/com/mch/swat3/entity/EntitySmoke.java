package com.mch.swat3.entity;

import java.util.List;

import com.mch.swat3.init.SWATItems;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAreaEffectCloud;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.IProjectile;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.entity.projectile.EntitySnowball;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.PotionTypes;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.potion.PotionType;
import net.minecraft.potion.PotionUtils;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.WorldServer;


public class EntitySmoke extends EntityThrowable{
	
	private int timer;
	private boolean impacted;
	private ItemStack item;
	
	public EntitySmoke(World world) {
		super(world);

	}
	
	
	public EntitySmoke(World world, EntityPlayer player) {
		super(world, player);
		this.item = new ItemStack(SWATItems.GRENADE_SMOKE_ACTIVE);
		
	}
	
	



	@Override
	protected void onImpact(RayTraceResult result) {
		this.timer = 0;
		if (result.typeOfHit == RayTraceResult.Type.BLOCK) {
			this.getEntityWorld().spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, true, this.lastTickPosX, this.lastTickPosY, this.lastTickPosZ, this.rand.nextDouble() - 0.6, this.rand.nextDouble() - 0.4, this.rand.nextDouble() - 0.6);
			this.inGround = true;
		}
    }
	


	private void detonate() {
		double x = this.posX;
		double y = this.posY;
		double z = this.posZ;
		World world = this.getEntityWorld();
			world.spawnParticle(EnumParticleTypes.SMOKE_LARGE, true, x, y, z, this.rand.nextDouble() - 0.6, this.rand.nextDouble() - 0.4, this.rand.nextDouble() - 0.6);
	}
		

	@Override
	public void onUpdate(){
	   super.onUpdate();
	   if (this.inGround){
		   this.getEntityWorld().playSound((EntityPlayer)null, this.posX, this.posY, this.posZ, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.NEUTRAL, 0.5F, 0.4F / (this.rand.nextFloat() + 0.8F));
			do {
				if ((this.timer % 2) == 0 ) {
					this.detonate();
				}
				++this.timer;
			} while (this.timer < 10000);
			this.setDead();
	   }
	}

}
	
