package task2;


import Train.Train;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerSocketTask10 {
    private ServerSocket server;
    private BufferedReader in;
    private static List<Train> listTrain;
    private ObjectOutputStream outputStream;
    private Socket socket;
    public static void main(String[] args){
        ServerSocketTask10 serverMain = new ServerSocketTask10();
        listTrain = new ArrayList<>();
        Train train1 = new Train(1,"Київ",
                19.30, 20, 10,20, 20);
        Train train2 = new Train(2, "Харків", 12.3, 60,
                5,20,15);
        Train train3 = new Train(3, "Львів", 21.00, 40,
                5,20,5);
        listTrain.add(train1);
        listTrain.add(train2);
        listTrain.add(train3);
        serverMain.start();

    }
    private void start(){
        try {
            server = new ServerSocket(12345);
            while(true) {
                System.out.println("Waiting for a client ...");
                socket = server.accept();
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                outputStream = new ObjectOutputStream(socket.getOutputStream());
                new Thread(()->{
                    try {
                        String query = in.readLine();
                        if (query == null) outputStream.writeObject(null);

                        String[] fields = query.split("#");

                        if (fields.length == 0) {
                            outputStream.writeObject(null);
                        } else {
                            int number_menu = Integer.parseInt(fields[0]);
                            switch (number_menu) {
                                case (1) -> outputStream.writeObject(getListTrainDestination(fields[1]));
                                case (2) -> outputStream.writeObject(getListTrainDestinationAfterTime(fields[1], Double.parseDouble(fields[2])));
                                case (3) -> outputStream.writeObject(getListTrainDestinationHavePlaces(fields[1]));
                            }
                        }
                    }catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }).start();
                System.out.println("Client connected");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private SerializableList getListTrainDestination(String city){
        List<Train> res = new ArrayList<>();
        for (Train train: listTrain) {
            if(train.getDestination().equals(city)){
                res.add(train);
            }
        }
        SerializableList list = new SerializableList(res);
        return list;
    }
    private SerializableList getListTrainDestinationAfterTime(String city, double time){
        List<Train> res = new ArrayList<>();
        for (Train train: listTrain) {
            if(train.getDestination().equals(city) && train.getDepartureTime() >= time){
                res.add(train);
            }
        }
        SerializableList list = new SerializableList(res);
        return list;
    }
    private SerializableList getListTrainDestinationHavePlaces(String city){
        List<Train> res = new ArrayList<>();
        for (Train train: listTrain) {
            if(train.getDestination().equals(city) && train.getNumberGeneral() > 0){
                res.add(train);
            }
        }
        SerializableList list = new SerializableList(res);
        return list;
    }
}
