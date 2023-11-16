/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package red;

import java.sql.Connection;
import java.sql.SQLException;
import org.apache.commons.dbcp2.BasicDataSource;

/**
 *
 * @author Universidad
 */
public class BaseDeDatos {
    
        private static BasicDataSource bs = new BasicDataSource();
    private static BaseDeDatos instance;
    private final static String URL = "jdbc:mysql://54.147.25.136:3306/1152273?useSSL=false&useTimezone=true&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    /*http://54.147.25.136/phpMyAdmin/index.php?route=/&route=%2F&db=1152273&table=Destino*/
    private final static String USERNAME = "test";
    private final static String PASSWORD = "test1_*";

    private BaseDeDatos() {
        bs.setUrl(URL);
        bs.setUsername(USERNAME);
        bs.setPassword(PASSWORD);
        bs.setMinIdle(5);
        bs.setMaxIdle(10);
        bs.setMaxOpenPreparedStatements(100);
    }

    public static synchronized BaseDeDatos getInstace() {
        if (instance == null) {
            instance = new BaseDeDatos();
        }
        return instance;
    }
    
    public Connection getConection () throws SQLException {
        return bs.getConnection();
    }
}
