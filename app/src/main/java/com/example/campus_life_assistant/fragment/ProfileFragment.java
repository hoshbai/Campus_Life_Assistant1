package com.example.campus_life_assistant.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.campus_life_assistant.R;

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // 加载布局文件
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        // 绑定视图
        ImageView ivAvatar = view.findViewById(R.id.ivAvatar);
        TextView tvUsername = view.findViewById(R.id.tvUsername);
        TextView tvBio = view.findViewById(R.id.tvBio);

        // 模拟用户数据
        String username = "张三";
        String bio = "热爱编程的学生";

        // 更新用户信息
        tvUsername.setText(username);
        tvBio.setText(bio);

        // 设置头像点击事件
        ivAvatar.setOnClickListener(v -> {
            Toast.makeText(getContext(), "更换头像", Toast.LENGTH_SHORT).show();
            // 跳转到更换头像界面
        });

        // 设置功能入口点击事件
        setupFunctionClickListeners(view);

        return view;
    }

    private void setupFunctionClickListeners(View view) {
        // 设置
        view.findViewById(R.id.settingsCard).setOnClickListener(v -> {
            Toast.makeText(getContext(), "跳转到设置界面", Toast.LENGTH_SHORT).show();
            // 跳转逻辑待实现
        });

        // 修改密码
        view.findViewById(R.id.changePasswordCard).setOnClickListener(v -> {
            Toast.makeText(getContext(), "跳转到修改密码界面", Toast.LENGTH_SHORT).show();
            // 跳转逻辑待实现
        });

        // 退出登录
        view.findViewById(R.id.logoutCard).setOnClickListener(v -> {
            Toast.makeText(getContext(), "已退出登录", Toast.LENGTH_SHORT).show();
            // 清除用户数据并跳转到登录界面
        });
    }
}