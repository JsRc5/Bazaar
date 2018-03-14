package com.example.jsrc.bazaar.persistence;


import android.provider.Settings;
import android.renderscript.ScriptIntrinsicYuvToRGB;

import com.example.jsrc.bazaar.model.User;
import com.example.jsrc.bazaar.model.UserListener;
import com.example.jsrc.bazaar.util.CRCFileUtilAccesor;

import java.io.File;

public class UserPersister implements UserListener
{
    private final ObjectMarshaller<User> _marshaller;
    private final File _directory;
    private final CRCFileUtilAccesor _crcFileUtilAccesor;


    public UserPersister(final ObjectMarshaller<User> marshaller, final File directory, final CRCFileUtilAccesor crcFileUtilAccesor)
    {
        _marshaller = marshaller;
        _directory = directory;
        _crcFileUtilAccesor = crcFileUtilAccesor;
    }


    @Override
    public void UserAdded(User user)
    {
        try
        {
            _marshaller.save(getFile(user), user);
        }
        catch (final Exception e)
        {
            System.out.print("Failed to save user : " + user + e );
        }
    }

    @Override
    public void UserUpdated(User user)
    {
        UserRemoved(user);
        UserAdded(user);
    }

    @Override
    public void UserRemoved(User user)
    {
        final File userFile = getFile(user);
        final boolean suceeded = userFile.delete();

        if (suceeded)
        {
            _crcFileUtilAccesor.getCRCFile(userFile).delete();
            System.out.print(suceeded + "Failed to delete user file:" + user);
        }
    }


    private File getFile(User user)
    {
        if (!_directory.exists() && !_directory.mkdir())
            System.out.print("Failed to create user directory: " + _directory) ;

        return new File(_directory, user.getId().replaceAll("[a-zA-Z0-9-]", "") + ".xml");
    }
}