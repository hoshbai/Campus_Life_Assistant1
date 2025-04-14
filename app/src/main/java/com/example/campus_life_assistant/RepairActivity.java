package com.example.campus_life_assistant;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Button;
import android.widget.EditText;

import com.example.campus_life_assistant.Adapter.RepairAdapter;
import com.example.campus_life_assistant.entry.RepairRequest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class RepairActivity extends AppCompatActivity {
    private List<RepairRequest> requests = new ArrayList<>();
    private RepairAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_repair_request);

        // 初始化模拟数据
        requests.add(new RepairRequest("2024-04-01 14:30", "浴室漏水", "处理中"));

        setupRecyclerView();
        setupUI();
    }

    private void setupRecyclerView() {
        RecyclerView rvRepairs = findViewById(R.id.rvRepairs);
        rvRepairs.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new RepairAdapter(requests);
        rvRepairs.setLayoutManager(new LinearLayoutManager(this));
        rvRepairs.setAdapter(adapter);
    }

    private void setupUI() {
        Button btnSubmit = findViewById(R.id.btnSubmit);
        btnSubmit.setOnClickListener(v -> {
            EditText etDescription = findViewById(R.id.etDescription);
            String desc = etDescription.getText().toString().trim();

            if (!desc.isEmpty()) {
                String currentTime = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());
                RepairRequest newRequest = new RepairRequest(currentTime, desc, "已提交");
                requests.add(0, newRequest);
                adapter.notifyItemInserted(0);
                etDescription.setText("");

                // 预留数据库操作
                // new RepairDatabaseHelper(this).insertRepairRequest(newRequest);
            }
        });
    }
}