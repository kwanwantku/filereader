package stopwatch;

public class TaskTimer {
	
	public void measureAndPrint(Runnable task) {
		/**Creating a stopwatch */
		Stopwatch watch = new Stopwatch();
	    // start stopwatch
		watch.start();
	    // run the task
		task.run();
	    // stop stopwatch and print elapsed time
		watch.stop();
		//print each task detail
		System.out.println(task.toString());
		System.out.printf("Time in %.6f sec.\n", watch.getElapsed());
	}
}
