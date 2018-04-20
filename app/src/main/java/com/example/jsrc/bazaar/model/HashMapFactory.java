package com.example.jsrc.bazaar.model;

import java.util.HashMap;
import java.util.Hashtable;

public class HashMapFactory
{
    private HashMap<Enum, Boolean> _preferencesHash;

    public HashMapFactory()
    {
        createPreferencesHash();
        initialisePreferencesHash();
    }

    private void createPreferencesHash()
    {
        _preferencesHash = new HashMap<>();
    }

    private void initialisePreferencesHash()
    {
        _preferencesHash.put(Preferences.ArtsAndCrafts, false);
        _preferencesHash.put(Preferences.Books, false);
        _preferencesHash.put(Preferences.Electronics, false);
        _preferencesHash.put(Preferences.Bikes, false);
        _preferencesHash.put(Preferences.Misc, false);
        _preferencesHash.put(Preferences.Home, false);
        _preferencesHash.put(Preferences.Clothing, false);
    }

    public HashMap getPreferenceHash()
    {
        return _preferencesHash;
    }
}

