package com.getbase.services

import com.getbase.models.Task
import spock.lang.Shared

class TasksServiceTest extends BaseSpecification {

    @Shared def task = task ?: createTask()

    def "List - with params"() {
        when:
        def tasks = client.tasks().list(["page": 1, "per_page": 1])

        then:
        tasks.size() > 0
    }

    def "List - with query param builder"() {
        when:
        def tasks = client.tasks().list(new TasksService.SearchCriteria().page(1).perPage(1))

        then:
        tasks.size() > 0
    }

    def "List - by ids"() {
        given:
        def tasksIds = (0..3).collect { createTask() }*.id

        when:
        def tasks = client.tasks().list(new TasksService.SearchCriteria().ids(tasksIds))

        then:
        tasks.size() == 4
        tasks*.id == tasksIds
    }

    def "Create - with attributes"() {
        when:
        def newTask = createTask()

        then:
        newTask instanceof Task
    }

    def "Get"() {
        given:
        def searched = task

        when:
        def found = client.tasks().get(searched.id)

        then:
        found instanceof Task
        found.id == searched.id
    }

    def "Update - with Lead entity"() {
        when:
        def updated = client.tasks().update(task)

        then:
        updated instanceof Task
    }

    def "Delete"() {
        given:
        def newTask = createTask()

        when:
        def result = client.tasks().delete(newTask.id)

        then:
        result
    }

}
