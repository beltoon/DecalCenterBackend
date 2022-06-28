package com.tobias.decalcenter.services;

import com.tobias.decalcenter.dtos.EventDto;
import com.tobias.decalcenter.dtos.EventInputDto;
import com.tobias.decalcenter.exceptions.RecordNotFoundException;
import com.tobias.decalcenter.repositories.EventRepository;
import org.springframework.stereotype.Service;
import com.tobias.decalcenter.models.Event;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    private final DecalService decalService;

    public EventService(EventRepository eventRepository,
                        DecalService decalService) {
        this.eventRepository = eventRepository;
        this.decalService = decalService;
    }

    public List<EventDto> getAllEvents() {

        List<Event> eventList = eventRepository.findAll();

        return transferEventListToDtoList(eventList);
    }

    public List<EventDto> getAllEventsByName(String name) {

        List<Event> eventList = eventRepository.findAllEventsByNameEqualsIgnoreCase(name);

        return transferEventListToDtoList(eventList);
    }

    public List<EventDto> transferEventListToDtoList(List<Event> events) {
        List<EventDto> eventDtoList = new ArrayList<>();

        for (Event event : events) {
            EventDto eventDto = transferToDto(event);
            eventDtoList.add(eventDto);
        }
        return eventDtoList;
    }

    public EventDto getEventById(Long id) {

        if (eventRepository.findById(id).isPresent()) {
            Event event = eventRepository.findById(id).get();

            return transferToDto(event);
        } else {
            throw new RecordNotFoundException("No event found...");
        }
    }

    public EventDto addEvent(EventInputDto eventInputDto) {
        Event event = transferToEvent(eventInputDto);

        eventRepository.save(event);

        return transferToDto(event);
    }

    public void deleteEvent(@RequestBody Long id) {
        eventRepository.deleteById(id);
    }

    public EventDto updateEvent(Long id, EventInputDto eventInputDto) {
        if (eventRepository.findById(id).isPresent()) {
            Event event = eventRepository.findById(id).get();

            Event event1 = transferToEvent(eventInputDto);
            event1.setId(event.getId());

            eventRepository.save(event1);

            return transferToDto(event1);
        } else {
            throw new RecordNotFoundException("No event found...");
        }
    }

    public Event transferToEvent(EventInputDto eventDto) {
        var event = new Event();

        event.setName(eventDto.getName());
        event.setAddEventDecals(eventDto.getAddEventDecals());
        event.setPrivateEvent(eventDto.getPrivateEvent());
        event.setEventDate(eventDto.getEventDate());

        return event;
    }

    public EventDto transferToDto(Event event) {
        EventDto eventDto = new EventDto();
        eventDto.setId(event.getId());
        eventDto.setName(event.getName());
        eventDto.setAddEventDecals(event.getAddEventDecals());
        eventDto.setPrivateEvent(event.getPrivateEvent());
        eventDto.setEventDate(event.getEventDate());
        return eventDto;
    }


}
