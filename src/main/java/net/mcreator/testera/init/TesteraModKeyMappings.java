
/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.testera.init;

import org.lwjgl.glfw.GLFW;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.testera.network.JetpackUpMessage;
import net.mcreator.testera.TesteraMod;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class TesteraModKeyMappings {
	public static final KeyMapping JETPACK_UP = new KeyMapping("key.testera.jetpack_up", GLFW.GLFW_KEY_SPACE, "key.categories.movement") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				TesteraMod.PACKET_HANDLER.sendToServer(new JetpackUpMessage(0, 0));
				JetpackUpMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				JETPACK_UP_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - JETPACK_UP_LASTPRESS);
				TesteraMod.PACKET_HANDLER.sendToServer(new JetpackUpMessage(1, dt));
				JetpackUpMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long JETPACK_UP_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(JETPACK_UP);
	}

	@Mod.EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(TickEvent.ClientTickEvent event) {
			if (Minecraft.getInstance().screen == null) {
				JETPACK_UP.consumeClick();
			}
		}
	}
}
