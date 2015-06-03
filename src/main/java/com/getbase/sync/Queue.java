package com.getbase.sync;

import com.fasterxml.jackson.annotation.JsonView;
import com.getbase.serializer.Views;

public class Queue {
    protected @JsonView(Views.ReadOnly.class) String name;
    protected @JsonView(Views.ReadOnly.class) Long pages;
    protected @JsonView(Views.ReadOnly.class) Long totalCount;

    public Queue() {
    }

    public Queue(String name, Long pages, Long totalCount) {
        this.name = name;
        this.pages = pages;
        this.totalCount = totalCount;
    }

    public String getName() {
        return name;
    }

    public Long getPages() {
        return pages;
    }

    public Long getTotalCount() {
        return totalCount;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPages(Long pages) {
        this.pages = pages;
    }

    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Queue queue = (Queue) o;

        if (!name.equals(queue.name)) return false;
        if (!pages.equals(queue.pages)) return false;
        return totalCount.equals(queue.totalCount);

    }

    @Override
    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + pages.hashCode();
        result = 31 * result + totalCount.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Queue{" +
                "name='" + name + '\'' +
                ", pages=" + pages +
                ", totalCount=" + totalCount +
                '}';
    }
}
