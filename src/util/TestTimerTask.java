package util;

import java.util.TimerTask;

public class TestTimerTask extends TimerTask {
	int index;
	
	public TestTimerTask(int i) {
	index  = i;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("run timer");
	}

}
