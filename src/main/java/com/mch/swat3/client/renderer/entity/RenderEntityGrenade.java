package com.mch.swat3.client.renderer.entity;

import com.mch.swat3.entity.EntityGrenade;
import com.mch.swat3.init.SWATItems;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RenderEntityGrenade extends Render<EntityGrenade>{

	private RenderItem itemRenderer;

	public RenderEntityGrenade(RenderManager renderManager) {
		super(renderManager);
	}

	@Override
	protected ResourceLocation getEntityTexture(EntityGrenade entity) {
		
		return null;
	}

}