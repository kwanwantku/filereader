package stopwatch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * The task reading file by using FileReader and append to StringBuilder.
 * 
 * @author Kwanwan Tantichartkul
 * @version 1.0
 * @since 2018.02.23
 */
public class AppendToStringBuilderTask implements Runnable {
	/** initialize the number of char in file */
	private int size;
	/** the task to read */
	private String task;

	/**
	 * The attributes for read by using FileReader and append to StringBuilder.
	 * 
	 * @param task
	 *            is file that you want to read it.
	 */
	public AppendToStringBuilderTask(String task) {
		this.task = task;
	}

	/**
	 * Reading the task by using FileReader and append to StringBuilder.
	 * 
	 * @param filename
	 *            is directory or filename that want to read
	 * @return result from reader file.
	 */
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

	/**
	 * The number of char from reading the file.
	 * 
	 * @return size of char
	 */
	public int getSize() {
		return size;
	}

	/**
	 * The directory or filename for reading.
	 * 
	 * @return the directory or filename
	 */
	public String getTask() {
		return task;
	}

	/**
	 * Running the task and collect the number of char in file.
	 */
	@Override
	public void run() {
		String alice2 = readFileToStringBuilder(task);
		size = alice2.length();
	}

	/**
	 * Tell the number of char to reading file.
	 * 
	 * @return the detail of number of char and method use for read file.
	 */
	@Override
	public String toString() {
		return String.format("Reading file using FileReader, append to StringBuilder read %d char.", size);
	}
}
