package com.mch.swat3.stats;

import com.mch.swat3.init.SWATItems;

import net.minecraft.item.ItemStack;
import net.minecraft.stats.Achievement;
import net.minecraft.stats.AchievementList;
import net.minecraftforge.common.AchievementPage;

public class SWATAchievement {
	
	public static final Achievement TheSWATExperience = new Achievement(
			"TheSWATExperience", "theswatexperience", 0, 1,
			new ItemStack(SWATItems.STEEL, 1),
			AchievementList.OPEN_INVENTORY).registerStat();

	
	
	public static AchievementPage SWATAchievePage = new AchievementPage(
			"SWAT³", TheSWATExperience);

}
