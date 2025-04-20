package com.example.campus_life_assistant;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.campus_life_assistant.entry.RepairRequest;

public class SuSheRepairProcessActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sushe_repair_process);

        // 获取传递的报修数据
        RepairRequest request = (RepairRequest) getIntent().getSerializableExtra("repairRequest");

        // 初始化视图
        TextView tvStudentInfo = findViewById(R.id.tvStudentInfo);
        TextView tvDormManagerInfo = findViewById(R.id.tvDormManagerInfo);
        TextView tvRepairmanContact = findViewById(R.id.tvRepairmanContact);
        TextView tvRepairCompletion = findViewById(R.id.tvRepairCompletion);
        EditText etEvaluation = findViewById(R.id.etEvaluation);
        Button btnSubmitEvaluation = findViewById(R.id.btnSubmitEvaluation);

        // 填充数据
        tvStudentInfo.setText("学生姓名：张三\n宿舍号：A101");
        tvDormManagerInfo.setText("宿管姓名：李四\n手机号：12345678901");
        tvRepairmanContact.setText("维修员姓名：王五\n手机号：98765432101\n预定上门时间：2024-04-02 10:00");
        tvRepairCompletion.setText("维修员姓名：王五\n手机号：98765432101\n维修完成时间：2024-04-02 12:00");

        // 提交评价
        btnSubmitEvaluation.setOnClickListener(v -> {
            String evaluation = etEvaluation.getText().toString().trim();
            if (!evaluation.isEmpty()) {
                Toast.makeText(this, "评价已提交：" + evaluation, Toast.LENGTH_SHORT).show();
                etEvaluation.setText("");
            } else {
                Toast.makeText(this, "请输入评价内容", Toast.LENGTH_SHORT).show();
            }
        });
    }
}