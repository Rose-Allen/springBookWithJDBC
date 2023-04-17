package ru.dimash.spring.models;

import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Person {
    private int id;
    @NotEmpty(message = "Имя не должно быть пустым")
    @Size(min = 2, max = 100, message = "Имя должно быть от 2 до 100 символов длиной")
    private String fullname;
    @Min(value = 1900, message = "Год рождения должен быть больше, чем 1900")
    private int birthday;

    public Person(){

    }

    public Person(String fullname, int birthday) {
        this.fullname = fullname;
        this.birthday = birthday;
    }

    public Person(int id, String fullname, int birthday) {
        this.id = id;
        this.fullname = fullname;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }
}
