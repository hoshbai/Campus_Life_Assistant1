package com.example.campus_life_assistant;
import android.icu.text.SimpleDateFormat;
import android.widget.TextView;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;
import java.util.Locale;

public class SuSheMainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sushe_main);

        // 初始化功能卡片点击事件
        findViewById(R.id.cvRepair).setOnClickListener(v -> {
            startActivity(new Intent(this, RepairActivity.class));
        });

        findViewById(R.id.cvCharge).setOnClickListener(v -> {
            Toast.makeText(this, "功能开发中", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.cvMembers).setOnClickListener(v -> {
            Toast.makeText(this, "功能开发中", Toast.LENGTH_SHORT).show();
        });

        findViewById(R.id.cvNotice).setOnClickListener(v -> {
            Toast.makeText(this, "功能开发中", Toast.LENGTH_SHORT).show();
        });

        // 设置当前日期
        TextView tvDate = findViewById(R.id.tvDate);
        String currentDate = new SimpleDateFormat("yyyy年MM月dd日", Locale.CHINA).format(new Date());
        tvDate.setText(currentDate);
    }
}