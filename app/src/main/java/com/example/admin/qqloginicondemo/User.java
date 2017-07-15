package com.example.admin.qqloginicondemo;

public class User {
    private String userPhotoUrl;
    private String userName;
    private String city;

    public User(String userPhotoUrl, String userName, String city) {
        this.userPhotoUrl = userPhotoUrl;
        this.userName = userName;
        this.city = city;
    }

    public String getUserPhotoUrl() {
        return userPhotoUrl;
    }

    public void setUserPhotoUrl(String userPhotoUrl) {
        this.userPhotoUrl = userPhotoUrl;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
