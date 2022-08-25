package dev.gutierrez.daotests;

import dev.gutierrez.daos.appuser.AppUserDAO;
import dev.gutierrez.daos.appuser.AppUserDAOPostgres;
import dev.gutierrez.entities.Entities.AppUser;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class appuserTest {

    static AppUserDAO appUserDAO = new AppUserDAOPostgres();

        @Test
        void get_User_By_UserName() {
            AppUser appUser = appUserDAO.getUserByUserName("albertog");
            System.out.println(appUser);
            Assertions.assertEquals("Alberto", appUser.getFname());
        }
    }

