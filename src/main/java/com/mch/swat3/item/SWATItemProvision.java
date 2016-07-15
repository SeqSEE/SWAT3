package com.mch.swat3.item;

import com.mch.swat3.creativetab.SWATCreativeTabs;


public class SWATItemProvision extends SWATItem{

	public SWATItemProvision(String name, int maxStack) {
		super(name, maxStack);
		this.setCreativeTab(SWATCreativeTabs.SWATProvisions);
	}


}
