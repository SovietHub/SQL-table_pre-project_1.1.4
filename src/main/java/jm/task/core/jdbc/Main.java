package jm.task.core.jdbc;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.service.UserService;
import jm.task.core.jdbc.util.service.UserServiceImpl;

public class Main {
    private static final UserService userService = new UserServiceImpl(); // new static поля для работы в main c не static
    private static final User firstPerson = new User("Иван", "Петров", (byte) 18);
    private static final User secondPerson = new User("Павел", "Корчагин", (byte) 30);
    private static final User thirdPerson = new User("Юрий", "Гагарин", (byte) 27);
    private static final User fourthPerson = new User("Павлик", "Морозов", (byte) 13);

    public static void main(String[] args) {
        //Методы создания и удаления таблицы пользователей в классе UserHibernateDaoImpl
        // должны быть реализованы с помощью SQL.

        userService.createUsersTable();// создаю таблицу
        userService.dropUsersTable(); // удаление таблицы
        userService.getAllUsers();
        userService.cleanUsersTable();

        //---Занесение в таблицу людей---//
        userService.saveUser(firstPerson.getName(), firstPerson.getLastName(), firstPerson.getAge());
        userService.saveUser(secondPerson.getName(), secondPerson.getLastName(), secondPerson.getAge());
        userService.saveUser(thirdPerson.getName(), thirdPerson.getLastName(), thirdPerson.getAge());
        userService.saveUser(fourthPerson.getName(), fourthPerson.getLastName(), fourthPerson.getAge());
    }
}

