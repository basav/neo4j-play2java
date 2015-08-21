package org.neo.models;

/*
 * Copyright (c)  [2011-2015] "Neo Technology" / "Graph Aware Ltd."
 *
 * This product is licensed to you under the Apache License, Version 2.0 (the "License").
 * You may not use this product except in compliance with the License.
 *
 * This product may include a number of subcomponents with separate copyright notices and license terms. Your use of the source code for these subcomponents is subject to the terms and conditions of the subcomponent's license, as noted in the LICENSE file.
 *
 *
 */

import com.fasterxml.jackson.annotation.JsonProperty;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import java.util.HashSet;
import java.util.Set;

@NodeEntity
public class Student extends Entity {

    @JsonProperty("name")
    String name;

    @Relationship(type = "ENROLLED")
    Set<Enrollment> enrollments = new HashSet<>();

//	Set<Course> courses = new HashSet<>()

    @Relationship(type = "BUDDY", direction = Relationship.INCOMING)
    Set<StudyBuddy> studyBuddies;

    public Student() {
        this.studyBuddies = new HashSet<>();
        this.enrollments = new HashSet<>();
    }

    public Student(String name) {
        this();
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + getId() +
                ", name='" + name + '\'' +
                ", courses=" + enrollments.size() +
                ", studyBuddies=" + studyBuddies.size() +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Enrollment> getEnrollments() {
        return enrollments;
    }

    public void setEnrollments(Set<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }

    public Set<StudyBuddy> getStudyBuddies() {
        return studyBuddies;
    }

    public void setStudyBuddies(Set<StudyBuddy> studyBuddies) {
        this.studyBuddies = studyBuddies;
    }
}
