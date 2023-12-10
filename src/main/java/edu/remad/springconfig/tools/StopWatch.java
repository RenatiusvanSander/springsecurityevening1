package edu.remad.springconfig.tools;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;

public class StopWatch {
	
	private static final LocalDateTime NOW = LocalDateTime.now();
	private static final ZoneId ZONE = ZoneId.of("Europe/Berlin");
	private static final ZoneOffset ZONE_OFFSET = ZONE.getRules().getOffset(NOW);
	
	private Instant startTime;
	private Instant endTime;
	private Long durationInMilliSeconds;
	private boolean runs;
	private boolean stopped;
	
	public StopWatch() {
		runs = false;
		stopped = true;
	}
	
	public void start() {
		startTime = LocalDateTime.now().toInstant(ZONE_OFFSET);
		runs = true;
		stopped = false;
	}

	public void stop() {
		endTime = LocalDateTime.now().toInstant(ZONE_OFFSET);
		runs = false;
		stopped = true;
	}
	
	public long getTime() {
		if(durationInMilliSeconds == null) {
			durationInMilliSeconds = endTime.toEpochMilli() - startTime.toEpochMilli();
		}
		
		return durationInMilliSeconds;
	}

	public boolean isRunning() {
		return runs;
	}

	public boolean isStopped() {
		return stopped;
	}
}
