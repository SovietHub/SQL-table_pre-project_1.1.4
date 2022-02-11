package jm.task.core.jdbc.util;

import jm.task.core.jdbc.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class Util {
    // поля для установки соединения с базой данных//
    private static final String url = "jdbc:mysql://localhost:3306/pre-project_1.1.4";
    private static final String user = "root";
    private static final String password = "soviet_union98";

    private static SessionFactory sessionFactory;

    public static SessionFactory getConnection() {

        //-------Создание конфигурации Hibernate-------//

            try {
                Configuration configuration = new Configuration();

                Properties properties = new Properties();
                properties.put(Environment.DRIVER, "com.mysql.cj.jdbc.Driver"); // инициализатор драйвера
                properties.put(Environment.URL, url);
                properties.put(Environment.USER, user);
                properties.put(Environment.PASS, password);
                properties.put(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");

                configuration.setProperties(properties);
                configuration.addAnnotatedClass(User.class);

                ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                        .applySettings(configuration.getProperties()).build();
                sessionFactory = configuration.buildSessionFactory(serviceRegistry);

            } catch (Exception exception) {
                exception.printStackTrace();
                System.out.println("Неудалось установить соединение с БД");
            }
            // реализуйте настройку соеденения с БД
        return sessionFactory;


    }


}