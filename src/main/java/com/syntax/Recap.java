package com.syntax;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Recap {

    public static void main(String[] args) {

        String url = "jdbc:mysql://3.239.253.255:3306/syntaxhrm_mysql";
        String username = "syntax_hrm";
        String password = "syntaxhrm123";

        try {
            Connection cn = DriverManager.getConnection(url, username, password);

            Statement st = cn.createStatement();

            String query = "select * from person order by FirstName;";

            ResultSet rst = st.executeQuery(query);

            ResultSetMetaData rsmdata = rst.getMetaData();

            List<Map<String, String>> listFromRset = new ArrayList<>();

            while (rst.next()) {

                Map<String, String> map = new LinkedHashMap<>();

                for (int i = 1; i <= rsmdata.getColumnCount(); i++) {

                    String key = rsmdata.getColumnName(i);
                    String value = rst.getString(key);
                    map.put(key, value);
                }
                System.out.println(map);
                listFromRset.add(map);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
