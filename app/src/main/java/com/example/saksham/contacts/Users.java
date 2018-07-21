package com.example.saksham.contacts;

/**
 * Created by saksham on 21-07-2018.
 */

public class Users {


    private String Name;
    private String PhnNum;

    public Users(){

    }

    public Users(String name, String phone) {
        Name = name;
        PhnNum = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return PhnNum;
    }

    public void setPhone(String phone) {
        PhnNum = phone;
    }
}
