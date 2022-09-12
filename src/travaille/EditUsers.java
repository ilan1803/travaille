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
public class EditUsers {

    private String oNewName;
    private String oNewEmail;
    private String oNewCode;
    private String oActive;

    public void setEditUser(String oNewName, String oNewEmail, String oNewCode, String oActive) {
        this.oNewCode = oNewCode;
        this.oActive = oActive;
        this.oNewEmail = oNewEmail;
        this.oNewName = oNewName;
    }

    public EditUsers() {
    }

    public void work(Statement st, Connection conn, String name, String email) throws SQLException {

        String sql;

        sql = "exec EdUsers '" + name + "', '" + email + "', '" + oNewName + "', '" + oNewEmail + "', '" + oNewCode + "', " + oActive + ";"
                + "select * "
                + "from Users "
                + "where UserName = '" + oNewName + "' and Email = '" + oNewEmail + "'";

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.println("Name: " + rs.getString("UserName"));
            System.out.println("Email: " + rs.getString("Email"));
            System.out.println("CountryCode: " + rs.getString("CountryCode"));
            System.out.println(" ");
        }
    }
}
