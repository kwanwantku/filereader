package stopwatch;

/**
 * The main class for running tasks.
 * 
 * @author Kwanwan Tantichartkul
 * @version 1.0
 * @since 2018.02.23
 */
public class Main {
	/**
	 * The main for running each task with time
	 * 
	 * @param args
	 *            is the arguments that want to run.
	 */
	public static void main(String[] args) {
		String filename = "src/stopwatch/Alice-in-Wonderland.txt";
		Runnable[] tasks = { new AppendToBufferedReaderTask(filename), new AppendToStringBuilderTask(filename),
				new AppendToStringTask(filename) };
		TaskTimer tasktimer = new TaskTimer();
		for (int i = 0; i < tasks.length; i++) {
			tasks[i].run();
			tasktimer.measureAndPrint(tasks[i]);
		}
	}
}
