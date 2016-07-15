package com.mch.swat3.init;

import java.util.ArrayList;
import java.util.List;

import com.mch.swat3.item.SWATItem;
import com.mch.swat3.item.explosive.ThrownBase;
import com.mch.swat3.item.explosive.grenade.GrenadeFlashBang;
import com.mch.swat3.item.gun.AssualtRifle;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SWATItems {

	public static List<Item> items = new ArrayList();
	public static Item AK_47_BUTT = new SWATItem("AK_47_BUTT", 1);
	public static Item AK_47_CHASIS = new SWATItem("AK_47_CHASIS", 1);
	public static Item AK_47_HANDLE = new SWATItem("AK_47_HANDLE", 1);
	public static Item AK_47_BARREL_HOUSING = new SWATItem("AK_47_BARREL_HOUSING", 1);
	public static Item AK_47_BARREL = new SWATItem("AK_47_BARREL", 1);
	public static Item AK_47 = new AssualtRifle("AK_47", 1);
	public static Item GRENADE_FLASHBANG = new GrenadeFlashBang("GRENADE_FLASHBANG", 5);
	public static Item BALLISTIC_KNIVE_BLADE = new SWATItem("BALLISTIC_KNIVE_BLADE", 1);

	
	
	
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
