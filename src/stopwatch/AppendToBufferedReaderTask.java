package stopwatch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AppendToBufferedReaderTask implements Runnable{
	
	private int size;
	
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
	
	public void run() {
		
		String alice = null;
		try {
			alice = readFileByBufferedReader("src/stopwatch/Alice-in-Wonderland.txt");
			size = alice.length();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public String toString() {
		return String.format("Reading Alice-in-Wonderland.txt using BufferedReader, append lines to String. : Read %d chars",size);
	}
}
