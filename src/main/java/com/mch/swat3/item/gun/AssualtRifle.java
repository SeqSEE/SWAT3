package com.mch.swat3.item.gun;

import net.minecraft.item.EnumAction;
import net.minecraft.item.ItemStack;

public class AssualtRifle extends GunBase{

	public AssualtRifle(String name, int maxStack) {
		super(name, maxStack);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public EnumAction getItemUseAction(ItemStack stack){
        return EnumAction.BLOCK;
    }

}
