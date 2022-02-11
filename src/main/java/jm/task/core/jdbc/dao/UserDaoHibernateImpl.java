package jm.task.core.jdbc.dao;

import jm.task.core.jdbc.model.User;
import jm.task.core.jdbc.util.Util;
import org.hibernate.*;
import org.hibernate.query.Query;

import java.util.List;

// 1)UserHibernateDaoImpl должен реализовывать интерефейс UserDao
// 2)В класс Util должна быть добавлена конфигурация для Hibernate ( рядом с JDBC), без использования xml.
// 3)Service на этот раз использует реализацию dao через Hibernate
// 4)Методы создания и удаления таблицы пользователей в классе UserHibernateDaoImpl
// должны быть реализованы с помощью SQL

public class UserDaoHibernateImpl implements UserDao {
    private static final SessionFactory sessionFactory = Util.getConnection();

    public UserDaoHibernateImpl() {
    }

    @Override
    public void createUsersTable() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("CREATE TABLE IF NOT EXISTS `Persons` (\n"
                + " `id` INT NOT NULL AUTO_INCREMENT,\n"
                + " `name` VARCHAR(50) NOT NULL,\n"
                + " `lastName` VARCHAR(50) NOT NULL,\n"
                + " `age` INT NOT NULL,\n"
                + " PRIMARY KEY (`id`),\n"
                + " UNIQUE INDEX `id_UNIQUE` (`id` ASC) VISIBLE);").executeUpdate();
        transaction.commit();
        session.close();
        System.out.println("Таблица успешно создана!");
    } // done and works

    @Override
    public void dropUsersTable() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("DROP TABLE IF EXISTS `Persons`").executeUpdate();
        System.out.println("Таблица удалена!");
        transaction.commit();
        session.close();
    } // done and works

    @Override
    public void saveUser(String name, String lastName, byte age) {
        try {
            User user = new User(name, lastName, age);
            Session session = sessionFactory.openSession();
            Transaction transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
            session.close();
            System.out.println(new StringBuilder().append("User с именем – ").append(name).append(" добавлен в базу данных"));
        } catch (HibernateException exception) {
            exception.printStackTrace();
        }

    }// done and works

    @Override
    public void removeUserById(long id) {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        User myObject = session.load(User.class, id);
        session.delete(myObject);
        transaction.commit();
        session.close();
    } // done and works

    @Override
    public List<User> getAllUsers() {
        Session session = sessionFactory.openSession();
        return session.createQuery("SELECT a FROM User a", User.class).getResultList();
    } // done and works

    @Override
    public void cleanUsersTable() {
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        session.createSQLQuery("delete from Persons").executeUpdate();
        transaction.commit();
    } //done and works
}
