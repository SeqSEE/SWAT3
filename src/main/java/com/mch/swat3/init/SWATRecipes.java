package com.mch.swat3.init;

import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class SWATRecipes {
	
	public static void registerRecipes(FMLPreInitializationEvent preEvent){
		/*
		 * AK-47 
		 * Shapeless recipe
		 */
		GameRegistry.addShapelessRecipe(new ItemStack(SWATItems.AK_47),
				new ItemStack(SWATItems.AK_47_BARREL),
				new ItemStack(SWATItems.AK_47_BARREL_HOUSING),
				new ItemStack(SWATItems.AK_47_BODY),
				new ItemStack(SWATItems.AK_47_CLIP),
				new ItemStack(SWATItems.AK_47_GRIP),
				new ItemStack(SWATItems.AK_47_STOCK));
		/*
		 * Glock 
		 * Shapeless recipe
		 */
		GameRegistry.addShapelessRecipe(new ItemStack(SWATItems.GLOCK),
				new ItemStack(SWATItems.GLOCK_CLIP),
				new ItemStack(SWATItems.GLOCK_GRIP),
				new ItemStack(SWATItems.GLOCK_SLIDE));
		/*
		 * MP-5 
		 * Shapeless recipe
		 */
		GameRegistry.addShapelessRecipe(new ItemStack(SWATItems.MP_5),
				new ItemStack(SWATItems.MP_5_BODY),
				new ItemStack(SWATItems.MP_5_CLIP),
				new ItemStack(SWATItems.MP_5_GRIP));
		/*
		 * MSG-01 
		 * Shapeless recipe
		 */
		GameRegistry.addShapelessRecipe(new ItemStack(SWATItems.MSG_01),
				new ItemStack(SWATItems.MSG_01_BODY),
				new ItemStack(SWATItems.MSG_01_CLIP),
				new ItemStack(SWATItems.MSG_01_GRIP),
				new ItemStack(SWATItems.MSG_01_STOCK));
		/*
		 * Sniper
		 * Shapeless recipe
		 */
		GameRegistry.addShapelessRecipe(new ItemStack(SWATItems.SNIPER),
				new ItemStack(SWATItems.SNIPER_BACK),
				new ItemStack(SWATItems.SNIPER_BARREL),
				new ItemStack(SWATItems.SNIPER_BODY),
				new ItemStack(SWATItems.SNIPER_CLIP),
				new ItemStack(SWATItems.SNIPER_SCOPE),
				new ItemStack(SWATItems.SNIPER_STOCK),
				new ItemStack(SWATItems.SNIPER_SUPPORT));
		/*
		 * Shotgun
		 * Shapeless recipe
		 */
		GameRegistry.addShapelessRecipe(new ItemStack(SWATItems.SHOTGUN),
				new ItemStack(SWATItems.SHOTGUN_BARREL_0),
				new ItemStack(SWATItems.SHOTGUN_BARREL_1),
				new ItemStack(SWATItems.SHOTGUN_BODY),
				new ItemStack(SWATItems.SHOTGUN_GRIP),
				new ItemStack(SWATItems.SHOTGUN_MAGAZINE));
		
		
	}

}
