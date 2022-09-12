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
public class EditSite {

    private String oName;
    private String oDescription;
    private String oNewName;
    private String oNewDescription;
    private String oActive;

    public EditSite() {
    }

    public void setEditSite(String name, String description, String newName, String newDescription, String active) {
        this.oActive = active;
        this.oDescription = description;
        this.oName = name;
        this.oNewDescription = newDescription;
        this.oNewName = newName;
    }

    public void work(Statement st, Connection con) throws SQLException {

        String sql;

        sql = "exec EdSite '" + oName + "', '" + oDescription + "', '" + oNewName + "', '" + oNewDescription + "', " + oActive + "; "
                + "select * "
                + "from Sites "
                + "where SiteName = '" + oNewName + "' and Description = '" + oNewDescription + "'";

        ResultSet rs = st.executeQuery(sql);

        int x = 0;

        while (rs.next()) {
            System.out.println("SiteName: " + rs.getString("SiteName"));
            System.out.println("Description: " + rs.getString("Description"));
            System.out.println(" ");
            x++;
        }

        if (x == 0) {
            System.out.println("There is no such site! Create one!");
            AddSite a = new AddSite();
            a.setAddSite(oName, oDescription);
            a.work(st, con);
        }
    }
}
