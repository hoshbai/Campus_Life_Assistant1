//package com.example.campus_life_assistant.Dao;
//
//import android.content.Context;
//import android.graphics.Color;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.TextView;
//import androidx.annotation.NonNull;
//import androidx.recyclerview.widget.RecyclerView;
//
//import com.example.campus_life_assistant.R;
//import com.example.campus_life_assistant.entry.Course;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class CourseAdapter extends RecyclerView.Adapter<CourseAdapter.ViewHolder> {
//    private List<Course> courses;
//    private Map<String, Integer> courseColors = new HashMap<>(); // 不同课程名称对应的颜色
//
//    public CourseAdapter(List<Course> courses) {
//        this.courses = courses;
//    }
//
//    // 更新数据的方法
//    public void updateData(List<Course> newData) {
//        this.courses = newData;
//        notifyDataSetChanged();
//    }
//
//    @NonNull
//    @Override
//    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
//        View view = LayoutInflater.from(parent.getContext())
//                .inflate(R.layout.item_course, parent, false);
//        return new ViewHolder(view);
//    }
//
//    @Override
//    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        Course course = courses.get(position);
//
//        // 设置课程信息
//        holder.tvCourseName.setText(course.getName());
//        holder.tvTeacher.setText(course.getTeacher());
//
//        // 根据课程名称设置背景颜色
//        int color = getCourseColor(holder.itemView.getContext(), course.getName());
//        holder.itemView.setBackgroundColor(color);
//    }
//
//    @Override
//    public int getItemCount() {
//        return courses.size();
//    }
//
//    // 获取课程颜色（为每个课程生成唯一颜色）
//    private int getCourseColor(Context context, String courseName) {
//        if (!courseColors.containsKey(courseName)) {
//            // 生成随机颜色并缓存
//            int randomColor = Color.rgb(
//                    (int) (Math.random() * 256),
//                    (int) (Math.random() * 256),
//                    (int) (Math.random() * 256)
//            );
//            courseColors.put(courseName, randomColor);
//        }
//        return courseColors.get(courseName);
//    }
//
//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        public TextView tvCourseName;
//        public TextView tvTeacher;
//
//        public ViewHolder(View view) {
//            super(view);
//            tvCourseName = view.findViewById(R.id.tvCourseName);
//            tvTeacher = view.findViewById(R.id.tvTeacher);
//        }
//    }
//}