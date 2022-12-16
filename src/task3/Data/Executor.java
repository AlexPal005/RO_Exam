package task3.Data;

import Train.Train;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface Executor extends Remote {
    List<Train> getListTrainDestination(String city) throws RemoteException;
    List<Train> getListTrainDestinationAfterTime(String city, double time) throws RemoteException;
    List<Train> getListTrainDestinationHavePlaces(String city) throws RemoteException;
}
