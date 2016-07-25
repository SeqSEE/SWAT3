package com.mch.swat3.entity;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.World;

public class EntityFlashbang extends EntityThrowable{
	
	private EntityLivingBase shootingEntity;
	private EntityPlayer affecedPlayers;

	public EntityFlashbang(World worldIn) {
		super(worldIn);
	}


    public EntityFlashbang(World worldIn, EntityLivingBase shooter, int fuse) {
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
		if(!this.worldObj.isRemote){
			List<BlockPos> blocks = this.worldObj.createExplosion((Entity)null, this.lastTickPosX, this.lastTickPosY, this.lastTickPosZ, 2.0F, false).getAffectedBlockPositions();
			for (BlockPos pos : blocks){
				List<EntityPlayer> players = this.worldObj.getEntitiesWithinAABB(EntityPlayer.class, new AxisAlignedBB(pos));
				for (EntityPlayer player : players){
					player.addPotionEffect(new PotionEffect(Potion.getPotionById(15), 60, 5));
				}
			}
		
			this.setDead();
		}
	}

}
