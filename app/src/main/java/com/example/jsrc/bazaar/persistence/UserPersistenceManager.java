package com.example.jsrc.bazaar.persistence;

import com.example.jsrc.bazaar.model.User;
import com.example.jsrc.bazaar.model.Users;
import com.example.jsrc.bazaar.util.CRCFileUtilAccesor;
import com.example.jsrc.bazaar.util.SuffixFileFilter;

import java.io.File;
import java.util.List;

public class UserPersistenceManager
{
    private final Users _users;
    private final ObjectMarshaller<User> _objectMarshaller;
    private final PersistenceLoader<User> _userLoader;
    private final File _userDir;
    private final CRCFileUtilAccesor _crcFileUtilAccessor;
    private final SuffixFileFilter _suffixFileFilter;

    public UserPersistenceManager(final Users users,
                                  final ObjectMarshaller<User> objectMarshaller,
                                  final PersistenceLoader<User> usersLoader,
                                  final File userDir,
                                  final CRCFileUtilAccesor crcFileUtilAccesor,
                                  final SuffixFileFilter suffixFileFilter)
    {

        _users = users;
        _objectMarshaller = objectMarshaller;
        _userLoader = usersLoader;
        _userDir = userDir;
        _crcFileUtilAccessor = crcFileUtilAccesor;
        _suffixFileFilter = suffixFileFilter;
    }

    public void startUserModelPersistance()
    {
        final UserPersister userPersister = new UserPersister(_objectMarshaller, _userDir, _crcFileUtilAccessor);
        _users.addUserListener(userPersister);

        if(_userDir.exists())
        {
            final List<User> loadedUsers = _userLoader.loadObjects(_userDir, _suffixFileFilter);

            if(loadedUsers != null && !loadedUsers.isEmpty())
                _users.putAll(loadedUsers);
        }
        else
        {
            if (!_userDir.mkdir())
                System.out.print("Failed to create Users directory: " + _userDir);
        }

    }
}
