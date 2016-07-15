package com.mch.swat3.item.explosive.grenade;

import com.mch.swat3.creativetab.SWATCreativeTabs;
import com.mch.swat3.item.SWATItem;

public class ExplosivePart extends SWATItem{

	public ExplosivePart(String name, int maxStack) {
		super(name, maxStack);
		this.setCreativeTab(SWATCreativeTabs.SWATParts);
	}

}
