package com.mch.swat3.item;

import javax.annotation.Nullable;

import com.mch.swat3.creativetab.SWATCreativeTabs;
import com.mch.swat3.init.SWATItems;
import com.mch.swat3.item.GunAmmo.AmmoType;
import com.mch.swat3.item.gun.GunBase;

import net.minecraft.item.Item;

public class GunClip extends Item {

	private AmmoType ammo;
	private int maxAmmo;

	public GunClip(String name, int maxAmmo, AmmoType ammo, Item gun) {
		this.setRegistryName(name);
		this.setUnlocalizedName(name);
		this.ammo = ammo;
		this.maxAmmo = maxAmmo;
		this.setCreativeTab(SWATCreativeTabs.SWATWeapons);
		SWATItems.addClipsToGuns(gun, this);
	}

}
