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
		GameRegistry.addShapelessRecipe(new ItemStack(SWATItems.GLOCK),
				new ItemStack(SWATItems.GLOCK_CLIP),
				new ItemStack(SWATItems.GLOCK_GRIP),
				new ItemStack(SWATItems.GLOCK_SLIDE));
	}

}
