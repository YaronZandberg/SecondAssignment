package com.example.secondassignment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.example.secondassignment.adapters.StudentRecyclerAdapter;
import com.example.secondassignment.model.Model;
import com.example.secondassignment.model.Student;

import java.util.List;

public class StudentRecyclerListActivity extends AppCompatActivity {
    private List<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_recycler_list);

        students = Model.instance().getAllStudents();
        RecyclerView list = findViewById(R.id.studentRecycler_list);
        list.setHasFixedSize(true);

        list.setLayoutManager(new LinearLayoutManager(this));
        StudentRecyclerAdapter studentRecyclerAdapter =
                new StudentRecyclerAdapter(getLayoutInflater(), students);
        list.setAdapter(studentRecyclerAdapter);

        studentRecyclerAdapter.setOnItemClickListener(position ->
                Log.d("TAG", "Row was clicked " + position));
    }
}