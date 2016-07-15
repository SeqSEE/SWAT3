package com.mch.swat3.creativetab;

import com.mch.swat3.init.SWATItems;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class SWATCreativeTabs extends CreativeTabs {
	public SWATCreativeTabs(int index, String label) {
		super(index, label);
	}

	public static final SWATCreativeTabs SWATCombat = new SWATCreativeTabs(CreativeTabs.getNextID(), "swatcombat") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return SWATItems.AK_47;
		}
	};
	public static final SWATCreativeTabs SWATHealing = new SWATCreativeTabs(CreativeTabs.getNextID(), "swathealing") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return SWATItems.AK_47_HANDLE;
		}
	};
	public static final SWATCreativeTabs SWATParts = new SWATCreativeTabs(CreativeTabs.getNextID(), "swatparts") {
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
