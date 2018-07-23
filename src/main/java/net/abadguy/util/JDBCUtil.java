package net.abadguy.util;

import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

/**
 * JDBC工具类
 *1）获取Connection
 * 2）释放资源
 */
public class JDBCUtil {

    /**
     * 获取COnnection
     * @return
     */
    public static Connection getConnection() throws Exception {
//        String classDriver="com.mysql.jdbc.Driver";
//        String url="jdbc:mysql://118.24.166.176:3306/spring_data";
//        String user="root";
//        String password="root";

        InputStream inputStream=JDBCUtil.class.getClassLoader().getResourceAsStream("db.properties");
        Properties properties=new Properties();
        properties.load(inputStream);
        String classDriver=properties.getProperty("jdbc.classDriver");
        String url=properties.getProperty("jdbc.url");
        String user=properties.getProperty("jdbc.user");
        String password=properties.getProperty("jdbc.password");


        Class.forName(classDriver);
        return DriverManager.getConnection(url,user,password);
    }

    /**
     * 释放资源
     * @param resultSet
     * @param statement
     * @param connection
     * @throws SQLException
     */
    public static void relese(ResultSet resultSet, Statement statement,Connection connection) throws SQLException {
        if (resultSet!=null){
            resultSet.close();
        }
        if (statement!=null){
            statement.close();
        }
        if (connection!=null){
            connection.close();
        }
    }
}
