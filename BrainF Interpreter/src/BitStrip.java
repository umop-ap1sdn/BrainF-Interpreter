import java.util.*;

public class BitStrip {
	
	int index;
	ArrayList<Byte> bits;
	
	public BitStrip() {
		index = 0;
		bits = new ArrayList<>();
		bits.add((byte) 0);
	}
	
	public void add() {
		bits.set(index, (byte) (bits.get(index) + 1));
	}
	
	public void subtract() {
		bits.set(index, (byte) (bits.get(index) - 1));
	}
	
	public void right() {
		index++;
		
		while(index >= bits.size()) {
			bits.add((byte) 0);
		}
	}
	
	public void left() {
		index--;
	}
	
	public void print(boolean character) throws Exception {
		
		if(character) System.out.print((char) bits.get(index).byteValue());
		else System.out.print(bits.get(index).byteValue() + " ");
		
		Thread.sleep(200);
	}
	
	public void input(byte num) {
		bits.set(index, num);
	}
	
	public void input(String text) {
		bits.set(index, (byte) text.charAt(0));
	}
	
	public ArrayList<Byte> getStrip(){
		return this.bits;
	}
	
	public byte getCurrentBit() {
		return this.bits.get(index);
	}
}
