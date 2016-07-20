package com.mch.swat3.item.bullet;



import com.mch.swat3.creativetab.SWATCreativeTabs;
import com.mch.swat3.init.SWATItems;

import net.minecraft.item.Item;
import net.minecraft.item.ItemArrow;

public class ItemBullet extends ItemArrow{

	public ItemBullet(String name){
		this.setRegistryName(name.toLowerCase());
		this.setUnlocalizedName(name.toLowerCase());
		this.setCreativeTab(SWATCreativeTabs.SWATWeapons);
		addToItems(this);
	}

	private void addToItems(Item item) {
		SWATItems.items.add(this);
		
	}
	

}

