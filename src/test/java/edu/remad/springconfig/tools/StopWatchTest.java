package edu.remad.springconfig.tools;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class StopWatchTest {

	private static final long TIME_1_SECOND_IN_MILI_SECONDS = 1000L;

	@Test
	public void isRunningTest() throws InterruptedException {
		StopWatch stopWatch = new StopWatch();
		Assertions.assertFalse(stopWatch.isRunning());
		
		stopWatch.start();
		Thread.sleep(TIME_1_SECOND_IN_MILI_SECONDS);
		Assertions.assertTrue(stopWatch.isRunning());
		
		Thread.sleep(TIME_1_SECOND_IN_MILI_SECONDS);
		stopWatch.stop();
		Assertions.assertFalse(stopWatch.isRunning());
	}
	
	@Test
	public void stopTest() throws InterruptedException {
		StopWatch stopWatch = new StopWatch();
		
		Assertions.assertTrue(stopWatch.isStopped());
		
		stopWatch.start();
		Assertions.assertTrue(stopWatch.isRunning());
		
		Thread.sleep(TIME_1_SECOND_IN_MILI_SECONDS);
		stopWatch.stop();
		Assertions.assertFalse(stopWatch.isRunning());
		Assertions.assertTrue(stopWatch.isStopped());
	}
	
	@Test
	public void timeTestShouldBeGreaterThan1000() throws InterruptedException {
		StopWatch stopWatch = new StopWatch();
		
		stopWatch.start();
		Thread.sleep(TIME_1_SECOND_IN_MILI_SECONDS);
		stopWatch.stop();
		
		Assertions.assertTrue(stopWatch.getTime() > TIME_1_SECOND_IN_MILI_SECONDS);
	}
}
