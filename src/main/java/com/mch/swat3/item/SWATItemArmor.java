package com.mch.swat3.item;

import com.mch.swat3.creativetab.SWATCreativeTabs;
import com.mch.swat3.init.SWATItems;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraft.item.ItemArmor.ArmorMaterial;
import net.minecraftforge.common.util.EnumHelper;

public class SWATItemArmor extends ItemArmor {

	public static ArmorMaterial BULLETPROOF_VEST = EnumHelper.addArmorMaterial("BULLETPROOF_VEST", "swat3:bulletproof_vest", 7, new int[]{0, 0, 10, 0}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	public static ArmorMaterial SWAT_GEAR = EnumHelper.addArmorMaterial("SWAT_GEAR", "swat3:swat_gear", 7, new int[]{2, 5, 8, 2}, 15, SoundEvents.ITEM_ARMOR_EQUIP_LEATHER, 0.0F);
	
	public SWATItemArmor(String name, ArmorMaterial material, int renderIndex, EntityEquipmentSlot armorType) {
        super(material, renderIndex, armorType);
        this.setMaxStackSize(1);
        this.setRegistryName(name.toLowerCase());
		this.setUnlocalizedName(name.toLowerCase());
		this.setCreativeTab(SWATCreativeTabs.SWATArmor);
		addToItems(this);
	}

	private void addToItems(Item item) {
		SWATItems.items.add(item);
	}

}
