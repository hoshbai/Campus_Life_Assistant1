package com.example.campus_life_assistant;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.campus_life_assistant.Adapter.TransactionAdapter;
import com.example.campus_life_assistant.entry.Transaction;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class StuCardActivity extends AppCompatActivity {
    private List<Transaction> transactions = new ArrayList<>();
    private TransactionAdapter adapter;
    private TextView tvBalance;
    private double balance = 0.0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stu_card);

        // 初始化模拟数据
        transactions.add(new Transaction("2024-04-01", 100.00));
        transactions.add(new Transaction("2024-04-05", 50.00));
        balance = calculateBalance();

        setupRecyclerView();
        setupUI();
    }

    private void setupRecyclerView() {
        RecyclerView rvTransactions = findViewById(R.id.rvTransactions);
        rvTransactions.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        adapter = new TransactionAdapter(transactions);
        rvTransactions.setLayoutManager(new LinearLayoutManager(this));
        rvTransactions.setAdapter(adapter);
    }

    private void setupUI() {
        tvBalance = findViewById(R.id.tvBalance);
        tvBalance.setText(String.format("当前余额：￥%.2f", balance));

        Button btnRecharge = findViewById(R.id.btnRecharge);
        btnRecharge.setOnClickListener(v -> {
            EditText etAmount = findViewById(R.id.etAmount);
            double amount = Double.parseDouble(etAmount.getText().toString());

            // 添加新交易记录
            String currentDate = new SimpleDateFormat("yyyy-MM-dd").format(new Date());
            Transaction newTransaction = new Transaction(currentDate, amount);
            transactions.add(0, newTransaction); // 插入到顶部
            balance += amount;

            // 更新UI
            adapter.notifyItemInserted(0);
            tvBalance.setText(String.format("当前余额：￥%.2f", balance));
            etAmount.setText("");

            // 预留数据库操作
            // new DatabaseHelper(this).insertCardTransaction(newTransaction);
        });
    }

    private double calculateBalance() {
        double total = 0.0;
        for (Transaction t : transactions) {
            total += t.getAmount();
        }
        return total;
    }
}