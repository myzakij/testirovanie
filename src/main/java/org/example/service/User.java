package org.example.service;

import org.example.database.Database;
import org.example.utils.Validation;
import java.sql.SQLException;

public class User {
    private static Database database;

    static {
        database = Database.getObjectDatabaseControl();
    }

    public static Boolean registration(String login, String password) {
        if (Validation.checkLogin(login) && Validation.checkPassword(password)) {
            org.example.entity.User user = new org.example.entity.User(login, password);
            try {
                return database.addUser(user);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        } else {
            return false;
        }
    }

    public static Boolean login(String login, String password) {
        if (Validation.checkLogin(login) && Validation.checkPassword(password)) {
            org.example.entity.User user = null;
            try {
                user = database.getUserByLogin(login);
                if (user == null)
                    return false;
                if (user.getPassword().equals(password) && !user.getOnline()) {
                    return database.userLogin(user);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }

    public static Boolean logout(String login) {
        if (Validation.checkLogin(login)) {
            org.example.entity.User user = null;
            try {
                user = database.getUserByLogin(login);
                if (user == null)
                    return false;
                if (user.getOnline()) {
                    return database.userLogout(user);
                }
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return false;
    }
}
