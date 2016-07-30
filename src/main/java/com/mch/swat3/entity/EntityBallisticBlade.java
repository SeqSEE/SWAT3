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

public class EntityBallisticBlade extends EntityThrowable{
	
	private EntityLivingBase shootingEntity;
	private boolean impacted;

	public EntityBallisticBlade(World worldIn) {
		super(worldIn);
	}


    public EntityBallisticBlade(World world, EntityLivingBase shooter, int fuse) {
        this(world, shooter.posX, shooter.posY + (double)shooter.getEyeHeight() - 0.10000000149011612D, shooter.posZ);
        this.shootingEntity = shooter;
 
    }

	public EntityBallisticBlade(World worldIn, double x, double y, double z) {
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
		if (!this.impacted){
			if (result.typeOfHit.equals(RayTraceResult.Type.BLOCK)){
				this.motionX *= -0.10000000149011612D;
	            this.motionY *= -0.10000000149011612D;
	            this.motionZ *= -0.10000000149011612D;
	            this.rotationYaw += 180.0F;
	            this.prevRotationYaw += 180.0F;
	            this.impacted = true;
			}	
		}
		
		if (result.typeOfHit.equals(RayTraceResult.Type.ENTITY)){
			if(result.entityHit instanceof EntityLivingBase){
				if (result.entityHit == this.getThrower()){
					result.entityHit.attackEntityFrom(new DamageSource("balistic_knife.suicide"), this.getGravityVelocity() * 2.0F);
				}
				else{
					result.entityHit.attackEntityFrom(new DamageSource("balistic_knife"), this.getGravityVelocity() * 2.0F);
				}
			}
		}
		
		if(!this.worldObj.isRemote){
				this.setDead();
		}
	}
}
