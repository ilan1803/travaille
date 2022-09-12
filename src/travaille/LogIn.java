/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travaille;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import static travaille.Password.hiding;

/**
 *
 * @author cibot
 */
public class LogIn {

    LogIn() {
        new TryLogIn();
    }

    private String oName;
    private String oCode;
    private String oEmail;
    private String oPass;

    public void setLogIn(String oName, String oCode, String oEmail, String oPass) {
        this.oName = oName;
        this.oEmail = oEmail;
        this.oCode = oCode;
        this.oPass = oPass;
    }

    public int work(Statement st, Connection conn) throws SQLException {

        int x = 0;
        String sql;

        sql = "select * "
                + "from Users "
                + "where UserName = '" + oName + "' "
                + "and Email = '" + oEmail + "'";

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            rs.getString("UserName");
            rs.getString("Email");
            x++;
        }

        if (x == 0) {
            System.out.println("you don't have an acount! SignIn!");
            SignIn s = new SignIn();
            s.setSignIn(oName, oCode, oEmail, oPass);
            s.work(st, conn);
            return 0;
        } else {
            oPass = hiding(oPass);
            sql = "select * "
                    + "from Passwords "
                    + "INNER JOIN Users "
                    + "ON Passwords.UserID = Users.ID "
                    + "where Password = '" + oPass + "'";

            rs = st.executeQuery(sql);

            int y = 0;

            while (rs.next()) {
                rs.getString("Password");
                y++;
            }

            if (y == 0) {
                System.out.println("wrong password");
                return 0;
            } else {
                sql = "select * "
                        + "from Users "
                        + "where UserName = '" + oName + "'"
                        + "and Email = '" + oEmail + "'";
                rs = st.executeQuery(sql);
                while (rs.next()) {
                    System.out.println("");
                    System.out.println("Name:" + rs.getString("UserName"));
                    System.out.println("Email:" + rs.getString("Email"));
                    System.out.println("Country Code:" + rs.getString("CountryCode"));
                }
            }
        }
        return 1;
    }
}
