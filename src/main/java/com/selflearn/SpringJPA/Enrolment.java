package com.selflearn.SpringJPA;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "enrolment")
@Entity(name = "Enrolment")
public class Enrolment {
    @EmbeddedId
    private EnrolmentId id;
    @ManyToOne
    @MapsId("studentId")
    @JoinColumn(name = "student_id")
    private Student student;
    @ManyToOne
    @MapsId("courseId")
    @JoinColumn(name = "course_id")
    private Course course;

    @Column(name = "created_at",nullable = false,columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
    private LocalDateTime createdAt;

    public Enrolment(EnrolmentId id, Student student, Course course,LocalDateTime createdAt) {
        this.id = id;
        this.student = student;
        this.course = course;
        this.createdAt = createdAt;
    }

    public Enrolment(Student student, Course course,LocalDateTime createdAt) {
        this.student = student;
        this.course = course;
        this.createdAt =createdAt;
    }

    public Enrolment() {
    }

    public EnrolmentId getId() {
        return id;
    }

    public void setId(EnrolmentId id) {
        this.id = id;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }
}
