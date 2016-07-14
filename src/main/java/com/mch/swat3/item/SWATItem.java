package com.mch.swat3.item;

import com.mch.swat3.init.SWATCreativeTabs;
import com.mch.swat3.init.SWATItems;

import net.minecraft.item.Item;

public class SWATItem extends Item{
	
	public SWATItem(String name, int maxStack){
		this.setRegistryName(name.toLowerCase());
		this.setUnlocalizedName(name.toLowerCase());
		this.setMaxStackSize(maxStack);
		this.setCreativeTab(SWATCreativeTabs.SWATParts);
		addToItems(this);
	}

	private void addToItems(Item item) {
		SWATItems.items.add(this);
		
	}

}
