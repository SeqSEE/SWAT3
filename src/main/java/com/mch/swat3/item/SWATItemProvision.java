package com.mch.swat3.item;

import com.mch.swat3.creativetab.SWATCreativeTabs;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;


public class SWATItemProvision extends SWATItem{
	
	public enum PackType{
		SMALL, MEDIUM, LARGE
	}

	private PackType type;
	private float healAmount;
	public SWATItemProvision(String name, int maxStack, PackType type) {
		super(name, maxStack);
		this.setCreativeTab(SWATCreativeTabs.SWATProvisions);
		this.type = type;
		
	}
	@Override
	public ActionResult<ItemStack> onItemRightClick(ItemStack stack, World world, EntityPlayer player, EnumHand hand){
	    this.healAmount = 0.0F;
		if (this.type != null){
	    	switch(this.type){
	    	case SMALL:
	    		this.healAmount = 5.0F;
	    		break;
	    	case MEDIUM:
	    		this.healAmount = 10.0F;
	    		break;
	    	case LARGE:
	    		this.healAmount = 20.0F;
	    		break;
			default:
				break;
	    	}
	    }
		
		player.heal(this.healAmount); //the number of half-hearts you want to heal
	    stack.stackSize --;
	    if (stack.stackSize == 0){
	        player.inventory.deleteStack(stack);
	    }
	    return new ActionResult(EnumActionResult.PASS, stack);
	}

}
