package com.mch.swat3.item.gun;

import java.util.List;

import javax.annotation.Nullable;

import com.mch.swat3.creativetab.SWATCreativeTabs;
import com.mch.swat3.init.SWATItems;
import com.mch.swat3.item.SWATAmmo;
import com.mch.swat3.item.SWATItem;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.InventoryHelper;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemBow;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumHand;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GunBase extends ItemBow{

	public GunBase(String name, int maxStack) {
		this.setRegistryName(name.toLowerCase());
		this.setUnlocalizedName(name.toLowerCase());
		this.setCreativeTab(SWATCreativeTabs.SWATWeapons);
		this.addPropertyOverride(new ResourceLocation("aiming"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
		this.addPropertyOverride(new ResourceLocation("active"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
		this.addPropertyOverride(new ResourceLocation("active_aiming"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
		addToItems(this);
	}

	private void addToItems(Item item) {
		SWATItems.items.add(this);
	}
	
		
	@Override
	public EnumActionResult onItemUse(ItemStack stack, EntityPlayer playerIn, World worldIn, BlockPos pos, EnumHand hand, EnumFacing facing, float hitX, float hitY, float hitZ)
    {
        return EnumActionResult.FAIL;
    }
	@Override
	protected boolean isArrow(@Nullable ItemStack stack){
        return stack != null && stack.getItem() instanceof SWATAmmo;
    }
	
    public ActionResult<ItemStack> onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn, EnumHand hand)
    {
    	/*
        boolean flag = this.findAmmo(playerIn) != null;

        ActionResult<ItemStack> ret = net.minecraftforge.event.ForgeEventFactory.onArrowNock(itemStackIn, worldIn, playerIn, hand, flag);
        if (ret != null) return ret;

        if (!playerIn.capabilities.isCreativeMode && !flag)
        {
            return !flag ? new ActionResult(EnumActionResult.FAIL, itemStackIn) : new ActionResult(EnumActionResult.PASS, itemStackIn);
        }
        else
        {
        */
            playerIn.setActiveHand(hand);
            return new ActionResult(EnumActionResult.SUCCESS, itemStackIn);
        }
    
	
	
	@Override
	public void onPlayerStoppedUsing(ItemStack stack, World worldIn, EntityLivingBase entityLiving, int timeLeft) {
		
    }


}
