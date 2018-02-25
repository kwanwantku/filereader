package stopwatch;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 * The task reading file by using BufferReader and append lines to String.
 * 
 * @author Kwanwan Tantichartkul
 * @version 1.0
 * @since 2018.02.23
 */
public class AppendToBufferedReaderTask implements Runnable {
	/** initialize the number of char in file */
	private int size;
	/** the task to read */
	private String task;

	/**
	 * The attributes for read by using BufferReader and append lines to String.
	 * 
	 * @param task
	 *            is file that you want to read it.
	 */
	public AppendToBufferedReaderTask(String task) {
		this.task = task;
	}

	/**
	 * Reading the task by using BufferredReader and append lines to String.
	 * 
	 * @param filename
	 *            is directory or filename that want to read
	 * @return result from reader file.
	 */
	public static String readFileByBufferedReader(String filename) {
		// create a string for the data to read
		String result = "";
		try {
			FileReader reader = new FileReader(filename);
			BufferedReader br = new BufferedReader(reader);
			String line;
			while ((line = br.readLine()) != null) {
				result = result + line + '\n';
			}
			br.close();

		} catch (FileNotFoundException ex) {
			System.out.println(ex.getMessage());
		}

		catch (IOException ex) {
			System.out.println(ex.getMessage());
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
		String alice3 = readFileByBufferedReader(task);
		size = alice3.length();
	}

	/**
	 * Tell the number of char to reading file.
	 * 
	 * @return the detail of number of char and method use for read file.
	 */
	@Override
	public String toString() {
		return String.format("Reading file using BufferedReader, append lines to String read %d char.", size);
	}
}
