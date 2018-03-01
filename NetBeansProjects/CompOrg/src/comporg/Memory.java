package comporg;
public class Memory {
	
	private int[] cell;
	private int cap;
	
	public Memory(int cap) {
		cell = new int[cap];
		this.cap = cap;
	}
	
	public int read(int addr) throws Exception {
		if(addr >= cap || addr < 0)
			throw new Exception("Fatal error: address out of bound.");
		return cell[addr];
	}
	
	public void write(int addr, int data) throws Exception {
		if(addr >= cap || addr < 0) 
			throw new Exception("Fatal error: address out of bound.");
		cell[addr] = data;
	}
	
	public void clear() {
		for(int i = 0; i < cap; i++) cell[i] = 0;
	}
	
	public void dump() {
		for(int i = 0; i < cap; i++)
			System.out.printf("cell[%02x] = 0x%08x\n", i, cell[i]);
	}
	
	public String toString() {
		StringBuilder ret = new StringBuilder();
		for(int i = 0; i < cap; i++)
			ret.append(String.format("0x%02x  %08x\n", i, cell[i]));
		return ret.toString();
	}
	
}
