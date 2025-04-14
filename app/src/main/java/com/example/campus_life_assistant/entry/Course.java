package com.example.campus_life_assistant.entry;

public class Course {
    private String name; // 课程名称
    private String teacher; // 授课教师
    private int week; // 所属周
    private String dayOfWeek; // 星期几（周一到周日）
    private int period; // 节次（1-8）

    public Course(String name, String teacher, int week, String dayOfWeek, int period) {
        this.name = name;
        this.teacher = teacher;
        this.week = week;
        this.dayOfWeek = dayOfWeek;
        this.period = period;
    }

    public String getName() {
        return name;
    }

    public String getTeacher() {
        return teacher;
    }

    public int getWeek() {
        return week;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public int getPeriod() {
        return period;
    }
}