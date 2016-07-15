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

	public static final SWATCreativeTabs SWATWeapons = new SWATCreativeTabs(CreativeTabs.getNextID(), "swatweapons") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return SWATItems.AK_47;
		}
	};
	
	public static final SWATCreativeTabs SWATArmor = new SWATCreativeTabs(CreativeTabs.getNextID(), "swatarmor") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return SWATItems.BULLETPROOF_VEST;
		}
	};
	
	public static final SWATCreativeTabs SWATProvisions = new SWATCreativeTabs(CreativeTabs.getNextID(), "swatprovisions") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return SWATItems.HEALTH_PACK_LARGE;
		}
	};
	
	public static final SWATCreativeTabs SWATParts = new SWATCreativeTabs(CreativeTabs.getNextID(), "swatparts") {
		@SideOnly(Side.CLIENT)
		public Item getTabIconItem() {
			return SWATItems.AK_47_CHASIS;
		}
	};

	@Override
	public Item getTabIconItem() {
		return null;
	}

}
