package com.mch.swat3.entity;

import java.util.List;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class EntityConcussion extends EntityThrowable{
	
	private EntityLivingBase shootingEntity;
	private int fuse;
	private List<BlockPos> blocks;
	private boolean detonated;

	public EntityConcussion(World worldIn) {
		super(worldIn);
	}


    public EntityConcussion(World world, EntityLivingBase shooter, int fuse) {
        this(world, shooter.posX, shooter.posY + (double)shooter.getEyeHeight() - 0.10000000149011612D, shooter.posZ);
        this.shootingEntity = shooter;
        this.fuse = fuse;
 
    }

	public EntityConcussion(World worldIn, double x, double y, double z) {
        this(worldIn);
        this.setPosition(x, y, z);
    }


	@Override
	public void onUpdate(){
		super.onUpdate();
	}
		
	@Override
	protected float getGravityVelocity()
    {
        return 0.05F;
    }
	 
	 
	@Override
	protected void onImpact(RayTraceResult result) {
		if (result.typeOfHit.equals(RayTraceResult.Type.BLOCK)){
			this.motionX *= -0.10000000149011612D;
            this.motionY *= -0.10000000149011612D;
            this.motionZ *= -0.10000000149011612D;
            this.rotationYaw += 180.0F;
            this.prevRotationYaw += 180.0F;
		}
		if (result.typeOfHit.equals(RayTraceResult.Type.ENTITY)){
			if(this.shootingEntity instanceof EntityPlayer){
				result.entityHit.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.shootingEntity), 0.1F);
			}
		}
		
		for (BlockPos pos : this.worldObj.createExplosion((Entity)null, this.lastTickPosX, this.lastTickPosY, this.lastTickPosZ, 2.5F, false).getAffectedBlockPositions()){
			List<EntityLivingBase> players = this.getEntityWorld().getEntitiesWithinAABB(EntityLivingBase.class, new AxisAlignedBB(pos));
			for (EntityLivingBase player : players){
				player.addPotionEffect(new PotionEffect(Potion.getPotionById(9), 120, 5));
				player.addPotionEffect(new PotionEffect(Potion.getPotionById(2), 60, 5));
			}
		}
		if(!this.worldObj.isRemote){
				this.setDead();
		}
	}
}
