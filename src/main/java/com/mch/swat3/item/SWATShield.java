package com.mch.swat3.item;

import com.mch.swat3.creativetab.SWATCreativeTabs;

public class SWATShield extends SWATItem{

	public SWATShield(String name, int maxStack) {
		super(name, maxStack);
		this.setCreativeTab(SWATCreativeTabs.SWATArmor);
	}

}
