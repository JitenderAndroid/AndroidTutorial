package com.jitenderkumar.demoducat.activities;

class SingletonClass {

    private static SingletonClass singletonClass;
    private int specialNumber;

    private SingletonClass() {
    }

    public static SingletonClass getInstance() {
        if (singletonClass == null) {
            singletonClass = new SingletonClass();
        }

        return singletonClass;
    }

    public int getSpecialNumber() {
        return specialNumber;
    }

    public void setSpecialNumber(int specialNumber) {
        this.specialNumber = specialNumber;
    }
}
