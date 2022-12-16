package task3.Client;

import task3.Data.Executor;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

public class ClientRmiTask10 {

    public static void main(String[] args) throws MalformedURLException, NotBoundException, RemoteException {
        String url = "rmi://localhost:123/Calc";
        Executor executor= (Executor) Naming.lookup(url);
        Menu menu = new Menu(executor);
        menu.createMenu();
    }
}
