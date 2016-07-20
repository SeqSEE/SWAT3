package com.mch.swat3.item.gun;

import java.util.List;

import javax.annotation.Nullable;

import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;

public class HeavyMachineGun extends GunBase{

	public HeavyMachineGun(String name) {
		super(name);
		// TODO Auto-generated constructor stub
	}

	@Override
	public EnumAction getItemUseAction(ItemStack stack)
    {
        return EnumAction.BLOCK;
    }
}
