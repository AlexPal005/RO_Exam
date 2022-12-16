package task3.Data;

import Train.Train;
import task3.Data.Executor;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ExecutorImpl extends UnicastRemoteObject implements Executor {
    private List<Train> listTrain;

    public ExecutorImpl(List<Train> listTrain) throws Exception{
        this.listTrain = listTrain;
    }
    public List<Train> getListTrainDestination(String city){
        List<Train> res = new ArrayList<>();
        for (Train train: listTrain) {
            if(train.getDestination().equals(city)){
                res.add(train);
            }
        }
        return res;
    }
    public List<Train> getListTrainDestinationAfterTime(String city, double time){
        List<Train> res = new ArrayList<>();
        for (Train train: listTrain) {
            if(train.getDestination().equals(city) && train.getDepartureTime() >= time){
                res.add(train);
            }
        }
        return res;
    }
    public List<Train> getListTrainDestinationHavePlaces(String city){
        List<Train> res = new ArrayList<>();
        for (Train train: listTrain) {
            if(train.getDestination().equals(city) && train.getNumberGeneral() > 0){
                res.add(train);
            }
        }
        return res;
    }
}
