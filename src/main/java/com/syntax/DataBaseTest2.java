package com.syntax;

import java.sql.*;

public class DataBaseTest2 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";

        try {

            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            ResultSet resultset = statement.executeQuery("select firstname, lastname, age, city " +
                    "from person where city is not null;");

            // ResultSetMetaData - object that contains info about the result table
            // info such as column names, number of columns

            ResultSetMetaData metaData = resultset.getMetaData();

            //metaData.getColumnCount();
            //metaData.getColumnName();

            for (int i=1; i<=metaData.getColumnCount(); i++) {
                //looping through each column and getting column name
                String columnName = metaData.getColumnName(i);
                System.out.println(columnName);
            }

            // to loop through every row and every column

            while (resultset.next()) {
                for ( int i=1; i<=metaData.getColumnCount(); i++) {
                    String value = resultset.getString(metaData.getColumnName(i));
                    System.out.print(value + " ");
                }
                System.out.println();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
