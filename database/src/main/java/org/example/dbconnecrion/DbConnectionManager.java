package org.example.dbconnecrion;

import java.lang.reflect.Proxy;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingDeque;

public class DbConnectionManager {

    private static final String URL = DbPropertiesLoader.get("url");
    private static final String USERNAME = DbPropertiesLoader.get("username");
    private static final String PASSWORD = DbPropertiesLoader.get("password");

    private static final int DEFAULT_POOL_SIZE = 10;
    private static ArrayBlockingQueue<Connection> pool;

    static {
        loadDriver();
        initConnectionPool();

    }

    private static void loadDriver() {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void initConnectionPool() {
        int poolSize = DEFAULT_POOL_SIZE;
        if (DbPropertiesLoader.get("poolsize") != null) {
            poolSize = Integer.parseInt(DbPropertiesLoader.get("poolsize"));
        }
        pool = new ArrayBlockingQueue<Connection>(poolSize);

        for (int i = 0; i < poolSize; i++) {
            Connection connection = open();
            pool.add((Connection) Proxy.newProxyInstance(DbConnectionManager.class.getClassLoader(),
                    new Class[]{Connection.class},
                    ((proxy, method, args) -> method.getName().equals("close")
                            ? pool.add((Connection) proxy) : method.invoke(connection, args))));
        }
    }


    public static Connection get() {
        try {
            return pool.take();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


    private static Connection open() {
        try {
            return DriverManager.getConnection(URL, USERNAME, PASSWORD);
        } catch (SQLException e) {
            System.out.println("Ошибка подключения к бд");
            throw new RuntimeException(e) {
            };
        }
    }

    private DbConnectionManager() {
    }
}
