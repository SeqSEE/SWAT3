package com.mch.swat3.entity;

import com.mch.swat3.init.SWATItems;

import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityBlaze;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.text.TextComponentTranslation;
import net.minecraft.util.text.translation.I18n;
import net.minecraft.world.World;

public class EntityGunSlug extends EntityThrowable{

	
	private ResourceLocation SLUG_TEX_PATH = new ResourceLocation("textures/items/gun_slug");
	private EntityLivingBase shootingEntity;
	private int ticksInGround;
	private int xTile;
	private int yTile;
	private int zTile;
	private Block inTile;

	public EntityGunSlug(World worldIn) {
		super(worldIn);
		this.setSize(0.05F, 0.05F);
	}


    public EntityGunSlug(World worldIn, EntityLivingBase shooter) {
        this(worldIn, shooter.posX, shooter.posY + (double)shooter.getEyeHeight() - 0.10000000149011612D, shooter.posZ);
        this.shootingEntity = shooter;
    }

	public EntityGunSlug(World worldIn, double x, double y, double z) {
        this(worldIn);
        this.setPosition(x, y, z);
    }


	@Override
	public void onUpdate(){
		super.onUpdate();
	}
	 
	 
	@Override
	protected void onImpact(RayTraceResult result) {
		 if (result.entityHit != null) {
			 		result.entityHit.attackEntityFrom(DamageSource.causePlayerDamage((EntityPlayer) this.shootingEntity), 6.0F);
			 		for (int j = this.rand.nextInt(4); j < 8; ++j) {
			            this.worldObj.spawnParticle(EnumParticleTypes.FIREWORKS_SPARK, this.posX, this.posY, this.posZ, 0.0D, 0.0D, 0.0D, new int[0]);
			        }
		 }
		 if (!this.worldObj.isRemote) {
			 this.setDead();
		 }
	}


	 


	

}
