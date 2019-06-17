package panda.primitivetools;

import java.util.HashMap;

public class Materials {
	
	private static HashMap<Character, Double> materialslist = new HashMap<>();
	
	public static void init(){
		materialslist.put('w', ConfigPrimitiveTools.MaterialDurability.handleDurability.w);
		materialslist.put('b', ConfigPrimitiveTools.MaterialDurability.handleDurability.b);
		materialslist.put('f', ConfigPrimitiveTools.MaterialDurability.bindingDurability.f);
		materialslist.put('v', ConfigPrimitiveTools.MaterialDurability.bindingDurability.v);
		materialslist.put('l', ConfigPrimitiveTools.MaterialDurability.bindingDurability.l);
		
		//regular tool heads
		materialslist.put('c', ConfigPrimitiveTools.MaterialDurability.headDurability.c); //c = chert = flint
		
		//hammer materials
		materialslist.put('s', ConfigPrimitiveTools.MaterialDurability.hammerDurability.s);
		materialslist.put('d', ConfigPrimitiveTools.MaterialDurability.hammerDurability.d);
		materialslist.put('g', ConfigPrimitiveTools.MaterialDurability.hammerDurability.g);
	}
	
	public static int getDurabForParts(String key){
		
		char head = key.charAt(0);
		char rod = key.charAt(1);
		char binding = key.charAt(2);

		return (int)Math.round(materialslist.get(head)*(materialslist.get(binding) + materialslist.get(rod)));
	}
}
