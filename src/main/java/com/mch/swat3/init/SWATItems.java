package com.mch.swat3.init;

import java.util.ArrayList;
import java.util.List;

import com.mch.swat3.item.SWATItemArmor;
import com.mch.swat3.item.SWATItemProvision;
import com.mch.swat3.item.SWATMelee;
import com.mch.swat3.item.SWATProjectile;
import com.mch.swat3.item.SWATShield;
import com.mch.swat3.item.explosive.grenade.ExplosivePart;
import com.mch.swat3.item.explosive.grenade.GrenadeConcussion;
import com.mch.swat3.item.explosive.grenade.GrenadeFlashBang;
import com.mch.swat3.item.explosive.grenade.GrenadePipeBomb;
import com.mch.swat3.item.explosive.grenade.GrenadeSmoke;
import com.mch.swat3.item.gun.AssualtRifle;
import com.mch.swat3.item.gun.SWATAmmo;
import com.mch.swat3.item.gun.GunParts;
import com.mch.swat3.item.gun.Pistol;
import com.mch.swat3.item.gun.Rifle;
import com.mch.swat3.item.gun.SMG;
import com.mch.swat3.item.gun.Shotgun;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class SWATItems {

	public static List<Item> items = new ArrayList();
	
	public static Item SNIPER = new Rifle("SNIPER", 1);
	public static Item SHOTGUN = new Shotgun("SHOTGUN", 1);
	public static Item AK_47 = new AssualtRifle("AK_47", 1);
	public static Item MP_5 = new SMG("MP_5", 1);
	public static Item GLOCK = new Pistol("GLOCK", 1);
	public static Item BALLISTIC_KNIFE = new SWATProjectile("BALLISTIC_KNIFE", 1);
	public static Item NIGHTSTICK = new SWATMelee("NIGHTSTICK", 1);
	
	public static Item SNIPER_CLIP = new SWATAmmo("SNIPER_CLIP", 5, 30);
	public static Item SHOTGUN_MAGAZINE = new SWATAmmo("SHOTGUN_MAGAZINE", 1, 10);
	public static Item AK_47_CLIP = new SWATAmmo("AK_47_CLIP", 5, 30);
	public static Item MP_5_CLIP = new SWATAmmo("MP_5_CLIP", 5, 30);
	public static Item GLOCK_CLIP = new SWATAmmo("GLOCK_CLIP", 5, 15);
	public static Item BALLISTIC_KNIFE_BLADE = new SWATAmmo("BALLISTIC_KNIFE_BLADE", 15, 1);
		
	public static Item SNIPER_BACK = new GunParts("SNIPER_BACK", 1);
	public static Item SNIPER_BARREL = new GunParts("SNIPER_BARREL", 1);
	public static Item SNIPER_BODY = new GunParts("SNIPER_BODY", 1);
	public static Item SNIPER_STOCK = new GunParts("SNIPER_STOCK", 1);
	public static Item SNIPER_SUPPORT = new GunParts("SNIPER_SUPPORT", 1);
	public static Item SNIPER_SCOPE = new GunParts("SNIPER_SCOPE", 1);
		
	public static Item AK_47_BODY = new GunParts("AK_47_BODY", 1);
	public static Item AK_47_GRIP = new GunParts("AK_47_GRIP", 1);
	public static Item AK_47_STOCK = new GunParts("AK_47_STOCK", 1);
	public static Item AK_47_BARREL = new GunParts("AK_47_BARREL", 1);
	public static Item AK_47_BARREL_HOUSING = new GunParts("AK_47_BARREL_HOUSING", 1);
		
	public static Item HEALTH_PACK_SMALL = new SWATItemProvision("HEALTH_PACK_SMALL", 10);
	public static Item HEALTH_PACK_MEDIUM = new SWATItemProvision("HEALTH_PACK_MEDIUM", 5);
	public static Item HEALTH_PACK_LARGE = new SWATItemProvision("HEALTH_PACK_LARGE", 1);
	
	public static Item GLOCK_HANDLE = new GunParts("GLOCK_HANDLE", 1);
	public static Item GLOCK_SLIDE = new GunParts("GLOCK_SLIDE", 1);
	
	public static Item MP_5_BODY = new GunParts("MP_5_BODY", 1);
	public static Item MP_5_GRIP = new GunParts("MP_5_GRIP", 1);
	
	public static Item SHOTGUN_BARREL_0 = new GunParts("SHOTGUN_BARREL_0", 1);
	public static Item SHOTGUN_BARREL_1 = new GunParts("SHOTGUN_BARREL_1", 1);
	public static Item SHOTGUN_BODY = new GunParts("SHOTGUN_BODY", 1);
	public static Item SHOTGUN_GRIP = new GunParts("SHOTGUN_GRIP", 1);
	
	public static Item SWAT_GEAR_BOOTS = new SWATItemArmor("SWAT_GEAR_BOOTS", SWATItemArmor.SWAT_GEAR, 1, EntityEquipmentSlot.FEET);
	public static Item SWAT_GEAR_PANTS = new SWATItemArmor("SWAT_GEAR_PANTS", SWATItemArmor.SWAT_GEAR, 1, EntityEquipmentSlot.LEGS);
	public static Item SWAT_GEAR_VEST = new SWATItemArmor("SWAT_GEAR_VEST", SWATItemArmor.SWAT_GEAR, 1, EntityEquipmentSlot.CHEST);
	public static Item SWAT_GEAR_CASK = new SWATItemArmor("SWAT_GEAR_CASK", SWATItemArmor.SWAT_GEAR, 1, EntityEquipmentSlot.HEAD);
	public static Item BULLETPROOF_VEST = new SWATItemArmor("BULLETPROOF_VEST", SWATItemArmor.BULLETPROOF_VEST, 1, EntityEquipmentSlot.CHEST);
	public static Item RIOT_SHIELD = new SWATShield("RIOT_SHIELD");
	
	public static Item GRENADE_CONCUSSION = new GrenadeConcussion("GRENADE_CONCUSSION", 4);
	public static Item GRENADE_FLASHBANG = new GrenadeFlashBang("GRENADE_FLASHBANG", 4);
	public static Item GRENADE_SMOKE = new GrenadeSmoke("GRENADE_SMOKE", 4);
	public static Item PIPE_BOMB = new GrenadePipeBomb("PIPE_BOMB", 1);
	public static Item IRON_PIPE = new ExplosivePart("IRON_PIPE", 1);
	public static Item IRON_PIPE_CAP = new ExplosivePart("IRON_PIPE_CAP", 1);
		
		
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
