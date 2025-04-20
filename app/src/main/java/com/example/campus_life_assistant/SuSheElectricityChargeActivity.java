package com.example.campus_life_assistant;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SuSheElectricityChargeActivity extends AppCompatActivity {

    private EditText etAmount;
    private TextView tvBalance;

    // 将 balance 提升为类的成员变量
    private double balance = 50.0; // 模拟初始余额

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sushe_electricity_charge); // 加载充电费页面布局

        etAmount = findViewById(R.id.etAmount);
        tvBalance = findViewById(R.id.tvBalance);
        Button btnCharge = findViewById(R.id.btnCharge);

        // 初始化余额显示
        updateBalance(balance);

        // 设置充值按钮点击事件
        btnCharge.setOnClickListener(v -> {
            String inputAmount = etAmount.getText().toString().trim();
            if (inputAmount.isEmpty()) {
                Toast.makeText(this, "请输入充值金额", Toast.LENGTH_SHORT).show();
                return;
            }

            try {
                double amount = Double.parseDouble(inputAmount);
                if (amount < 10) {
                    Toast.makeText(this, "充值金额必须大于等于 ¥10.00", Toast.LENGTH_SHORT).show();
                    return;
                }

                // 更新余额
                balance += amount;
                updateBalance(balance);

                // 清空输入框
                etAmount.setText("");

                // 显示成功提示
                Toast.makeText(this, "充值成功！当前余额：¥" + balance, Toast.LENGTH_SHORT).show();
            } catch (NumberFormatException e) {
                Toast.makeText(this, "请输入有效的金额", Toast.LENGTH_SHORT).show();
            }
        });
    }

    // 更新余额显示
    private void updateBalance(double balance) {
        tvBalance.setText("当前余额：¥" + String.format("%.2f", balance));
    }
}