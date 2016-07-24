package com.mch.swat3.item;

import com.mch.swat3.creativetab.SWATCreativeTabs;
import com.mch.swat3.init.SWATItems;

import net.minecraft.item.Item;

public class SWATItem extends Item{
	
	public SWATItem(String name, int maxStack){
		this.setRegistryName(name.toLowerCase());
		this.setUnlocalizedName(name.toLowerCase());
		this.setMaxStackSize(maxStack);
		addToItems(this);
		this.setCreativeTab(SWATCreativeTabs.SWATParts);
	}

	private void addToItems(Item item) {
		SWATItems.items.add(this);
		
	}

}
