package com.example.campus_life_assistant;

public class Module {
    private String name;
    private int iconResId;

    public Module(String name, int iconResId) {
        this.name = name;
        this.iconResId = iconResId;
    }

    public String getName() {
        return name;
    }

    public int getIconResId() {
        return iconResId;
    }
}