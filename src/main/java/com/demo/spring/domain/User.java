package com.demo.spring.domain;

<<<<<<< Updated upstream
=======
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

>>>>>>> Stashed changes
/**
 * Created by Liam on 19/04/17.
 */
public class User
{
<<<<<<< Updated upstream
=======
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;

    @NotEmpty
>>>>>>> Stashed changes
    String forename;
    @NotEmpty
    String surname;
    @NotEmpty
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
