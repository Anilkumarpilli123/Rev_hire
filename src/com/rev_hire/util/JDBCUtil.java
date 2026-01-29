package com.rev_hire.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;
import java.io.InputStream;

public class JDBCUtil {

    private static String url;
    private static String username;
    private static String password;

    static {
        try {
            Properties props = new Properties();

            InputStream is = JDBCUtil.class
                    .getClassLoader()
                    .getResourceAsStream("db.properties");

            if (is == null) {
                throw new RuntimeException("db.properties file not found");
            }

            props.load(is);

            url = props.getProperty("jdbc:oracle:thin:@db.freesql.com:1521/23ai_34ui2");
            username = props.getProperty("UDAYKIRAN6522_SCHEMA_Z1K61");
            password = props.getProperty("71AZL53!YMHJOC3XE0uVRZRWFDV93E");

            Class.forName("oracle.jdbc.driver.OracleDriver");

        } catch (Exception e) {
            throw new RuntimeException("Failed to initialize JDBC", e);
        }
    }

    private JDBCUtil() {}

    public static Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:oracle:thin:@db.freesql.com:1521/23ai_34ui2", "UDAYKIRAN6522_SCHEMA_Z1K61", "71AZL53!YMHJOC3XE0uVRZRWFDV93E");
        } catch (Exception e) {
            throw new RuntimeException("Database connection failed", e);
        }
    }
}
