/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travaille;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author cibot
 */
public class Connection {

    private String oName;
    private String oCode;
    private String oEmail;
    private String oPass;

    private String oNewName;
    private String oNewCode;
    private String oNewEmail;
    private String oActive;

    private String oDescription;
    private String oSiteName;

    private String oNewSiteName;
    private String oNewDescription;
    private String oSiteActive;

    public Connection() {
    }

    /**
     * recois les informations pour un nouveaux site
     *
     * @param name
     * @param description
     */
    public void setAddSite(String name, String description) {
        this.oDescription = description;
        this.oSiteName = name;
    }

    /**
     * recois les information pour editer un site
     *
     * @param siteName
     * @param description
     * @param newName
     * @param active
     * @param newDescription
     */
    public void setEditSite(String siteName, String description, String newName, String active, String newDescription) {
        this.oSiteName = siteName;
        this.oDescription = description;
        this.oNewDescription = newDescription;
        this.oNewSiteName = newName;
        this.oSiteActive = active;
    }

    /**
     * recois les informations pour un nouveux utilisateur
     *
     * @param oName
     * @param oCode
     * @param oEmail
     * @param oPass
     */
    public void setConnection(String oName, String oCode, String oEmail, String oPass) {
        this.oName = oName;
        this.oEmail = oEmail;
        this.oCode = oCode;
        this.oPass = oPass;
    }

    /**
     * recois les informations pour editite un utilisateur
     *
     * @param oNewName
     * @param oNewCode
     * @param oNewEmail
     * @param oActive
     */
    public void setEdit(String oNewName, String oNewCode, String oNewEmail, String oActive) {
        this.oNewName = oNewName;
        this.oNewEmail = oNewEmail;
        this.oNewCode = oNewCode;
        this.oActive = oActive;
    }

    /**
     * fonction pricipale de la classe qui sera appeler en dehors d'elle
     *
     * @param x
     * @param y
     */
    public void connection(int x, int y) {

        try { //ouvre la connection
            String userName = "sa";
            String password = "ilan1803";

            String url = "jdbc:sqlserver://localhost:1433;databaseName=travail";
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            java.sql.Connection conn;
            conn = DriverManager.getConnection(url, userName, password);

            System.out.println("connection created");
            Statement st;
            st = conn.createStatement();

            /**
             * active toute les activite de LogIn ou de SignIn et permet de
             * modifier un User si le proprietaire le veut, tout est demander au
             * proprietaire dans la class principale et tout est verifier si il
             * peut le faire dans LogIn
             */
//            if (x == 1) {
//                LogIn l = new LogIn();
//                l.setLogIn(oName, oCode, oEmail, oPass);
//                y = l.work(st, conn);
//                if (y == 1) {
//                    EditUsers e = new EditUsers();
//                    e.setEditUser(oNewName, oNewEmail, oNewCode, oActive);
//                    e.work(st, conn, oName, oEmail);
//                }
//
//            } else {
//                SignIn s = new SignIn();
//                s.setSignIn(oName, oCode, oEmail, oPass);
//                s.work(st, conn);
//
//            }
            /**
             * active les fonctionalite du AddSite et de EditSite, recois des
             * informations de lexterieur et les envoies pour regler ce qui a
             * ete demander
             */
//            AddSite a = new AddSite();
//            a.setAddSite(oSiteName, oDescription);
//            a.work(st, conn);

            EditSite es = new EditSite();
            es.setEditSite(oSiteName, oDescription, oNewSiteName, oNewDescription, oSiteActive);
            es.work(st, conn);

            st.close(); //ferme la connection
            conn.close();

        } /* Catch Sql exception */ catch (SQLException sqle) { //attrape les erreurs
            System.out.println("Sql exception " + sqle);
        } /* Catch Class NotFound Exception */ catch (ClassNotFoundException notfe) {
            System.out.println("Class Not Found Exception " + notfe);
        } finally {
        }
    }
}
