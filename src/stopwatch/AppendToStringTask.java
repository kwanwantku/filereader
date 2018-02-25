package stopwatch;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * The task reading file by using FileReader and append to String.
 * 
 * @author Kwanwan Tantichartkul
 * @version 1.0
 * @since 2018.02.23
 */
public class AppendToStringTask implements Runnable {
	/** initialize the number of char in file */
	private int size;
	/** the task to read */
	private String task;

	/**
	 * The attributes for read by using FileReader and append to String.
	 * 
	 * @param task
	 *            is file that you want to read it.
	 */
	public AppendToStringTask(String task) {
		this.task = task;
	}

	/**
	 * Reading the task by using FileReader and append to String.
	 * 
	 * @param filename
	 *            is directory or filename that want to read
	 * @return result from reader file.
	 */
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
		String alice = readFileToString(task);
		size = alice.length();
	}

	/**
	 * Tell the number of char to reading file.
	 * 
	 * @return the detail of number of char and method use for read file.
	 */
	@Override
	public String toString() {
		return String.format("Reading file using FileReader, append to String read %d char.", size);
	}
}
