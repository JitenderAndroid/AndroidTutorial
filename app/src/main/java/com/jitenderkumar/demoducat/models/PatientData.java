package com.jitenderkumar.demoducat.models;

public class PatientData {
    private String id = null;
    private String name = null;
    private String age = null;
    private String dob = null;
    private String city = null;
    private String gender = null;

    public PatientData() {
    }

    public PatientData(String id, String name, String age, String dob, String city, String gender) {
        this.name = name;
        this.age = age;
        this.dob = dob;
        this.city = city;
        this.gender = gender;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }
}
