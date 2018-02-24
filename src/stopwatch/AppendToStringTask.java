package stopwatch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AppendToStringTask implements Runnable{
	private int size;
	
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
	
	public void run() {
		String alice = readFileToString("src/stopwatch/Alice-in-Wonderland.txt");
		size = alice.length();
	}
	
	public String toString() {
		return String.format("Reading Alice-in-Wonderland.txt using FileReader, append to String : Read %d chars",size);
	}
}
