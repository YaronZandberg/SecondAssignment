package com.example.secondassignment.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.secondassignment.R;
import com.example.secondassignment.model.Student;
import com.example.secondassignment.monitoring.OnListItemClickListener;
import com.example.secondassignment.viewholders.StudentViewHolder;

import java.util.List;

public class StudentRecyclerAdapter extends RecyclerView.Adapter<StudentViewHolder> {
    private final LayoutInflater layoutInflater;
    private final List<Student> students;
    private OnListItemClickListener listener;

    public StudentRecyclerAdapter(LayoutInflater layoutInflater, List<Student> students){
        this.layoutInflater = layoutInflater;
        this.students = students;
    }

    public void setOnItemClickListener(OnListItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.student_list_row, parent, false);
        return (new StudentViewHolder(view, listener, students));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder studentViewHolder, int position) {
        Student student = students.get(position);
        studentViewHolder.bindStudent(student, position);
    }

    @Override
    public int getItemCount() {
        return students.size();
    }
}
