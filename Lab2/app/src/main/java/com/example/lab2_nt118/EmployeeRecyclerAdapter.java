package com.example.lab2_nt118;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EmployeeRecyclerAdapter extends RecyclerView.Adapter<EmployeeRecyclerAdapter.EmployeeViewHolder> {
    private List<Employee> employeeList;
    private List<Boolean> isManagerList;
    private Activity context;

    public EmployeeRecyclerAdapter(Activity context, List<Employee> employeeList, List<Boolean> isManagerList) {
        this.context = context;
        this.employeeList = employeeList;
        this.isManagerList = isManagerList;
    }

    @Override
    public EmployeeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_employee, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(EmployeeViewHolder holder, int position) {
        Employee employee = employeeList.get(position);
        holder.tvFullName.setText(employee.getName());
        boolean isManager = isManagerList.get(position);

        if (isManager) {
            holder.ivManager.setVisibility(View.VISIBLE);
            holder.tvPosition.setVisibility(View.GONE);
        } else {
            holder.ivManager.setVisibility(View.GONE);
            holder.tvPosition.setVisibility(View.VISIBLE);
            holder.tvPosition.setText(context.getString(R.string.staff));
        }
        // Thay đổi màu nền giữa các mục
        if (position % 2 == 0) {
            holder.itemView.setBackgroundResource(R.color.white); // Màu trắng cho mục chẵn
        } else {
            holder.itemView.setBackgroundResource(R.color.light_blue); // Màu xanh nhạt cho mục lẻ
        }
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    public static class EmployeeViewHolder extends RecyclerView.ViewHolder {
        TextView tvFullName;
        TextView tvPosition;
        ImageView ivManager;

        public EmployeeViewHolder(View itemView) {
            super(itemView);
            tvFullName = itemView.findViewById(R.id.item_employee_tv_fullname);
            tvPosition = itemView.findViewById(R.id.item_employee_tv_position);
            ivManager = itemView.findViewById(R.id.item_employee_iv_manager);
        }
    }
}
