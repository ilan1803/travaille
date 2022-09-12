/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travaille;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 *
 * @author cibot
 */
public class AddSite {

    private String oDescription;
    private String oName;

    public void setAddSite(String name, String description) {
        this.oDescription = description;
        this.oName = name;
    }

    public AddSite() {
    }

    public void work(Statement st, Connection conn) throws SQLException {

        String sql;

        sql = "exec ConsSite '" + oName + "', '" + oDescription + "' ;"
                + "select * "
                + "from Sites "
                + "where SiteName = '" + oName + "' and Description = '" + oDescription + "'";

        ResultSet rs = st.executeQuery(sql);

        while (rs.next()) {
            System.out.println("SiteName: " + rs.getString("SiteName"));
            System.out.println("Description: " + rs.getString("Description"));
            System.out.println(" ");
        }
    }
}
