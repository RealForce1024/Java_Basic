package com.fqc.jdk8;

import java.util.ArrayList;
import java.util.Arrays;

public class test10 {
    static int[][] scroes = {
            {70, 30, 50, 40, 10}, {20, 30, 50, 40, 60},
            {20, 30, 50, 40, 10}, {20, 30, 50, 40, 20},
            {20, 30, 50, 40, 10}, {20, 30, 50, 40, 20},
            {20, 30, 50, 40, 10}, {20, 30, 50, 40, 80},
            {20, 30, 50, 40, 10}, {20, 30, 50, 40, 40},
    };

    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>(12);
        for (int i = 1; i <= 10; i++) {
            Student stu = new Student(i, "name" + i, i % 2 == 0 ? 1 : 2);
            stu.setScores(scroes[i - 1]);
            students.add(stu);
        }

        Student stu11 = new Student(11, "name11", 2);
        stu11.setScores(new int[]{});
        students.add(stu11);

        students.stream().mapToDouble(x -> Arrays.stream(x.getScores()).average().orElse(0)).forEach(System.out::println);
        System.out.println("========");
        students.stream().forEach(x -> System.out.println(x.getName() + ":avg" + Arrays.stream(x.getScores()).average().orElse(0)));//0
        System.out.println("========");
        students.stream().forEach(x -> System.out.println(x.getName() + ":avg" + Arrays.stream(x.getScores()).average()));//empty
        System.out.println("========");
        students.stream().forEach(stu -> Arrays.stream(stu.getScores()).average().ifPresent(System.out::println));
    }
}

class Student {
    private Integer id;
    private String name;
    private int classNo;

    private int[] scores;
    private double avg;

    public double getAvg() {
        return avg;
    }

    public void setAvg(double avg) {
        this.avg = avg;
    }

    public int[] getScores() {
        return scores;
    }

    public void setScores(int[] scores) {
        this.scores = scores;
    }

    public Student(Integer id, String name, int classNo) {
        this.id = id;
        this.name = name;
        this.classNo = classNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getClassNo() {
        return classNo;
    }

    public void setClassNo(int classNo) {
        this.classNo = classNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", classNo=" + classNo +
                ", scores=" + Arrays.toString(scores) +
                '}';
    }
}
