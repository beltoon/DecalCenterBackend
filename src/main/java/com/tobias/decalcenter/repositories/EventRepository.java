package com.tobias.decalcenter.repositories;

import com.tobias.decalcenter.models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllEventsByNameEqualsIgnoreCase(String name);
}
