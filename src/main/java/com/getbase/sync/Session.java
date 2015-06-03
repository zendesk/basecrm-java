package com.getbase.sync;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;

import java.util.List;

public class Session {
    protected @JsonView(Views.ReadOnly.class) String id;
    protected @JsonView(Views.ReadOnly.class) List<Queue> queues;

    public Session() {
    }

    public Session(String id, List<Queue> queues) {
        this.id = id;
        this.queues = queues;
    }

    public String getId() {
        return id;
    }

    public List<Queue> getQueues() {
        return queues;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setQueues(List<Queue> queues) {
        this.queues = queues;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Session session = (Session) o;

        return id.equals(session.id);

    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Session{" +
                "id='" + id + '\'' +
                ", queues=" + queues +
                '}';
    }
}
