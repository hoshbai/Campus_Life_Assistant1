package com.example.campus_life_assistant;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.campus_life_assistant.entry.Module;
import com.example.campus_life_assistant.entry.ModuleAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ModuleAdapter moduleAdapter;
    private List<Module> moduleList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 初始化数据
        moduleList = new ArrayList<>();
        moduleList.add(new Module("课程表", R.drawable.ic_schedule));
        moduleList.add(new Module("图书馆", R.drawable.ic_library));
        moduleList.add(new Module("食堂", R.drawable.ic_canteen));
        moduleList.add(new Module("宿舍管理", R.drawable.ic_dormitory));

        // 设置适配器
        moduleAdapter = new ModuleAdapter(this, moduleList);
        recyclerView.setAdapter(moduleAdapter);
    }
}