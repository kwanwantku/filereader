package stopwatch;

public class TaskTimer {
	/**Creating a stopwatch */
	private Stopwatch watch = new Stopwatch();
	public void measureAndPrint(Runnable task) {
	    // start stopwatch
		watch.start();
	    // run the task
		task.run();
	    // stop stopwatch and print elapsed time
		watch.stop();
		System.out.printf("Time in %.6f sec.\n", watch.getElapsed());
	}
}
