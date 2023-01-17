// javac.exe Hello.java
// jacac.exe Hello.java 진 RM 뷔 정국
public class Hello {
	public static void main(String[] args) {
		System.out.println("Hello");
		for(int i = 0; i < args.length; i++) {
			System.out.println(", " + args[i]);
		}
	}
}
