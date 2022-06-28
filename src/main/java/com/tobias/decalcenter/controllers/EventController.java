package com.tobias.decalcenter.controllers;

import com.tobias.decalcenter.dtos.EventDto;
import com.tobias.decalcenter.dtos.EventInputDto;
import com.tobias.decalcenter.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class EventController {

    private final EventService eventService;

    @Autowired
    public EventController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/events")
    public ResponseEntity<List<EventDto>> getAllEvents(@RequestParam(value = "eventName", required = false) Optional<String> eventName) {

        List<EventDto> eventDtos;

        if (eventName.isEmpty()) {

            eventDtos = eventService.getAllEvents();

        } else {

            eventDtos = eventService.getAllEventsByName(eventName.get());

        }

        return ResponseEntity.ok().body(eventDtos);
    }

    @GetMapping("/events/{id}")
    public ResponseEntity<EventDto> getEvents(@PathVariable("id") Long eventId) {
        EventDto event = eventService.getEventById(eventId);
        return ResponseEntity.ok().body(event);
    }

    @PostMapping("/events")
    public ResponseEntity<Object> addEvent(@RequestBody EventInputDto eventInputDto) {

        EventDto eventDto = eventService.addEvent(eventInputDto);

        return ResponseEntity.created(null).body(eventDto);
    }

    @DeleteMapping("/events/{eventId}")
    public ResponseEntity<Object> deleteEvent(@PathVariable Long eventId) {

        eventService.deleteEvent(eventId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/events/{eventId}")
    public ResponseEntity<Object> updateEvent(
            @PathVariable Long eventId,
            @RequestBody EventInputDto newEvent) {

        EventDto eventDto = eventService.updateEvent(eventId, newEvent);

        return ResponseEntity.ok().body(eventDto);
    }
}