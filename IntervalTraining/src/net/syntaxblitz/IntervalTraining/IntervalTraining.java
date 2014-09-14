package net.syntaxblitz.IntervalTraining;

import java.util.Scanner;

public class IntervalTraining {

	private final static double TWELFTHROOT_TWO = Math.pow(2.0, 1.0 / 12.0);

	private final Scanner consoleScanner = new Scanner(System.in);

	public IntervalTraining() throws InterruptedException {

		String response = "";

		while (!response.equals("quit")) {
			int[] allowedIntervals = { -2, -1, 1, 2, 3, 4, 5 };

			int note1 = (int) (Math.random() * 16 - 10);
			// int note2 = (int) (Math.random() * 16 - 10);
			int note2 = note1
					+ allowedIntervals[(int) (Math.random() * allowedIntervals.length)];

			double seconds = 1;

			System.out.println("This note is " + getNoteName(note1) + ".");

			double hz1 = getHz(note1);
			for (int i = 0; i <= StdAudio.SAMPLE_RATE * seconds; i++) {
				StdAudio.play(0.5 * Math.sin(2 * Math.PI * hz1 * i
						/ StdAudio.SAMPLE_RATE));
			}

			Thread.sleep(00);

			double hz2 = getHz(note2);
			for (int i = 0; i <= StdAudio.SAMPLE_RATE * seconds; i++) {
				StdAudio.play(0.5 * Math.sin(2 * Math.PI * hz2 * i
						/ StdAudio.SAMPLE_RATE));
			}

			System.out.println("What was that note?");
			response = getConsoleLine();

			if (noteNameMatches(response, note2)) {
				System.out.println("Yes!");
			} else {
				System.out.println("Nope. The interval was " + (note2 - note1)
						+ ", and the note was " + getNoteName(note2) + ".");
			}
			System.out.println("-------------------------");
		}

		// need to call this in non-interactive stuff so the program doesn't
		// terminate until all the sound leaves the speaker.
		StdAudio.close();

		consoleScanner.close();
		System.exit(0);
	}

	private String getNoteName(int halfStepsFromA) {
		while (halfStepsFromA < 0) {
			halfStepsFromA += 12;
		}
		halfStepsFromA = halfStepsFromA % 12;

		String[] noteArray = { "A", "Bb", "B", "C", "C#", "D", "Eb", "E", "F",
				"F#", "G", "G#" };

		return noteArray[halfStepsFromA];
	}

	private boolean noteNameMatches(String input, int halfStepsFromA) {
		while (halfStepsFromA < 0) {
			halfStepsFromA += 12;
		}
		halfStepsFromA = halfStepsFromA % 12;

		String[] noteArray = { "A", "Bb", "B", "C", "C#", "D", "Eb", "E", "F",
				"F#", "G", "G#" };
		String[] secondaryNoteArray = { "A", "A#", "Cb", "B#", "Db", "D", "D#",
				"Fb", "E#", "Gb", "G", "Ab" };

		return input.equalsIgnoreCase(noteArray[halfStepsFromA])
				|| input.equalsIgnoreCase(secondaryNoteArray[halfStepsFromA]);
	}

	private double getHz(int stepsFromA) {
		return getHz(440.0, stepsFromA);
	}

	private double getHz(double baseHz, int stepsFromBaseHz) {
		return baseHz * Math.pow(TWELFTHROOT_TWO, stepsFromBaseHz);
	}

	private String getConsoleLine() {
		return consoleScanner.nextLine();
	}

	public static void main(String[] args) throws InterruptedException {
		IntervalTraining intervalTraining = new IntervalTraining();
	}
}
