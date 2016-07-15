package com.mch.swat3.item;

import com.mch.swat3.creativetab.SWATCreativeTabs;

import net.minecraft.item.ItemFood;

public class SWATItemProvision extends ItemFood{

	public SWATItemProvision(String name, int maxStack, int amount, float saturation, boolean isWolfFood) {
		super(amount, saturation, isWolfFood);
		this.setCreativeTab(SWATCreativeTabs.SWATProvisions);
	}


}
