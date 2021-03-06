package edu.kit.ifv.mobitopp.publictransport.model;

import java.time.LocalDateTime;

import edu.kit.ifv.mobitopp.publictransport.model.DefaultModifiableJourney;
import edu.kit.ifv.mobitopp.publictransport.model.Time;
import edu.kit.ifv.mobitopp.publictransport.model.TransportSystem;
import edu.kit.ifv.mobitopp.publictransport.model.ModifiableJourney;

public class JourneyBuilder {

	private static final int defaultId = 0;
	private static final Time defaultDay = new Time(LocalDateTime.of(2011, 10, 17, 0, 0));
	private static final int defaultCapacity = 0;
	private static final TransportSystem defaultSystem = new TransportSystem("default system");

	private int id;
	private Time day;
	private TransportSystem system;
	private int capacity;

	private JourneyBuilder() {
		super();
		id = defaultId;
		day = defaultDay;
		system = defaultSystem;
		capacity = defaultCapacity;
	}

	public static JourneyBuilder journey() {
		return new JourneyBuilder();
	}

	public JourneyBuilder withId(int id) {
		this.id = id;
		return this;
	}

	public JourneyBuilder at(Time day) {
		this.day = day;
		return this;
	}

	public JourneyBuilder seatsFor(int capacity) {
		this.capacity = capacity;
		return this;
	}

	public JourneyBuilder belongsTo(TransportSystem system) {
		this.system = system;
		return this;
	}

	public ModifiableJourney build() {
		return new DefaultModifiableJourney(id, day, system, capacity);
	}

}
