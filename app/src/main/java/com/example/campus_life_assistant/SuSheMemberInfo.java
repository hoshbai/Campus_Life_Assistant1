package com.example.campus_life_assistant;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class SuSheMemberInfo extends AppCompatActivity {

    private ImageView ivMyAvatar;
    private TextView tvMyName, tvMyStudentId, tvMyBedNumber, tvMyBirthday, tvMyAge, tvMyPhone;
    private Button btnRefresh, btnEdit;

    // 用于存储个人信息
    private String myPhone = "1234567890"; // 默认联系方式

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sushe_member_info);

        // 初始化视图
        ivMyAvatar = findViewById(R.id.ivMyAvatar);
        tvMyName = findViewById(R.id.tvMyName);
        tvMyStudentId = findViewById(R.id.tvMyStudentId);
        tvMyBedNumber = findViewById(R.id.tvMyBedNumber);
        tvMyBirthday = findViewById(R.id.tvMyBirthday);
        tvMyAge = findViewById(R.id.tvMyAge);
        tvMyPhone = findViewById(R.id.tvMyPhone);
        btnRefresh = findViewById(R.id.btnRefresh);
        btnEdit = findViewById(R.id.btnEdit);

        // 模拟加载数据
        loadMemberData();

        // 刷新按钮点击事件
        btnRefresh.setOnClickListener(v -> {
            Toast.makeText(this, "数据已刷新", Toast.LENGTH_SHORT).show();
            loadMemberData(); // 重新加载数据
        });

        // 编辑按钮点击事件
        btnEdit.setOnClickListener(v -> showEditDialog());
    }

    private void loadMemberData() {
        // 模拟个人信息数据
        tvMyName.setText("姓名：李四");
        tvMyStudentId.setText("学号：20201234");
        tvMyBedNumber.setText("床位号：A01");
        tvMyBirthday.setText("生日：2000年1月1日");
        tvMyAge.setText("年龄：23岁");
        tvMyPhone.setText("联系方式：" + myPhone);

        // 模拟其他成员数据
        List<Member> members = new ArrayList<>();
        members.add(new Member("王五", "A02", "2001年3月15日", "22岁", "1122334455"));
        members.add(new Member("赵六", "A03", "1998年8月20日", "25岁", "2233445566"));

        // 动态加载其他成员信息
        LinearLayout llOtherMembers = findViewById(R.id.llOtherMembers);
        llOtherMembers.removeAllViews(); // 清空旧数据

        for (Member member : members) {
            View itemView = getLayoutInflater().inflate(R.layout.item_member, null);
            TextView tvMemberName = itemView.findViewById(R.id.tvMemberName);
            TextView tvMemberBedNumber = itemView.findViewById(R.id.tvMemberBedNumber);
            TextView tvMemberBirthday = itemView.findViewById(R.id.tvMemberBirthday);
            TextView tvMemberAge = itemView.findViewById(R.id.tvMemberAge);
            TextView tvMemberPhone = itemView.findViewById(R.id.tvMemberPhone);

            tvMemberName.setText(member.getName());
            tvMemberBedNumber.setText("床位号：" + member.getBedNumber());
            tvMemberBirthday.setText("生日：" + member.getBirthday());
            tvMemberAge.setText("年龄：" + member.getAge());
            tvMemberPhone.setText("联系方式：" + member.getPhone());

            llOtherMembers.addView(itemView);
        }
    }

    // 显示编辑对话框
    private void showEditDialog() {
        // 创建对话框布局
        View dialogView = getLayoutInflater().inflate(R.layout.dialog_edit_profile, null);

        // 获取对话框中的控件
        ImageView ivAvatar = dialogView.findViewById(R.id.ivEditAvatar);
        EditText etPhone = dialogView.findViewById(R.id.etEditPhone);

        // 设置默认值
        ivAvatar.setImageDrawable(ivMyAvatar.getDrawable());
        etPhone.setText(myPhone);

        // 创建对话框
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("编辑个人信息")
                .setView(dialogView)
                .setPositiveButton("保存", (dialog, which) -> {
                    // 更新头像
                    Bitmap avatarBitmap = ((BitmapDrawable) ivAvatar.getDrawable()).getBitmap();
                    ivMyAvatar.setImageBitmap(avatarBitmap);

                    // 更新联系方式
                    String newPhone = etPhone.getText().toString().trim();
                    if (!newPhone.isEmpty()) {
                        myPhone = newPhone;
                        tvMyPhone.setText("联系方式：" + myPhone);
                        Toast.makeText(this, "信息已保存", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "联系方式不能为空", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("取消", null)
                .show();
    }

    // 成员实体类
    static class Member {
        private String name;
        private String bedNumber;
        private String birthday;
        private String age;
        private String phone;

        public Member(String name, String bedNumber, String birthday, String age, String phone) {
            this.name = name;
            this.bedNumber = bedNumber;
            this.birthday = birthday;
            this.age = age;
            this.phone = phone;
        }

        public String getName() {
            return name;
        }

        public String getBedNumber() {
            return bedNumber;
        }

        public String getBirthday() {
            return birthday;
        }

        public String getAge() {
            return age;
        }

        public String getPhone() {
            return phone;
        }
    }
}