package com.example.lab2_nt118;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

public class EmployeeAdapter extends ArrayAdapter<Employee> {
    private Activity context;
    private List<Boolean> isManagerList; // Danh sách để lưu trạng thái isManager

    public EmployeeAdapter(Activity context, int layoutID, List<Employee> objects, List<Boolean> isManagerList) {
        super(context, R.layout.item_employee, objects);
        this.context = context;
        this.isManagerList = isManagerList; // Khởi tạo danh sách isManager
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.item_employee, null, false);
        }

        // Lấy đối tượng nhân viên
        Employee employee = getItem(position);

        // Khai báo các view từ layout
        TextView tvFullName = convertView.findViewById(R.id.item_employee_tv_fullname);
        TextView tvPosition = convertView.findViewById(R.id.item_employee_tv_position);
        ImageView ivManager = convertView.findViewById(R.id.item_employee_iv_manager);
        LinearLayout llParent = convertView.findViewById(R.id.item_employee_ll_parent);

        // Cập nhật tên nhân viên
        if (employee != null) {
            tvFullName.setText(employee.getName());

            // Lấy trạng thái isManager từ danh sách
            boolean isManager = isManagerList.get(position);

            // Hiển thị biểu tượng nếu là Manager, nếu không hiển thị Staff
            if (isManager) {
                ivManager.setVisibility(View.VISIBLE);
                tvPosition.setVisibility(View.GONE); // Ẩn TextView vị trí
            } else {
                ivManager.setVisibility(View.GONE);
                tvPosition.setVisibility(View.VISIBLE); // Hiện TextView vị trí
                tvPosition.setText(context.getString(R.string.staff));
            }

            // Thay đổi màu nền giữa các mục
            if (position % 2 == 0) {
                llParent.setBackgroundResource(R.color.white);
            } else {
                llParent.setBackgroundResource(R.color.light_blue);
            }
        }

        return convertView;
    }
}
