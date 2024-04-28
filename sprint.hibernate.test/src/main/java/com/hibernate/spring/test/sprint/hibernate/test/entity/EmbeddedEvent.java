package com.hibernate.spring.test.sprint.hibernate.test.entity;

import jakarta.persistence.Embeddable;

@Embeddable
public class EmbeddedEvent {
    private String ename;
    private String ename2;

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getEname2() {
        return ename2;
    }

    public void setEname2(String ename2) {
        this.ename2 = ename2;
    }
}
