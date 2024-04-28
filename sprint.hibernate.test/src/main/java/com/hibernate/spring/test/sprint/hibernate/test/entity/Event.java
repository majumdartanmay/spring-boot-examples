package com.hibernate.spring.test.sprint.hibernate.test.entity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table( name = "Events")
public class Event {
    @GeneratedValue
    @Id
    private long id;

    private String data;

    private EmbeddedEvent embeddedEvent;

    public Event(String aFollowUpEvent) {
        this.data = aFollowUpEvent;
    }

    public Event(){}

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

}
