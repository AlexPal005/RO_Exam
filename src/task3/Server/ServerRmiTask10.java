package task3.Server;

import Train.Train;
import task3.Data.ExecutorImpl;

import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class ServerRmiTask10 {
    public static void main(String[] args) throws Exception {
        List<Train> listTrain = new ArrayList<>();
        Train train1 = new Train(1,"Київ",
                19.30, 20, 10,20, 20);
        Train train2 = new Train(2, "Харків", 12.3, 60,
                5,20,15);
        Train train3 = new Train(3, "Львів", 21.00, 40,
                5,20,5);
        listTrain.add(train1);
        listTrain.add(train2);
        listTrain.add(train3);
        ExecutorImpl executor = new ExecutorImpl(listTrain);
        Registry registry = LocateRegistry.createRegistry(123);
        registry.rebind("Calc", (Remote) executor);
    }
}
