package dev.gutierrez.daos.appuser;

import dev.gutierrez.entities.Entities.AppUser;

public interface AppUserDAO {

    AppUser getUserByUserName(String username);
}
