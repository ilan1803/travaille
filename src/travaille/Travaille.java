/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package travaille;

import java.util.Scanner;

/**
 *
 * @author cibot
 */
public class Travaille {

    /**
     * @param a
     */
    public static void main(String a[]) {

//        Scanner scc = new Scanner(System.in);
//        int x;
//        System.out.println("Do you have an acount? ");
//        x = scc.nextInt();
//        int y = 0;
//
        Connection c = new Connection();
//
//        if (x == 1) {
//            System.out.println("edit? ");
//            y = scc.nextInt();
//            String newName, newCode, newEmail, active;
//            newName = "Ilan";
//            newCode = "123";
//            newEmail = "cibot.ilan@gmail.com";
//            active = "1";
//            c.setEdit(newName, newCode, newEmail, active);
//        }
//
//        String name, code, email, pass;
//        name = "David";
//        code = "123";
//        email = "david@gmail.com";
//        pass = "david1234";
//        c.setConnection(name, code, email, pass);
//        c.connection(x, y);
        String siteName, description, newSiteName, newDescription, siteActive;
        
        siteName = "PH";
        description = "the best videos of the world";
        newSiteName="Google";
        newDescription="what dou you want?";
        siteActive="1";
        c.setEditSite(siteName, description, newSiteName, siteActive, newDescription);
//        c.setAddSite(siteName, description);
        c.connection(0, 0);
        
        
        
    }
}
