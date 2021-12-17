import java.io.File;
import java.util.*;

public class Reader {
	public static int index = 0;

	public static void main(String[]args) {
		
		Scanner code;
		String code1 = "";
		
		try {
			code = new Scanner(new File("perfDivision.brainf"));
			code1 = code.next();
		}catch(Exception e) {
			
		}
		
		code = new Scanner(System.in);
		BitStrip result = new BitStrip();
		
		result = read(code1, code, result);
		
		System.out.println();
		printStrip(result);
		
		
	}
	
	public static BitStrip read(String code, Scanner sc, BitStrip result){
		
		
		while(index < code.length()) {
			char command = code.charAt(index);
			
			switch(command) {
				case '+': 
					result.add();
					break;
				case '-':
					result.subtract();
					break;
				case '>':
					result.right();
					break;
				case '<':
					result.left();
					break;
				case '.':
					try {
						result.print(false);
					} catch (Exception e) {}
					break;
				case ',':
					try {
						result.input(sc.nextByte());
					}catch(InputMismatchException e) {
						String st;
						result.input(sc.next());
					}
					break;
				case '[':
					loopExecutor(result, code, index, sc);
			}
			
			index++;
			
		}
		
		return result;
	}
	
	public static void printStrip(BitStrip strip) {
		ArrayList<Byte> bits = strip.getStrip();
		
		for(byte b: bits) {
			System.out.print(b + " ");
		}
		
	}
	
	public static void loopExecutor(BitStrip strip, String code, int startLoop, Scanner sc) {
		int level = 0;
		int startIndex = ++startLoop;
		int endLoop = 0;
		
		while(endLoop == 0) {
			if(code.charAt(startLoop) == '[') level++;
			
			if(code.charAt(startLoop) == ']') {
				if(level > 0) level--;
				else if(level == 0) endLoop = startLoop;
			}
			
			startLoop++;
		}
		
		String newCode = code.substring(startIndex, endLoop);
		while(strip.getCurrentBit() != 0) {
			index = 0;
			read(newCode, sc, strip);
		}
		
		index = endLoop;
	}
}
