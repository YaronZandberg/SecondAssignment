package com.example.secondassignment.model;

import java.util.ArrayList;
import java.util.List;

public class Model {
    private static final Model modelInstance = new Model();

    private Model() {
        for (int i = 0; i < 20; i++) {
            this.addStudent(new Student("name " + i, "" + i, "", false));
        }
    }

    public static Model instance() {
        return modelInstance;
    }

    List<Student> data = new ArrayList();

    public List<Student> getAllStudents() {
        return data;
    }

    public Student getStudentById(Integer studentId){
        return data.get(studentId);
    }

    public void addStudent(Student st) {
        data.add(st);
    }

    public void removeStudent(Student st) {
        data.remove(st);
    }
}
