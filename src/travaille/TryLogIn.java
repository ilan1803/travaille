/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package travaille;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;

/**
 *
 * @author cibot
 */
public class TryLogIn {

    public TryLogIn() {
        InetAddress ip;
        try {
            ip = InetAddress.getLocalHost();
            String x = ip.getHostAddress();
            System.out.println("Current IP address : " + x);
            NetworkInterface network = NetworkInterface.getByInetAddress(ip);
            byte[] mac = network.getHardwareAddress();
            System.out.print("Current MAC address : ");
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < mac.length; i++) {
                sb.append(String.format("%02X%s", mac[i], (i < mac.length - 1) ? "-" : ""));
            }
            String y = sb.toString();
            System.out.println(y);
        } catch (UnknownHostException e) {

            e.printStackTrace();
        } catch (SocketException e) {
            e.printStackTrace();
        }
        //LocalDateTime dateTime = LocalDateTime.now();
        //System.out.println(dateTime);
    }
}
