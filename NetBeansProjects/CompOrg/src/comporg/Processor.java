package comporg;
public class Processor {
	int[] reg;
	int PC, IR;
	Memory memory;
	
	public Processor() {
		reg = new int[8];
		PC = IR = 0;
		memory = new Memory(256);
	}
	
	public boolean step() throws Exception {
		IR = memory.read(PC++);
		if(IR == 0) return true;
		execute();
		return false;
	}
	
	public void execute() throws Exception {
		//0x00000pab
		//0x0000000f
		//0x0000000a
		int b = IR & 0xf;        //0x00000pab & 0x0000000f
		int a = (IR >> 4) & 0xf; //0x000000pa & 0x0000000f
		int p = (IR >> 8) & 0xf; //0x0000000p & 0x0000000f
		switch(p) {
		case 1: reg[a] = memory.read(reg[b]); break;
		case 2: reg[a] = memory.read(PC++); break;
		case 3: memory.write(reg[a], reg[b]); break;
		case 4: reg[a] += reg[b]; break;
		case 5: reg[a] *= reg[b]; break;
		case 6: reg[a] -= reg[b]; break;
		case 7: reg[a] /= reg[b]; break;
		case 8: reg[a] = reg[a] != 0 && reg[b] != 0 ? 1 : 0; break;
		case 9: reg[a] = reg[a] != 0 || reg[b] != 0 ? 1 : 0; break;
		case 10: reg[a] = reg[b] != 0 ? 0 : 1; break;
		case 11: reg[a] = reg[b] << 1; break;
		case 12: reg[a] = reg[b] >> 1; break;
		case 13: reg[a] &= reg[b]; break;
		case 14: reg[a] |= reg[b]; break;
		case 15: if(reg[a] != 0) PC = reg[b]; break;
		}
	}
	
	public void setMemory(Memory m) {
		memory = m;
	}
	
	public void setPC(int p) {
		PC = p;
	}
	
	public void clear() {
		for(int i = 0; i < reg.length; i++)
			reg[i] = 0;
		PC = IR = 0;
	}
	
	public void dump() {
		System.out.println("Registers:");
		for(int i = 0; i < reg.length; i++)
			System.out.printf("reg[%x] = 0x%08x\n", i, reg[i]);
		System.out.printf("PC = 0x%08x\n", PC);
		System.out.printf("IR = 0x%08x\n", IR);
	}
	
	public String toString() {
		StringBuilder ret = new StringBuilder();
		for(int i = 0; i < reg.length; i++)
			ret.append(String.format("reg[%x] = 0x%08x\n", i, reg[i]));
		ret.append(String.format("PC = 0x%08x\n", PC));
		ret.append(String.format("IR = 0x%08x\n", IR));
		return ret.toString();
	}
}
