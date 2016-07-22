package com.mch.swat3.client.renderer.entity;


import com.mch.swat3.entity.EntityConcussion;
import com.mch.swat3.entity.EntityFlashbang;


import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.RenderItem;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;

public class RenderEntityConcussion extends Render<EntityConcussion>{
	
	
	private Item item;
	private RenderItem itemRenderer;


	public RenderEntityConcussion(RenderManager renderManager, Item item) {
		super(renderManager);
		this.item = item;
		this.itemRenderer = Minecraft.getMinecraft().getRenderItem();

	}
	

	@Override
	public void doRender(EntityConcussion entity, double x, double y, double z, float entityYaw, float partialTicks) {
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

	private ItemStack getStackToRender(EntityConcussion entity) {
		
		return new ItemStack(this.item);
	}



	@Override
	protected ResourceLocation getEntityTexture(EntityConcussion entity) {
		
		return this.item.getRegistryName();
	}
}
