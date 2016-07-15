package com.mch.swat3.item.gun;

import com.mch.swat3.creativetab.SWATCreativeTabs;
import com.mch.swat3.item.SWATItem;

public class GunBase extends SWATItem{

	public GunBase(String name, int maxStack) {
		super(name, maxStack);
		this.setCreativeTab(SWATCreativeTabs.SWATCombat);
	
	}

}
