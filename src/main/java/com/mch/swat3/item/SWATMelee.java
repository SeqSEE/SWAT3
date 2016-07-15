package com.mch.swat3.item;

import com.mch.swat3.creativetab.SWATCreativeTabs;

public class SWATMelee extends SWATItem{

	public SWATMelee(String name, int maxStack) {
		super(name, maxStack);
		this.setCreativeTab(SWATCreativeTabs.SWATWeapons);
	}

}
