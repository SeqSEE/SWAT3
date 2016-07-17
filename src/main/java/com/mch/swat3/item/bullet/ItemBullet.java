package com.mch.swat3.item.bullet;

import com.mch.swat3.creativetab.SWATCreativeTabs;
import com.mch.swat3.entity.EntityBullet;
import com.mch.swat3.init.SWATItems;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityTippedArrow;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArrow;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

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

