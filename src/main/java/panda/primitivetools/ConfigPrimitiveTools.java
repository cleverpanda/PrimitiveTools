package panda.primitivetools;

import net.minecraftforge.common.config.Configuration;

public class ConfigPrimitiveTools {

	public static float toolSpeedModifier;
	public static float knappingModifier;
	
	public static int flintSandDropChance;
	public static int flintGravelDropChance;
	public static int fiberDropChance;
	public static int vineDropChance;
	
	public static float HatchetSpeedModifier;
	public static float KnifeSpeedModifier;
	public static float PickSpeedModifier;
	public static float HammerSpeedModifier;
	public static float SpadeSpeedModifier;
	
	private ConfigPrimitiveTools(){PrimitiveTools.logger.info("Loading Config");}
	
	public static void load(Configuration config) {
		config.load();
		
		toolSpeedModifier = config.getFloat("toolSpeedModifier", "general", 1f, 0f, 10f, "Global tool speed modifier. Set to 1 if using individual multipliers");
		HatchetSpeedModifier = config.getFloat("HatchetSpeedModifier", "general", 1f, 0f, 10f, "Hatchet tool speed modifier.");
		KnifeSpeedModifier = config.getFloat("KnifeSpeedModifier", "general", 1f, 0f, 10f, "Knife tool speed modifier.");
		PickSpeedModifier = config.getFloat("PickSpeedModifier", "general", 1f, 0f, 10f, "Pick tool speed modifier.");
		HammerSpeedModifier = config.getFloat("HammerSpeedModifier", "general", 1f, 0f, 10f, "Hammer tool speed modifier.");
		SpadeSpeedModifier = config.getFloat("SpadeSpeedModifier", "general", 1f, 0f, 10f, "Spade tool speed modifier.");
		
		knappingModifier = config.getFloat("knappingFailureModifier", "general", 0.45F, 0f, 1f, "decimal percent chance knapping will fail");
		flintSandDropChance = config.getInt("flintSandDropChance", "general", 8, 0, 100, "Base 1/x chance flint will drop from sand");
		flintGravelDropChance = config.getInt("flintGravelDropChance", "general", 8, 0, 100, "Base 1/x chance flint will drop from gravel");
		fiberDropChance = config.getInt("fiberDropChance", "general", 5, 0, 100, "Base 1/x chance fiber will drop from plants");
		vineDropChance  = config.getInt("vineDropChance", "general", 4, 0, 100, "1/x Chance vines will drop when using a knife");
		if (config.hasChanged()) config.save(); 
	}
}
