package com.mch.swat3.item.gun;

import com.mch.swat3.item.SWATItem;

public class SWATAmmo extends SWATItem{

	public static int maxAmmo;
	public static int ammoCount; 
	public SWATAmmo(String name, int maxStack, int maxAmmo) {
		super(name, maxStack);
		this.maxAmmo = maxAmmo;
	}

}
