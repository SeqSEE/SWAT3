package com.mch.swat3.item;

import com.mch.swat3.creativetab.SWATCreativeTabs;

public class SWATAmmo extends SWATItem{
	
	//Used to determine if gun can take ammo
	public enum AmmoType {
		SNIPER, SHOTGUN, HMG, LMG, SMG, PISTOL, BALISTIC_KNIFE
	}
	private AmmoType ammoType;
	public SWATAmmo(String name, int maxStack, AmmoType type) {
		super(name, maxStack);
		this.setCreativeTab(SWATCreativeTabs.SWATWeapons);
		this.ammoType = type;
	}
	
	

}
