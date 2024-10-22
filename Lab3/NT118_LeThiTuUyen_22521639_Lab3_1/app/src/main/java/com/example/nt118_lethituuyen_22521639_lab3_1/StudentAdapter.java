package com.example.nt118_lethituuyen_22521639_lab3_1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.ViewHolder> {

    private List<Student> studentList;
    private Context context;
    private OnStudentClickListener onStudentClickListener;

    // Constructor
    public StudentAdapter(Context context, List<Student> studentList, OnStudentClickListener onStudentClickListener) {
        this.context = context;
        this.studentList = studentList;
        this.onStudentClickListener = onStudentClickListener;
    }

    // Tạo ViewHolder
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_student, parent, false);
        return new ViewHolder(view, onStudentClickListener);
    }

    // Gắn dữ liệu lên View
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Student student = studentList.get(position);
        // Hiển thị ID, tên theo định dạng "id - tên"
        holder.tvIdName.setText(student.getId() + " - " + student.getName());
    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    // Xóa một sinh viên
    public void removeStudent(int position) {
        studentList.remove(position);
        notifyItemRemoved(position);
    }

    // Cập nhật danh sách sinh viên
    public void updateStudentList(List<Student> students) {
        this.studentList = students;
        notifyDataSetChanged();
    }

    // ViewHolder class cho từng item trong RecyclerView
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {

        public TextView tvIdName; // Chỉ cần một TextView cho ID, tên
        OnStudentClickListener onStudentClickListener;

        public ViewHolder(@NonNull View itemView, OnStudentClickListener onStudentClickListener) {
            super(itemView);
            tvIdName = itemView.findViewById(R.id.tv_id_name); // Sử dụng TextView mới

            this.onStudentClickListener = onStudentClickListener;

            // Gán sự kiện click và long click cho item
            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
        }

        @Override
        public void onClick(View view) {
            onStudentClickListener.onStudentClick(getAdapterPosition());
        }

        @Override
        public boolean onLongClick(View view) {
            onStudentClickListener.onStudentLongClick(getAdapterPosition());
            return true;
        }
    }

    // Interface để xử lý sự kiện click vào từng sinh viên
    public interface OnStudentClickListener {
        void onStudentClick(int position);
        void onStudentLongClick(int position);
    }
}
