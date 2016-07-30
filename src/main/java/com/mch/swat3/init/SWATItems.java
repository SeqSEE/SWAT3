package com.mch.swat3.init;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Nullable;

import com.mch.swat3.Reference;
import com.mch.swat3.item.GunAmmo;
import com.mch.swat3.item.GunAmmo.AmmoType;
import com.mch.swat3.item.GunClip;
import com.mch.swat3.item.SWATItem;
import com.mch.swat3.item.SWATItemArmor;
import com.mch.swat3.item.SWATItemProvision;
import com.mch.swat3.item.SWATItemProvision.PackType;
import com.mch.swat3.item.SWATMelee;
import com.mch.swat3.item.SWATShield;
import com.mch.swat3.item.explosive.ExplosivePart;
import com.mch.swat3.item.explosive.grenade.GrenadeActive;
import com.mch.swat3.item.explosive.grenade.GrenadeActive.GrenadeType;
import com.mch.swat3.item.explosive.grenade.GrenadeInactive;
import com.mch.swat3.item.gun.AssualtRifle;
import com.mch.swat3.item.gun.BaslisticKnife;
import com.mch.swat3.item.gun.GunBase;
import com.mch.swat3.item.gun.GunPart;
import com.mch.swat3.item.gun.HeavyMachineGun;
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

	/*
	 * Items initialization class:
	 * 
	 * Each Item is added to ArrayList 'items' when it is initialized. Then the
	 * list is called using the itemList() method.
	 * 
	 */

	public static List<Item> items = new ArrayList();

	// These are entity textures as well as item textures.
	public static Item SLUG = new GunPart("slug", 64);
	public static Item BALLISTIC_KNIFE_BLADE = new GunAmmo("ballistick_knife_blade", 64, AmmoType.BALISTIC_KNIFE);
	public static Item GRENADE_FLASHBANG_ACTIVE = new GrenadeActive("grenade_flashbang_active", GrenadeType.FLASHBANG);
	public static Item GRENADE_SMOKE_ACTIVE = new GrenadeActive("grenade_smoke_active", GrenadeType.SMOKE);
	public static Item PIPE_BOMB_ACTIVE = new GrenadeActive("pipe_bomb_active", GrenadeType.PIPEBOMB);
	public static Item GRENADE_CONCUSSION_ACTIVE = new GrenadeActive("grenade_concussion_active",
			GrenadeType.CONCUSSION);
	
	// Bullets and Ammo and Clips
	public static Item SNIPER_BULLET = new GunAmmo("sniper_bullet", 3, AmmoType.SNIPER);
	public static Item SHOTGUN_SHELL = new GunAmmo("shotgun_shell", 24, AmmoType.SHOTGUN);
	public static Item HMG_BULLET = new GunAmmo("hmg_bullet", 64, AmmoType.HMG);
	public static Item LMG_BULLET = new GunAmmo("lmg_bullet", 60, AmmoType.LMG);
	public static Item PISTOL_BULLET = new GunAmmo("pistol_bullet", 60, AmmoType.PISTOL);

	// Guns
	public static Item MINIGUN = new HeavyMachineGun("minigun");
	public static Item SNIPER = new Rifle("sniper");
	public static Item SHOTGUN = new Shotgun("shotgun");
	public static Item AK_47 = new AssualtRifle("ak_47");
	public static Item MP_5 = new SMG("mp_5");
	public static Item MSG_01 = new SMG("msg_01");
	public static Item GLOCK = new Pistol("glock");;
	public static Item NIGHTSTICK = new SWATMelee("nightstick");
	public static Item BALLISTIC_KNIFE = new BaslisticKnife("ballistic_knife", 3, AmmoType.BALISTIC_KNIFE);

	public static Item SNIPER_CLIP = new GunClip("sniper_clip", 1, AmmoType.SNIPER, SNIPER);
	public static Item SHOTGUN_MAGAZINE = new GunClip("shotgun_magazine", 1, AmmoType.SHOTGUN, SHOTGUN);
	// Minigun??
	public static Item AK_47_CLIP = new GunClip("ak_47_clip", 1, AmmoType.LMG, AK_47);
	public static Item GLOCK_CLIP = new GunClip("glock_clip", 1, AmmoType.PISTOL, GLOCK);
	public static Item MP_5_CLIP = new GunClip("mp_5_clip", 1, AmmoType.PISTOL, MP_5);
	public static Item MSG_01_CLIP = new GunClip("msg_01_clip", 1, AmmoType.PISTOL, MSG_01);

	// Sniper Parts
	public static Item SNIPER_BACK = new GunPart("sniper_back", 1);
	public static Item SNIPER_BARREL = new GunPart("sniper_barrel", 1);
	public static Item SNIPER_BODY = new GunPart("sniper_body", 1);
	public static Item SNIPER_STOCK = new GunPart("sniper_stock", 1);
	public static Item SNIPER_SUPPORT = new GunPart("sniper_support", 1);
	public static Item SNIPER_SCOPE = new GunPart("sniper_scope", 1);

	// AK-47 Parts
	public static Item AK_47_BARREL = new GunPart("ak_47_barrel", 1);
	public static Item AK_47_BARREL_HOUSING = new GunPart("ak_47_barrel_housing", 1);
	public static Item AK_47_BODY = new GunPart("ak_47_body", 1);
	public static Item AK_47_GRIP = new GunPart("ak_47_grip", 1);
	public static Item AK_47_STOCK = new GunPart("ak_47_stock", 1);

	// Glock Parts
	public static Item GLOCK_GRIP = new GunPart("glock_grip", 1);
	public static Item GLOCK_SLIDE = new GunPart("glock_slide", 1);

	// MP-5 Parts
	public static Item MP_5_BODY = new GunPart("mp_5_body", 1);
	public static Item MP_5_GRIP = new GunPart("mp_5_grip", 1);

	// MSG-01 Parts
	public static Item MSG_01_BODY = new GunPart("msg_01_body", 1);
	public static Item MSG_01_GRIP = new GunPart("msg_01_grip", 1);
	public static Item MSG_01_STOCK = new GunPart("msg_01_stock", 1);

	// Shotgun Parts
	public static Item SHOTGUN_BARREL_0 = new GunPart("shotgun_barrel_0", 1);
	public static Item SHOTGUN_BARREL_1 = new GunPart("shotgun_barrel_1", 1);
	public static Item SHOTGUN_BODY = new GunPart("shotgun_body", 1);
	public static Item SHOTGUN_GRIP = new GunPart("shotgun_grip", 1);

	// Provisions
	public static Item HEALTH_PACK_SMALL = new SWATItemProvision("health_pack_small", 10, PackType.SMALL);
	public static Item HEALTH_PACK_MEDIUM = new SWATItemProvision("health_pack_medium", 5, PackType.MEDIUM);
	public static Item HEALTH_PACK_LARGE = new SWATItemProvision("health_pack_large", 1, PackType.LARGE);

	// Shields and Armor
	public static Item RIOT_SHIELD = new SWATShield("riot_shield");
	public static Item SWAT_GEAR_BOOTS = new SWATItemArmor("swat_gear_boots", SWATItemArmor.SWAT_GEAR, 1,
			EntityEquipmentSlot.FEET);
	public static Item SWAT_GEAR_PANTS = new SWATItemArmor("swat_gear_pants", SWATItemArmor.SWAT_GEAR, 1,
			EntityEquipmentSlot.LEGS);
	public static Item SWAT_GEAR_VEST = new SWATItemArmor("swat_gear_vest", SWATItemArmor.SWAT_GEAR, 1,
			EntityEquipmentSlot.CHEST);
	public static Item SWAT_GEAR_CASK = new SWATItemArmor("swat_gear_cask", SWATItemArmor.SWAT_GEAR, 1,
			EntityEquipmentSlot.HEAD);
	public static Item BULLETPROOF_VEST = new SWATItemArmor("bulletproof_vest", SWATItemArmor.BULLETPROOF_VEST, 1,
			EntityEquipmentSlot.CHEST);

	// Grenades
	public static Item GRENADE_CONCUSSION = new GrenadeInactive("grenade_concussion", GrenadeType.CONCUSSION);
	public static Item GRENADE_FLASHBANG = new GrenadeInactive("grenade_flashbang", GrenadeType.FLASHBANG);
	public static Item GRENADE_SMOKE = new GrenadeInactive("grenade_smoke", GrenadeType.SMOKE);
	public static Item PIPE_BOMB = new GrenadeInactive("pipe_bomb", GrenadeType.PIPEBOMB);


	// Misc Parts
	public static Item TRIGGER = new GunPart("trigger", 64);
	public static Item SPRING = new SWATItem("spring", 64);
	public static Item IRON_PIPE = new ExplosivePart("iron_pipe", 64);
	public static Item IRON_PIPE_CAP = new ExplosivePart("iron_pipe_cap", 64);
	public static Item STEEL_INGOT = new SWATItem("steel_ingot", 64);

	//This is called from inside the GunClip class
	public static void addClipsToGuns(@Nullable Item gun, Item clip) {
		if (gun != null){
			List<Item> gunlist = new ArrayList();
			if (!gunlist.contains(gun)){
				gunlist.add(((GunBase) gun).addToClips(clip));	
			}
			for(Item firearm : gunlist){
				items.add(firearm);
			}
		}
		items.add(clip);
		
		
	}
	

	// Returns the items as a list of Item
	public static List<Item> itemList() {
		return items;
	}

	// For each Item in items add the item to the GameRegistry
	public static void register(FMLPreInitializationEvent preEvent) {
		for (Item item : itemList()) {
			GameRegistry.register(item);
		}
	}

	// For each Item in items register the renderer
	public static void registerRender(FMLInitializationEvent event) {
		RenderItem renderItem = Minecraft.getMinecraft().getRenderItem();
		for (Item item : itemList()) {
			renderItem.getItemModelMesher().register(item, 0,
					new ModelResourceLocation(item.getRegistryName().toString(), "inventory"));
		}
	}
}
