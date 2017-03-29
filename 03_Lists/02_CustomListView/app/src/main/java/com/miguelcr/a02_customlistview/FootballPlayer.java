package com.miguelcr.a02_customlistview;

/**
 * Created by miguelcampos on 29/3/17.
 */

class FootballPlayer {
    private String name;
    private int age;
    private String photo;
    private int goals;

    public FootballPlayer(String name, int age, String photo, int goals) {
        this.name = name;
        this.age = age;
        this.photo = photo;
        this.goals = goals;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public int getGoals() {
        return goals;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }
}
