package edu.kit.ifv.mobitopp.publictransport.model;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.MINUTES;

import java.time.Duration;
import java.time.temporal.ChronoUnit;

public class RelativeTime implements Comparable<RelativeTime> {

	public static final RelativeTime ZERO = RelativeTime.of(0, MINUTES);
	public static final RelativeTime INFINITE = RelativeTime.of(100, DAYS);
	private final Duration duration;

	private RelativeTime(Duration duration) {
		super();
		this.duration = duration;
	}

	private Duration truncateToMinutes(Duration duration) {
		return Duration.of(duration.toMinutes(), MINUTES);
	}

	public static RelativeTime of(long amount, ChronoUnit unit) {
		return new RelativeTime(Duration.of(amount, unit));
	}

	public long seconds() {
		return duration.getSeconds();
	}

	public long toMinutes() {
		return duration.toMinutes();
	}

	public RelativeTime plus(long amount, ChronoUnit unit) {
		return new RelativeTime(duration.plus(amount, unit));
	}

	public RelativeTime plus(Duration duration) {
		return new RelativeTime(this.duration.plus(truncateToMinutes(duration)));
	}

	public RelativeTime plus(RelativeTime other) {
		return plus(other.duration);
	}

	public Duration toDuration() {
		return duration;
	}

	@Override
	public int compareTo(RelativeTime other) {
		return duration.compareTo(other.duration);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((duration == null) ? 0 : duration.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		RelativeTime other = (RelativeTime) obj;
		if (duration == null) {
			if (other.duration != null) {
				return false;
			}
		} else if (!duration.equals(other.duration)) {
			return false;
		}
		return true;
	}

	@Override
	public String toString() {
		return "RelativeTime [duration=" + duration + "]";
	}

}
