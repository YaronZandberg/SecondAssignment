package com.example.secondassignment.viewholders;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.secondassignment.R;
import com.example.secondassignment.model.Student;
import com.example.secondassignment.monitoring.OnListItemClickListener;

import java.util.List;

public class StudentViewHolder extends RecyclerView.ViewHolder {
    private final List<Student> students;
    private final TextView nameTv;
    private final TextView idTv;
    private final CheckBox checkBox;

    public StudentViewHolder(@NonNull View itemView,
                             OnListItemClickListener listener,
                             List<Student> students) {
        super(itemView);
        this.students = students;
        this.nameTv = itemView.findViewById(R.id.studentlist_row_name_tv);
        this.idTv = itemView.findViewById(R.id.studentlist_row_id_tv);
        this.checkBox = itemView.findViewById(R.id.studentlist_row_checkbox);
        this.checkBox.setOnClickListener(view -> {
            int position = Integer.parseInt(String.valueOf(checkBox.getTag()));
            Student student = students.get(position);
            student.setCheckBox(checkBox.isChecked());
        });
        itemView.setOnClickListener(view -> {
            int position = getAdapterPosition();
            listener.onListItemClick(position);
        });
    }

    public void bindStudent(Student student, int position) {
        nameTv.setText(student.getName());
        idTv.setText(student.getId());
        checkBox.setChecked(student.isCheckBox());
        checkBox.setTag(position);
    }
}
