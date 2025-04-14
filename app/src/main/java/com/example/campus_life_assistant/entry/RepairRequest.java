package com.example.campus_life_assistant.entry;

import java.util.Date;

public class RepairRequest {
    private String time;
    private String description;
    private String status;

    public RepairRequest(String time, String description, String status) {
        this.time = time;
        this.description = description;
        this.status = status;
    }

    public String getTime() {
        return time;
    }

    public String getDescription() {
        return description;
    }

    public String getStatus() {
        return status;
    }
// Getters and setters
}