package net.mcreator.testera.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.testera.network.TesteraModVariables;

public class JetpackOnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			boolean _setval = true;
			entity.getCapability(TesteraModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.JetpackOn = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}
}
