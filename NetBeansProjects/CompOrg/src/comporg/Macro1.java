package comporg;
import java.io.*;
import java.util.Scanner;

public class Macro1 {
	
	private Memory memory; 
       
	private Processor cpu;
	private boolean isHalt;
	private boolean inMiddleOfStep;

	public Macro1() {
		memory = new Memory(256);
		cpu = new Processor();
		cpu.setMemory(memory);
		isHalt = false;
		inMiddleOfStep = false;
	}
	
	public void step() throws Exception {
		if(!isHalt) isHalt = cpu.step();
		inMiddleOfStep = !isHalt;
	}
	
	public void stepUtilHalt() throws Exception {
		while(!isHalt) isHalt = cpu.step();
		inMiddleOfStep = false;
	}
	
	public void load(File fp) {
		try {
			reset();
			Scanner in = new Scanner(fp);
			int index = 0;
			while(in.hasNext())
				memory.write(index++, in.nextInt(16));
			in.close();
			inMiddleOfStep = false;
			isHalt = false;
		} catch(IOException e) {
			e.printStackTrace();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void reset() {
		cpu.clear();
		memory.clear();
		cpu.setPC(0);
	}
	
	public String memoryDump() {
		return memory.toString();
	}
	
	public String registerDump() {
		return cpu.toString();
	}
	
	public boolean isHalt() {
		return isHalt;
	}
	
	public boolean isInMiddleOfStep() {
		return inMiddleOfStep;
	}
	
}
