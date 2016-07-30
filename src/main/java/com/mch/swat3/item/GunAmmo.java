package com.mch.swat3.item;

import com.mch.swat3.creativetab.SWATCreativeTabs;

public class GunAmmo extends SWATItem{
	
	//Used to determine if gun can take ammo
	public enum AmmoType {
		SNIPER, SHOTGUN, HMG, LMG, PISTOL, BALISTIC_KNIFE
	}
	private AmmoType ammoType;
	public GunAmmo(String name, int maxStack, AmmoType type) {
		super(name, maxStack);
		this.setCreativeTab(SWATCreativeTabs.SWATWeapons);
		this.ammoType = type;
	}
	
	

}
