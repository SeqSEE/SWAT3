package com.mch.swat3.item.gun;

import com.mch.swat3.item.SWATItem;

public class GunAmmo extends SWATItem{

	public static int maxAmmo;
	public static int ammoCount; 
	public GunAmmo(String name, int maxStack, int maxAmmo) {
		super(name, maxStack);
		this.maxAmmo = maxAmmo;
	}

}
