package stopwatch;

/**
 * The stopwatch for get the timer in one round.
 * 
 * @author Kwanwan Tantichartkul
 * @version 1.0
 * @since 2018.02.22
 */
public class Stopwatch {
	/** the 1 nanosecond is equals to 1*(10^(19)) second */
	private static final double NANOSECOND = 1.0E-9; // nanos per 1 second
	/** the start time */
	private long startTime;
	/** the end time */
	private long endTime;
	/** check for stop watch is running or not */
	private boolean running;

	/**
	 * The stop watch attributes start from not running.
	 */
	public Stopwatch() {
		this.running = false;
	}

	/**
	 * The start stop watch.
	 */
	public void start() {
		if (running)
			return;
		this.running = true;
		this.startTime = System.nanoTime();
	}

	/**
	 * The stop stop watch.
	 */
	public void stop() {
		if (!running)
			return;
		this.endTime = System.nanoTime();
		this.running = false;
	}

	/**
	 * To checking the stop watch is running or not.
	 * 
	 * @return true if stop watch is running. false id stop watch is not
	 *         running.
	 */
	public boolean isRunning() {
		return this.running;
	}

	/**
	 * Get the elapsed from the stop watch for one round.
	 * 
	 * @return the elapsed time from stopwatch.
	 */
	public double getElapsed() {
		// No magic Number in Code - "code complete"
		if (running)
			return (System.nanoTime() - startTime) * NANOSECOND;
		else
			return (endTime - startTime) * NANOSECOND;
	}
}
