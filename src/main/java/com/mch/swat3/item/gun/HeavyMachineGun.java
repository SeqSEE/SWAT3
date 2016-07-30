package com.mch.swat3.item.gun;

import java.util.List;

import javax.annotation.Nullable;

import com.mch.swat3.init.SWATItems;

import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class HeavyMachineGun extends GunBase{

	public HeavyMachineGun(String name) {
		super(name);
		addToItems(this);
	}

	private void addToItems(Item gun) {
		SWATItems.items.add(gun);
		
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BLOCK;
    }
}
