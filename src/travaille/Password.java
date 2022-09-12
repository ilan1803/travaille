/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travaille;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author cibot
 */
public class Password {

    public Password(Statement st, Connection conn, String pass) throws SQLException {

        String sql;
        LocalDateTime dt = LocalDateTime.now();
        String dateTime = dt.toString();
        dateTime = dateTime.replace("T", " ");

        pass = hiding(pass);

        sql = "exec Pass '" + pass + "', '" + dateTime + "' ;";

        st.executeQuery(sql);

        System.out.println("New Password Affected");

        st.close();
        conn.close();

    }

    public static String hiding(String pass) {
        int x = pass.length() - 1;
        char[] arr = pass.toCharArray();
        while (x >= 0) {
            arr[x] = (char) (arr[x] + 10);
            x--;
        }
        pass = Arrays.toString(arr);
        return pass;
    }
}
