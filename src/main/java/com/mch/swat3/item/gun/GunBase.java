package com.mch.swat3.item.gun;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.mch.swat3.creativetab.SWATCreativeTabs;
import com.mch.swat3.entity.EntityGunSlug;
import com.mch.swat3.init.SWATItems;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GunBase extends ItemBow {

	private List<Item> clips = new ArrayList();

	public GunBase addToClips(Item clip) {
		this.clips.add(clip);
		return this;
	}

	public GunBase(String name) {
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.setCreativeTab(SWATCreativeTabs.SWATWeapons);
		this.addPropertyOverride(new ResourceLocation("aiming"), new IItemPropertyGetter() {
			@SideOnly(Side.CLIENT)
			public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
				return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F
						: 0.0F;
			}
		});
	}
	

	@Override
	public void onUpdate(ItemStack stack, World world, Entity entity, int itemSlot, boolean isSelected) {
		if (stack.hasTagCompound()) {
			if (stack.getTagCompound().hasKey("firing")) {
				if (stack.getTagCompound().getInteger("firing") > 0) {
					stack.getTagCompound().setInteger("firing", stack.getTagCompound().getInteger("firing") - 1);
					for (int i = 0; i < 6; ++i) {
						if ((i % 6) == 0){
							if (!world.isRemote) {
								world.playSound((EntityPlayer) null, entity.posX, entity.posY, entity.posZ,
										SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.NEUTRAL, 1.5F, 10.0F);
								EntityGunSlug slug = new EntityGunSlug(world, (EntityLivingBase) entity);
								slug.setHeadingFromThrower(entity, entity.rotationPitch, entity.rotationYaw, 0.0F, 4.5F,
										1.0F);
								entity.getEntityWorld().spawnEntityInWorld(slug);

							}
						}
						
					}
				}
			}
		}

		else {
			stack.setTagCompound(new NBTTagCompound());
		}
	}


	@Override
	public EnumActionResult onItemUseFirst(ItemStack stack, EntityPlayer player, World world, BlockPos pos,
			EnumFacing side, float hitX, float hitY, float hitZ, EnumHand hand) {
		super.onItemUseFirst(stack, player, world, pos, side, hitX, hitY, hitZ, hand);
		if (stack.hasTagCompound()) {
			if (stack.getTagCompound().hasKey("hasFired")) {
				stack.getTagCompound().setBoolean("hasFired", true);
			} else {
				stack.getTagCompound().setBoolean("hasFired", true);
			}
		}
		return EnumActionResult.SUCCESS;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * net.minecraft.item.Item#showDurabilityBar(net.minecraft.item.ItemStack)
	 * 
	 * Shows the durability bar if the stack has the NBTTagCompund "hasFired"
	 * and it equals true This is mainly to prevent the Durability bar from
	 * rendering in the Creative Mode Inventory because I think it is ugly.
	 */
	public boolean showDurabilityBar(ItemStack stack) {
		boolean show;
		if (stack.hasTagCompound()) {
			if (stack.getTagCompound().hasKey("hasFired")) {
				show = stack.getTagCompound().getBoolean("hasFired");
			} else {
				show = false;
			}
		} else {
			stack.setTagCompound(new NBTTagCompound());
			show = false;
		}
		return show;
	}

	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand) {
		player.setActiveHand(hand);
		return new ActionResult(EnumActionResult.SUCCESS, stack);
	}

	public void onUsingTick(ItemStack stack, EntityLivingBase player, int count) {
		for (int i = 0; i < 2; ++i){
			if ((i % 2) == 0){
				if (stack.hasTagCompound()) {
					if (stack.getTagCompound().hasKey("firing")) {
						stack.getTagCompound().setInteger("firing", stack.getTagCompound().getInteger("firing") + 1);

					} else {
						stack.getTagCompound().setInteger("firing", 1);
					}
				}
			}
		}
		
	}

	@Override
	public boolean onEntitySwing(EntityLivingBase entity, ItemStack stack) {
		if (stack.hasTagCompound()) {
			if (stack.getTagCompound().hasKey("firing")) {
				stack.getTagCompound().setInteger("firing", stack.getTagCompound().getInteger("firing") + 1);
			}
		}
		return false;
	}

	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
		if (stack.hasTagCompound()) {
				stack.getTagCompound().setInteger("firing", 0);
		}
	}

}
