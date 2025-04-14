//package com.example.campus_life_assistant;
//
//import android.os.Bundle;
//import android.view.Menu;
//import android.view.MenuItem;
//import android.widget.Toast;
//
//import androidx.annotation.NonNull;
//import androidx.appcompat.app.AppCompatActivity;
//
//import com.google.android.material.card.MaterialCardView;
//import com.google.android.material.snackbar.Snackbar;
//
//public class HomeActivity extends AppCompatActivity {
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_home);
//
//        // 设置工具栏
//        setSupportActionBar(findViewById(R.id.topAppBar));
//
//        // 设置功能卡片点击事件
//        setupCardClickListeners();
//    }
//
//    private void setupCardClickListeners() {
//        // 课程表卡片
//        MaterialCardView scheduleCard = findViewById(R.id.btn_schedule);
//        scheduleCard.setOnClickListener(v -> {
//            // TODO: 跳转到课程表界面
//            showFeatureComingSoon();
//        });
//
//        // 图书馆卡片
//        MaterialCardView libraryCard = findViewById(R.id.libraryCard);
//        libraryCard.setOnClickListener(v -> {
//            // TODO: 跳转到图书馆界面
//            showFeatureComingSoon();
//        });
//
//        // 食堂卡片
//        MaterialCardView canteenCard = findViewById(R.id.btn_card_record);
//        canteenCard.setOnClickListener(v -> {
//            // TODO: 跳转到食堂界面
//            showFeatureComingSoon();
//        });
//
//        // 宿舍卡片
//        MaterialCardView dormitoryCard = findViewById(R.id.btn_maintenance);
//        dormitoryCard.setOnClickListener(v -> {
//            // TODO: 跳转到宿舍界面
//            showFeatureComingSoon();
//        });
//    }
//
//    private void showFeatureComingSoon() {
//        Snackbar.make(findViewById(android.R.id.content),
//                "该功能正在开发中，敬请期待！",
//                Snackbar.LENGTH_SHORT).show();
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.top_app_bar, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if (item.getItemId() == R.id.action_settings) {
//            // TODO: 跳转到设置界面
//            showFeatureComingSoon();
//            return true;
//        }
//        return super.onOptionsItemSelected(item);
//    }
//}