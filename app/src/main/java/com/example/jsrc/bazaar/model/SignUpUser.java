package com.example.jsrc.bazaar.model;

import java.io.Serializable;

public class SignUpUser implements Serializable
{
    private final String _id;
    private final String _userName;
    private final String _password;
    private final String _email;

    public SignUpUser(String id,
                String userName,
                String password,
                String email)
    {
        _id = id;
        _userName = userName;
        _password = password;
        _email = email;
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

    public String getEmail() {
        return _email;
    }

}

