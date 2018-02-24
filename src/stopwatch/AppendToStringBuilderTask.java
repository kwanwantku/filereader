package stopwatch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AppendToStringBuilderTask implements Runnable{
	
	private int size;
	
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
	
	public void run() {
		String alice = readFileToStringBuilder("src/stopwatch/Alice-in-Wonderland.txt");
		size = alice.length();
	}
	
	public String toString() {
		return String.format("Reading Alice-in-Wonderland.txt using FileReader, append to StringBuilder : Read %d chars",size);
	}
}
