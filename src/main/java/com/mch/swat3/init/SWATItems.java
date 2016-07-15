package com.mch.swat3.init;

import java.util.ArrayList;
import java.util.List;

import com.mch.swat3.item.SWATItemArmor;
import com.mch.swat3.item.SWATItemProvision;
import com.mch.swat3.item.SWATProjectile;
import com.mch.swat3.item.explosive.grenade.GrenadeFlashBang;
import com.mch.swat3.item.gun.AssualtRifle;
import com.mch.swat3.item.gun.GunParts;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SWATItems {

	public static List<Item> items = new ArrayList();
	public static Item AK_47_STOCK = new GunParts("AK_47_BUTT", 1);
	public static Item AK_47_BODY = new GunParts("AK_47_BODY", 1);
	public static Item AK_47_GRIP = new GunParts("AK_47_GRIP", 1);
	public static Item AK_47_BARREL_HOUSING = new GunParts("AK_47_BARREL_HOUSING", 1);
	public static Item AK_47_BARREL = new GunParts("AK_47_BARREL", 1);
	public static Item AK_47 = new AssualtRifle("AK_47", 1);
	public static Item GRENADE_FLASHBANG = new GrenadeFlashBang("GRENADE_FLASHBANG", 5);
	public static Item BALLISTIC_KNIFE_BLADE = new GunParts("BALLISTIC_KNIVE_BLADE", 1);
	public static Item BULLETPROOF_VEST = new SWATItemArmor("BULLETPROOF_VEST", 1);
	public static Item HEALTH_PACK_LARGE = new SWATItemProvision("HEALTH_PACK_LARGE", 1, 0, 0, false);
	public static Item BALLISTIC_KNIFE_EMPTY = new GunParts("BALLISTIC_KNIFE_EMPTY", 1);
	public static Item BALLISTIC_KNIFE = new SWATProjectile("BALLISTIC_KNIFE", 1);
	
	
	// Returns a list. Each Item Class should add the item(s) to this list.
	public static List<Item> itemList() {
		return items;
	}
	
	
	// For each Item in items add the item to the GameRegistry
	public static void register(FMLPreInitializationEvent preEvent) {
		for (Item item : itemList()){
			GameRegistry.register(item);
		}
	}
	
	// For each Item in items register the renderer
	public static void registerRender(FMLInitializationEvent event) {
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		for (Item item : itemList()){
    	renderItem.getItemModelMesher().register(item, 0, new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
		}
	}
}
