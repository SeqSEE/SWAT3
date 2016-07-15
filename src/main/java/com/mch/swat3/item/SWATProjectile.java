package com.mch.swat3.item;

import com.mch.swat3.creativetab.SWATCreativeTabs;
import com.mch.swat3.init.SWATItems;

public class SWATProjectile extends SWATItem{

	public SWATProjectile(String name, int maxStack) {
		super(name, maxStack);
		this.setCreativeTab(SWATCreativeTabs.SWATWeapons);
		
	}

}
