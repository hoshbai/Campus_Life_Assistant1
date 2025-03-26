package com.example.campus_life_assistant;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String DB_URL = "jdbc:mysql://47.98.61.53:3306/AD";
    private static final String DB_USER = "remote_user";
    private static final String DB_PASSWORD = "FengKefeng520!";

    public DatabaseHelper(Context context) {
        // 初始化上下文（如果需要）
    }

    // 获取数据库连接
    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    // 注册用户（异步执行）
    public void registerUser(String username, String password, OnRegisterListener listener) {
        new RegisterTask(listener).execute(username, password);
    }

    // 检查用户凭据（异步执行）
    public void checkUserCredentials(String username, String password, OnLoginListener listener) {
        new LoginTask(listener).execute(username, password);
    }

    // 异步任务：注册用户
    private class RegisterTask extends AsyncTask<String, Void, Boolean> {
        private OnRegisterListener listener;

        public RegisterTask(OnRegisterListener listener) {
            this.listener = listener;
        }

        @Override
        protected Boolean doInBackground(String... params) {
            String username = params[0];
            String password = params[1];

            String query = "INSERT INTO users (username, password) VALUES (?, ?)";
            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                int rowsAffected = stmt.executeUpdate();
                return rowsAffected > 0;
            } catch (SQLException e) {
                Log.e(TAG, "Error registering user", e);
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if (listener != null) {
                listener.onRegisterResult(success);
            }
        }
    }

    // 异步任务：检查用户凭据
    private class LoginTask extends AsyncTask<String, Void, Boolean> {
        private OnLoginListener listener;

        public LoginTask(OnLoginListener listener) {
            this.listener = listener;
        }

        @Override
        protected Boolean doInBackground(String... params) {
            String username = params[0];
            String password = params[1];

            String query = "SELECT id FROM users WHERE username = ? AND password = ?";
            try (Connection conn = getConnection();
                 PreparedStatement stmt = conn.prepareStatement(query)) {
                stmt.setString(1, username);
                stmt.setString(2, password);
                ResultSet rs = stmt.executeQuery();
                return rs.next(); // 如果有匹配的记录，返回 true
            } catch (SQLException e) {
                Log.e(TAG, "Error checking user credentials", e);
                return false;
            }
        }

        @Override
        protected void onPostExecute(Boolean success) {
            if (listener != null) {
                listener.onLoginResult(success);
            }
        }
    }

    // 回调接口：注册结果
    public interface OnRegisterListener {
        void onRegisterResult(boolean success);
    }

    // 回调接口：登录结果
    public interface OnLoginListener {
        void onLoginResult(boolean success);
    }
}