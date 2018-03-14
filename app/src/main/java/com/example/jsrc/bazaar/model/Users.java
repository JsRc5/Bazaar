package com.example.jsrc.bazaar.model;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

public class Users
{
    private final Map<String, User> _idToUserMap = new HashMap<>();
    private final Set<UserListener> _listeners = new CopyOnWriteArraySet<>();

    public User getById(final String id)
    {
        return _idToUserMap.get(id);
    }

    public int getSize()
    {
        return _idToUserMap.size();
    }

    public void put (final User user)
    {
        final User previousValue = _idToUserMap.put(user.getId(), user);

        if (previousValue == null)
            fireUserAdded(user);
        else
            fireUserUpdated(user);
    }

    public void remove(final String id)
    {
        final User user = _idToUserMap.remove(id);
    }

    public void putAll(final Iterable<User> users)
    {
        for (final User user: users)
            put(user);
    }

    public void clear()
    {
        for (final Iterator<Map.Entry<String, User>> iterator = _idToUserMap.entrySet().iterator(); iterator.hasNext();)
        {
            final Map.Entry<String, User> entry = iterator.next();
            iterator.remove();
            fireUserRemoved(entry.getValue());
        }
    }

    public boolean contains(final String id)
    {
        return _idToUserMap.containsKey(id);
    }

    private void fireUserAdded(final User user)
    {
        for (final UserListener listener: _listeners)
            listener.UserAdded(user);
    }

    private void fireUserUpdated(final User user)
    {
        for (final UserListener listener: _listeners)
            listener.UserUpdated(user);
    }

    private void fireUserRemoved(final User user)
    {
        for (final UserListener listener: _listeners)
            listener.UserRemoved(user);
    }

    public void addUserListener(final UserListener listener)
    {
        _listeners.add(listener);
    }
}
