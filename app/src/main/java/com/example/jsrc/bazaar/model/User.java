package com.example.jsrc.bazaar.model;

import java.io.Serializable;

public class User implements Serializable
{
    private final String _id;
    private final String _userName;
    private final String _password;
    private final String _email;
//    private final Double _distance;
//    private final Preferences _preferences;

    public User(String id,
                String userName,
                String password,
                String email)
    {
        _id = id;
        _userName = userName;
        _password = password;
        _email = email;
//        _distance = distance;
//        _preferences = preferences;
    }


    public String getId() {
        return _id;
    }

    public String getUserName()
    {
        return _userName;
    }

    public String getPassword()
    {
        return _password;
    }

//    public Double getDistance()
//    {
//        return _distance;
//    }
//
//    public Preferences getPreferences()
//    {
//        return _preferences;
//    }

    public String getEmail() {
        return _email;
    }
}

