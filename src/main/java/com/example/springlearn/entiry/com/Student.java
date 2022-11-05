package com.example.springlearn.entiry.com;

import lombok.Data;


/**
 * @author <lmx>
 * @since 2022/11/4 21:59
 */
@Data
public class Student {



    private long id;
    private String name;
    private int age;


    public Student(long l, String s, int i) {
        this.id=l;
        this.name=s;
        this.age=i;
    }
}
