package com.mch.swat3.item;

import com.mch.swat3.creativetab.SWATCreativeTabs;

public class SWATAmmo extends SWATItem{

	public static int maxAmmo;
	public static int ammoCount; 
	public SWATAmmo(String name, int maxStack, int maxAmmo) {
		super(name, maxStack);
		this.setCreativeTab(SWATCreativeTabs.SWATWeapons);
		this.maxAmmo = maxAmmo;
	}

}
