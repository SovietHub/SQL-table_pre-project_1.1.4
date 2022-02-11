package jm.task.core.jdbc.dao;

import com.mysql.cj.conf.ConnectionPropertiesTransform;
import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;

import javax.swing.plaf.nimbus.State;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoJDBCImpl implements UserDao {
    //Класс dao должен иметь конструктор пустой/по умолчанию
    public UserDaoJDBCImpl() {
    }

    public void createUsersTable() { // Создание таблицы для User(ов) – не должно приводить к исключению, если такая таблица уже существует
    }

    public void dropUsersTable() { // Удаление таблицы User(ов) – не должно приводить к исключению, если таблицы не существует
    }

    public void saveUser(String name, String lastName, byte age) { // Добавление User в таблицу
    } // done and works

    public void removeUserById(long id) { // Удаление User из таблицы ( по id )
    } // done and works

    public List<User> getAllUsers() { //  Получение всех User(ов) из таблицы
        return null;
    } // done and works

    public void cleanUsersTable() { // Очистка содержания таблицы
    } // done and works with (Truncated incorrect DOUBLE value: '?')
}


