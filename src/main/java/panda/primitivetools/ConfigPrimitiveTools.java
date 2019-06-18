package panda.primitivetools;


import net.minecraftforge.common.config.Config;
import net.minecraftforge.common.config.Config.Comment;
import net.minecraftforge.common.config.Config.Name;
import net.minecraftforge.common.config.Config.RangeDouble;
import net.minecraftforge.common.config.Config.RangeInt;



public class ConfigPrimitiveTools {

	@Config(modid = PrimitiveTools.MODID, category = "toolSpeed")
	public static class toolSpeed {
		@Name("toolSpeedModifier")		@RangeDouble(min = 0f, max = 10f)	@Comment("Global tool speed modifier. Set to 1 if using individual multipliers.")
		public static double toolSpeedModifier = 1f;

		@Name("HatchetSpeedModifier")	@RangeDouble(min = 0f, max = 10f)	@Comment("Hatchet tool speed modifier.")
		public static double HatchetSpeedModifier = 1f;
		@Name("KnifeSpeedModifier")		@RangeDouble(min = 0f, max = 10f)	@Comment("Knife tool speed modifier.")
		public static double KnifeSpeedModifier = 1f;
		@Name("PickSpeedModifier")		@RangeDouble(min = 0f, max = 10f)	@Comment("Pick tool speed modifier.")
		public static double PickSpeedModifier = 1f;
		@Name("HammerSpeedModifier")	@RangeDouble(min = 0f, max = 10f)	@Comment("Hammer tool speed modifier.")
		public static double HammerSpeedModifier = 1f;
		@Name("SpadeSpeedModifier")		@RangeDouble(min = 0f, max = 10f)	@Comment("Spade tool speed modifier.")
		public static double SpadeSpeedModifier = 1f;
	}

	@Config(modid = PrimitiveTools.MODID, category = "chanceModifiers")
	public static class chanceModifiers {
		@Name("knappingModifier")		@RangeDouble(min = 0f, max = 1f)	@Comment("Decimal percent chance knapping will fail.")
		public static double knappingModifier = 0.45;

		@Name("flintSandDropChance")	@RangeInt(min = 0, max = 100)		@Comment("Base 1/x chance flint will drop from sand.")
		public static int flintSandDropChance = 8;
		@Name("flintGravelDropChance")	@RangeInt(min = 0, max = 100)		@Comment("Base 1/x chance flint will drop from gravel.")
		public static int flintGravelDropChance = 8;
		@Name("fiberDropChance")		@RangeInt(min = 0, max = 100)		@Comment("Base 1/x chance fiber will drop from plants")
		public static int fiberDropChance = 5;
		@Name("vineDropChance")			@RangeInt(min = 0, max = 100)		@Comment("1/x Chance vines will drop when using a knife")
		public static int vineDropChance = 4;
	}

	@Config(modid = PrimitiveTools.MODID, category = "materialDurability")
	public static class MaterialDurability {
		@Name("handles")	@Comment("Durability for handle materials")
		public static Handles handleDurability = new Handles();
		@Name("bindings")	@Comment("Durability for binding materials")
		public static Bindings bindingDurability = new Bindings();
		@Name("heads")		@Comment("Durability for head materials")
		public static Heads headDurability = new Heads();
		@Name("hammers")	@Comment("Durability for hammer materials")
		public static Hammers hammerDurability = new Hammers();

		public static class Handles {
			@Name("wood")	@RangeDouble(min = 0.0f, max = 10.0f)	@Comment("Wooden tool handles.")
			public double w = 3.0;
			@Name("bone")	@RangeDouble(min = 0.0f, max = 10.0f)	@Comment("Bone tool heads.")
			public double b = 5.0;
		}

		public static class Bindings {
			@Name("fiber")		@RangeDouble(min = 0.0f, max = 5.0f)	@Comment("Fiber tool bindings.")
			public double f = 1.5;
			@Name("vine")		@RangeDouble(min = 0.0f, max = 5.0f)	@Comment("Vine tool bindings.")
			public double v = 2.0;
			@Name("leather")	@RangeDouble(min = 0.0f, max = 5.0f)	@Comment("Leather tool bindings.")
			public double l = 3.2;
		}

		public static class Heads {
			@Name("flint")	@RangeDouble(min = 0.0f, max = 30.0f)	@Comment("Flint tool heads.")
			public double c = 15.0;
		}

		public static class Hammers {
			@Name("stone")		@RangeDouble(min = 0.0f, max = 30.0f)	@Comment("Stone hammer heads.")
			public double s = 8.0;
			@Name("diorite")	@RangeDouble(min = 0.0f, max = 30.0f)	@Comment("Diorite hammer heads.")
			public double d = 18.0;
			@Name("granite")	@RangeDouble(min = 0.0f, max = 30.0f)	@Comment("Granite hammer heads.")
			public double g = 26.0;
		}
	}

}
