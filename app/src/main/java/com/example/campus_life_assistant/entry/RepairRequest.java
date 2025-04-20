package com.example.campus_life_assistant.entry;

import java.io.Serializable;

public class RepairRequest implements Serializable {
    private String time;
    private String description;
    private String status;

    // 构造方法
    public RepairRequest(String time, String description, String status) {
        this.time = time;
        this.description = description;
        this.status = status;
    }

    // Getter 和 Setter 方法
    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}