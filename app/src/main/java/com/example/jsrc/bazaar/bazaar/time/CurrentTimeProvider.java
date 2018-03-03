package com.example.jsrc.bazaar.bazaar.time;

import java.util.Date;

public class CurrentTimeProvider
{
    private volatile long _currentDate = new Date().getTime();

    public CurrentTimeProvider()
    {

    }

    public long getTime()
    {
        return _currentDate;
    }

}
