package com.mch.swat3.init;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SWATCreativeTabs extends CreativeTabs {
	public SWATCreativeTabs(int index, String label) {
		super(index, label);
	}

	public static final SWATCreativeTabs SWATWeapons = new SWATCreativeTabs(CreativeTabs.getNextID(), "ngcombat") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return SWATItems.AK_47_HANDLE;
		}
	};

	@Override
	public Item getTabIconItem() {

		return null;
	}

}
