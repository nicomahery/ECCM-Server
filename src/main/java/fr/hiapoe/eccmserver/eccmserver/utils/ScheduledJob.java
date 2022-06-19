package fr.hiapoe.eccmserver.eccmserver.utils;

import fr.hiapoe.eccmserver.eccmserver.services.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ScheduledJob {

    private final TripService tripService;

    @Autowired
    public ScheduledJob(TripService tripService) {
        this.tripService = tripService;
    }

    @EventListener(ApplicationReadyEvent.class)
    public void afterStartupTasks() {
        this.tripService.generateMissingTrips();
    }
}
