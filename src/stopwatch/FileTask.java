package stopwatch;

import java.io.*;

public class FileTask {

	public static String readFileToString(String filename) {
		// create a string for the data to read
		String result = "";
		InputStream in = null;
		InputStreamReader reader = null;
		try {
			// open file
			in = new FileInputStream(filename);
			// read as character, so what to do?
			reader = new InputStreamReader(in);
			// read the file
			int c;
			while (true) { // while(c=reader.read() >= 0)
				c = reader.read();
				if (c < 0)
					break;
				result = result + (char) c;

			}
		} catch (FileNotFoundException iex) {
			System.out.println("file not found " + filename);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		// close the file

		if (in != null) {
			try {
				in.close();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}
		return result;
	}

	public static String readFileToStringBuilder(String filename) {
		// create a string builder for the data to read
		StringBuilder result = new StringBuilder();
		InputStream in = null;
		try {
			in = new FileInputStream(filename);
			InputStreamReader reader = new InputStreamReader(in);
			int c;
			while (true) { // while(c=reader.read() >= 0)
				c = reader.read();
				if (c < 0)
					break;
				result.append((char) c);
			}

		} catch (FileNotFoundException ex) {
			System.out.println("file not found " + filename);
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}
		if (in != null) {
			try {
				in.close();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}
		}

		return result.toString();
	}

	public static String readFileByBufferedReader(String filename) throws FileNotFoundException {
		// create a string for the data to read
		String result = "";
		FileReader reader = new FileReader(filename);
		BufferedReader br;
		String line;
		try {
			br = new BufferedReader(reader);
			while ((line = br.readLine()) != null) {
				result = result + line + '\n';
			}
		} catch (IOException ex) {
			System.out.println(ex.getMessage());
		}

		if (reader != null) {
			try {
				reader.close();
			} catch (IOException ex) {
				System.out.println(ex.getMessage());
			}

		}

		return result;

	}

	public static void main(String[] args) throws FileNotFoundException {
		// create a stopwatch
		Stopwatch sw = new Stopwatch();
		// start the stopwatch
		sw.start();
		String alice = readFileToString("src/stopwatch/Alice-in-Wonderland.txt");
		// stop the stopwatch
		sw.stop();
		// print the result
		System.out.println("Reading Alice-in-Wonderland.txt using FileReader, append to String.");
		System.out.printf("Read %d chars in %.6f sec.\n", alice.length(), sw.getElapsed());

		// create a stopwatch
		Stopwatch sw2 = new Stopwatch();
		// start the stopwatch
		sw2.start();
		String alice2 = readFileToStringBuilder("src/stopwatch/Alice-in-Wonderland.txt");
		// stop the stopwatch
		sw2.stop();
		// print the result
		System.out.println("Reading Alice-in-Wonderland.txt using FileReader, append to StringBuilder.");
		System.out.printf("Read %d chars in %.6f sec.\n", alice2.length(), sw2.getElapsed());

		// create a stopwatch
		Stopwatch sw3 = new Stopwatch();
		// start the stopwatch
		sw3.start();
		String alice3 = readFileByBufferedReader("src/stopwatch/Alice-in-Wonderland.txt");
		// stop the stopwatch
		sw3.stop();
		// print the result
		System.out.println("Reading Alice-in-Wonderland.txt using BufferedReader, append lines to String.");
		System.out.printf("Read %d chars in %.6f sec.\n", alice3.length(), sw3.getElapsed());

	}

}
