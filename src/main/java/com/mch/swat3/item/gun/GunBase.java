package com.mch.swat3.item.gun;

import javax.annotation.Nullable;

import com.mch.swat3.creativetab.SWATCreativeTabs;
import com.mch.swat3.item.SWATItem;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.EnumAction;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class GunBase extends SWATItem{

	public GunBase(String name, int maxStack) {
		super(name, maxStack);
		this.setCreativeTab(SWATCreativeTabs.SWATWeapons);
		this.addPropertyOverride(new ResourceLocation("aiming"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
	}
	
	@Override
	 public EnumAction getItemUseAction(ItemStack stack) {
	        return EnumAction.BOW;
	    }

}
