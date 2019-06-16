package panda.primitivetools;

import java.util.HashMap;

public class Materials {
	
	static HashMap<Character, Float> materialslist = new HashMap<>();
	
	public static void init(){
		materialslist.put('w', 3f);
		materialslist.put('b', 5f);
		materialslist.put('f', 1.5f);
		materialslist.put('v', 2f);
		materialslist.put('l', 3.2f);
		
		//regular tool heads
		materialslist.put('c', 15f);//c = chert = flint
		
		//hammer materials
		materialslist.put('s', 8f); 
		materialslist.put('d', 18f);
		materialslist.put('g', 26f);
	}
	
	public static int getDurabForParts(String key){
		
		char head = key.charAt(0);
		char rod = key.charAt(1);
		char binding = key.charAt(2);
		
		
		return Math.round(materialslist.get(head)*(materialslist.get(binding) + materialslist.get(rod)));
	}
}
