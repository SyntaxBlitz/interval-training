package net.syntaxblitz.IntervalTraining;

public class NoteNameTest {
	public static void main(String[] args) {
		System.out.println(getNoteName(0));
		System.out.println(getNoteName(-1));
		System.out.println(getNoteName(-2));
		System.out.println(getNoteName(-3));
		System.out.println(getNoteName(-4));
		System.out.println(getNoteName(-5));
		System.out.println(getNoteName(-6));
		System.out.println(getNoteName(-7));
		System.out.println(getNoteName(-8));
		System.out.println(getNoteName(-9));
		System.out.println(getNoteName(-10));
		System.out.println(getNoteName(-11));
		System.out.println(getNoteName(-12));
		System.out.println(getNoteName(-13));
		System.out.println(getNoteName(-14));
	}
	
	private static String getNoteName(int halfStepsFromA) {
		while(halfStepsFromA < 0) {
			halfStepsFromA += 12;
		}
		halfStepsFromA %= 12;
		
		String[] noteArray = {"A", "Bb", "B", "C", "C#", "D", "Eb", "E", "F", "F#", "G", "G#"};
		
		return noteArray[halfStepsFromA];
	}
}
