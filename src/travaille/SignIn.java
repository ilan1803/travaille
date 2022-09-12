/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travaille;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author cibot
 */
public class SignIn {

    private String oName;
    private String oCode;
    private String oEmail;
    private String oPass;

    SignIn() {
    }

    public void setSignIn(String oName, String oCode, String oEmail, String oPass) {
        this.oName = oName;
        this.oEmail = oEmail;
        this.oCode = oCode;
        this.oPass = oPass;
    }

    public void work(Statement st, Connection conn) throws SQLException {

        String sql;

        sql = "exec AddUsers '" + oName + "', '" + oEmail + "', '" + oCode + "' ;"
                + "select * "
                + "from Users "
                + "where UserName = '" + oName + "' and Email = '" + oEmail + "'";

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.println("Name: " + rs.getString("UserName"));
            System.out.println("Email: " + rs.getString("Email"));
            System.out.println("CountryCode: " + rs.getString("CountryCode"));
            System.out.println(" ");
        }

        new Password(st, conn, oPass);

    }
}
