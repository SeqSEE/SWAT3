package com.mch.swat3.item;

import javax.annotation.Nullable;

import com.mch.swat3.creativetab.SWATCreativeTabs;
import com.mch.swat3.init.SWATItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.item.IItemPropertyGetter;
import net.minecraft.item.Item;
import net.minecraft.item.ItemShield;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SWATShield extends ItemShield{

	public SWATShield(String name) {
        this.maxStackSize = 1;
		this.setRegistryName(name.toLowerCase());
		this.setUnlocalizedName(name.toLowerCase());
		addToItems(this);
        this.setMaxDamage(336);
        this.addPropertyOverride(new ResourceLocation("blocking"), new IItemPropertyGetter() {
            @SideOnly(Side.CLIENT)
            public float apply(ItemStack stack, @Nullable World worldIn, @Nullable EntityLivingBase entityIn) {
                return entityIn != null && entityIn.isHandActive() && entityIn.getActiveItemStack() == stack ? 1.0F : 0.0F;
            }
        });
    }

private void addToItems(Item item) {
	SWATItems.items.add(item);		
}

@Override
public String getItemStackDisplayName(ItemStack stack) {
	return "Riot Shield";
}

@Override
@SideOnly(Side.CLIENT)
public CreativeTabs getCreativeTab() {
    return SWATCreativeTabs.SWATArmor;
}

@Override
public boolean getIsRepairable(ItemStack toRepair, ItemStack repair) {
        return false;
}
}
