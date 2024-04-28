package com.hibernate.spring.test.sprint.hibernate.test.controller;

import com.hibernate.spring.test.sprint.hibernate.test.entity.Event;
import com.hibernate.spring.test.sprint.hibernate.test.hibernateconfig.ManualHibernateConfig;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

import static java.time.LocalTime.now;

@RestController
public class HibernateController {

    @Autowired
    private ManualHibernateConfig config;

    @GetMapping("/hibernate")
    public String doHibernateAddition() {

        final SessionFactory sessionFactory = config.getSessionFactory();
        sessionFactory.inTransaction(session -> {
            session.persist(new Event("Our very first event!"));
            session.persist(new Event("A follow up event"));
        });

        return "inserted";
    }

    @GetMapping("/fetch")
    public List<Event> fetch() {
        final SessionFactory sessionFactory = config.getSessionFactory();
        final List<Event> events = new ArrayList<>();
        sessionFactory.inTransaction(session -> {
            events.addAll(session.createSelectionQuery("from Event", Event.class)
                    .getResultList());
        });

        return events;
    }
}
