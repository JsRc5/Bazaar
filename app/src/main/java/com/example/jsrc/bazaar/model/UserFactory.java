package com.example.jsrc.bazaar.model;

import java.util.UUID;

public class UserFactory
{
    public UserFactory()
    {
    }

    public User createUser(final String userName,
                           final String password,
                           final String email,
                           final Double distance,
                           final Preferences preferences)
    {
        return new User(UUID.randomUUID().toString(),
                        userName,
                        password,
                        email);
    }

    public User updatePassword(final User old, final String password)
    {
        return new User(old.getId(),
                        old.getUserName(),
                        password,
                        old.getEmail());
    }
}
