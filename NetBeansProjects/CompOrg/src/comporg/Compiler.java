package comporg;
import java.util.*;
import java.io.*;

public class Compiler {
	
	private static final Map<String, Integer> keyword = initMap();
	
	private static Map<String, Integer> initMap() {
		Map<String, Integer> map = new HashMap<>();
		map.put("halt", 0);
		map.put("load", 1);
		map.put("loadc", 2);
		map.put("store", 3);
		map.put("add", 4);
		map.put("mul", 5);
		map.put("sub", 6);
		map.put("div", 7);
		map.put("and", 8);
		map.put("or", 9);
		map.put("not", 10);
		map.put("lshift", 11);
		map.put("rshift", 12);
		map.put("bwc", 13);
		map.put("bwd", 14);
		map.put("if", 15);
		return map;
	}
	
	public static boolean compile(File file) throws Exception {
		Scanner in = new Scanner(file);
		List<String> instruction = new ArrayList<>();
		instruction.add("");
		while(in.hasNext()) {
			String line = in.nextLine().toLowerCase();
			if(!line.trim().isEmpty())
				instruction.add(line.trim());
		}
		in.close();
		
		List<Integer> m1; 
		if((m1 = syntaxCheck(instruction)) == null)
			return false;
		FileWriter out = new FileWriter(new File(file.getAbsolutePath() + ".m1").getAbsoluteFile(), false);
		for(int ir : m1)
			out.write(String.format("%08x", ir) + "\n");
		out.close();
		return true;
	}
	
	private static List<Integer> syntaxCheck(List<String> ins) throws Exception {
		List<Integer> bytecode = new ArrayList<>();
		boolean isHalt = false;
		int index = 0;
		while(index < ins.size()) {
			String str = ins.get(index).trim();
			if(!str.isEmpty()) {
				if(isHalt) {
					try {
						if(str.startsWith("0x")) {
							bytecode.add(Integer.parseInt(str.substring(2), 16));
						} else {
							bytecode.add(Integer.parseInt(str));
						}
					} catch(Exception e) {
						throw new Exception(String.format("line %d: expecting a 32-bit integer, \"%s\" found\n", index, str));
					}
					index++;
					continue;
				}
				
				
				String[] line = str.split("\\s+");
				
				String word = line[0];
				if(!keyword.containsKey(word)) {
					throw new Exception(String.format("line %d: \"%s\" is not a keyword.\n", index, word));
				}
				
				if(word.matches("halt")) {
					bytecode.add(0);
					isHalt = true;
				} else if(word.matches("loadc")) {
					if(line.length != 2) {
						throw new Exception(String.format("line %d: expecting 1 argument. %d arguments found\n", index, (line.length-1)));
					}
					if(!line[1].matches("[0-7]")) {
						throw new Exception(String.format("line %d: expecting numbers from 0-7 for argument, \"%s\" found\n", index, line[1]));
					}
					int code = (2 << 8) | (Integer.parseInt(line[1]) << 4);
					bytecode.add(code);
					
					String num = ins.get(++index);
					try {
						if(num.startsWith("0x")) 
							code = Integer.parseInt(num.substring(2), 16);
						else
							code = Integer.parseInt(num);
						bytecode.add(code);
					} catch(NumberFormatException e) {
						throw new Exception(String.format("line %d: expecting a 32-bit integer, \"%s\" found\n", index, num));
					}
				} else {
					if(line.length != 3) {
						throw new Exception(String.format("line %d: expecting 2 argument. %d arguments found\n", index, (line.length-1)));
					}
					
					if(!line[1].matches("[0-7]")) {
						throw new Exception(String.format("line %d: expecting numbers from 0-7 for argument 1, \"%s\" found\n", index, line[1]));
					}
					
					if(!line[2].matches("[0-7]")) {
						throw new Exception(String.format("line %d: expecting numbers from 0-7 for argument 2, \"%s\" found\n", index, line[2]));
					}
					
					int code = (keyword.get(line[0]) << 8) | (Integer.parseInt(line[1]) << 4) | Integer.parseInt(line[2]);
					bytecode.add(code);
				}	
			}
			index++;
		}
		return bytecode;
	}
}
