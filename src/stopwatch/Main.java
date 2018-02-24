package stopwatch;

import java.io.FileNotFoundException;

public class Main {
	
	public static void main (String args) throws FileNotFoundException {
		TaskTimer tasktimer = new TaskTimer();
	    tasktimer.measureAndPrint(new AppendToStringTask());
	    tasktimer.measureAndPrint(new AppendToStringBuilderTask());
	    tasktimer.measureAndPrint(new AppendToBufferedReaderTask());

	}
}
