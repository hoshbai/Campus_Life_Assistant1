package com.example.campus_life_assistant;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.campus_life_assistant.fragment.HomeFragment;
import com.example.campus_life_assistant.fragment.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 初始化底部导航栏
        bottomNavigationView = findViewById(R.id.bottom_navigation);

        // 默认加载首页
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.frame_container, new HomeFragment())
                .commit();

        // 设置底部导航栏点击事件
        bottomNavigationView.setOnItemSelectedListener(item -> {
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, new HomeFragment())
                        .commit();
                return true;
            } else if (itemId == R.id.nav_profile) {
                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame_container, new ProfileFragment())
                        .commit();
                return true;
            }
            return false;
        });
    }
}