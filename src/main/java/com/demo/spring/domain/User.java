package com.demo.spring.domain;

/**
 * Created by Liam on 19/04/17.
 */
public class User
{
    String forename;
    String surname;
    String password;

    public String getForename()
    {
        return forename;
    }

    public void setForename(String forename) {
        this.forename = forename;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
