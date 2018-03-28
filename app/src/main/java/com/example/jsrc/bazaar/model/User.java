package com.example.jsrc.bazaar.model;

import java.io.Serializable;

public class User extends SignUpUser implements Serializable {

    private final int _distance;
    private final Preferences _preferences;

    public User(String id,
                String userName,
                String password,
                String email,
                int distance,
                Preferences preferences) {
        super(id, userName, password, email);
        _distance = distance;
        _preferences = preferences;
    }

    public int getDistance() {
        return _distance;
    }

    public Preferences getPreferences() {
        return _preferences;
    }

}

