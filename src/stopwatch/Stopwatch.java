package stopwatch;

public class Stopwatch {

	private static final double NANOSECOND = 1.0E-9; // nanos per 1 second
	private long startTime;
	private long endTime;
	private boolean running;

	public Stopwatch() {
		this.running = false;
	}

	public void start() {
		if (running)
			return;
		this.running = true;
		this.startTime = System.nanoTime();
	}

	public void stop() {
		if (!running)
			return;
		this.endTime = System.nanoTime();
		this.running = false;
	}

	public boolean isRunning() {
		return this.running;
	}

	public double getElapsed() {
		// No magic Number in Code - "code complete"
		if (running)
			return (System.nanoTime() - startTime) * NANOSECOND;
		else
			return (endTime - startTime) * NANOSECOND;
	}
}
