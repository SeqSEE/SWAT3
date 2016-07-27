package com.mch.swat3.util;

import com.mch.swat3.item.gun.GunBase;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumHand;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class KeyBindMessage implements IMessage {

	public KeyBindMessage() {
	}

	// 1 = reload
	private int type;

	public KeyBindMessage setType(int type) {
		this.type = type;
		return this;
	}

	public static class KeyBindMessageHandler implements IMessageHandler<KeyBindMessage, IMessage> {

		@Override
		public IMessage onMessage(KeyBindMessage message, MessageContext ctx) {
			switch (message.type) {
			case 1:
				EntityPlayer player = ctx.getServerHandler().playerEntity;
				World world = player.getEntityWorld();
				ItemStack newStack = player.getHeldItemMainhand();
				if (newStack != null) {
					if (newStack.getItem() instanceof GunBase){
						newStack.setItemDamage(newStack.getMaxDamage() * -1);
						player.setHeldItem(EnumHand.MAIN_HAND, newStack);
					}
				}
				break;
			default:
				break;
			}
			return null;
		}

	}

	@Override
	public void fromBytes(ByteBuf buf) {
		this.type = buf.readInt();
	}

	@Override
	public void toBytes(ByteBuf buf) {
		buf.writeInt(this.type);

	}
}
