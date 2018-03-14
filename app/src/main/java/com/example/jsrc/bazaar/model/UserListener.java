package com.example.jsrc.bazaar.model;

public interface UserListener
{
    void UserAdded(User user);
    void UserUpdated(User user);
    void UserRemoved(User user);
}
