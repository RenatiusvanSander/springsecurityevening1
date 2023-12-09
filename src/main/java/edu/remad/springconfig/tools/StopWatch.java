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
	
	public StopWatch() {
	}
	
	public void start() {
		startTime = LocalDateTime.now().toInstant(ZONE_OFFSET);
	}

	public void stop() {
		endTime = LocalDateTime.now().toInstant(ZONE_OFFSET);
	}
	
	public long getTime() {
		if(durationInMilliSeconds == null) {
			durationInMilliSeconds = endTime.toEpochMilli() - startTime.toEpochMilli();
		}
		
		return durationInMilliSeconds;
	}
}
