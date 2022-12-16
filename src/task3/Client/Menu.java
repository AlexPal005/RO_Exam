package task3.Client;

import Train.Train;
import task3.Data.Executor;

import java.rmi.RemoteException;
import java.util.List;
import java.util.Scanner;

public class Menu {
    private Executor executor;

    public Menu(Executor executor) {
        this.executor = executor;
    }

    public void createMenu() throws RemoteException {
        while (true) {
            System.out.println("--------Меню-----------");
            System.out.println("1. Список поездов, следующих до заданного пункта назначения");
            System.out.println("2. Список поездов, следующих до заданного пункта назначения и отправ-\n" +
                    "ляющихся после заданного часа;");
            System.out.println("3. Cписок поездов, отправляющихся до заданного пункта назначения\n" +
                    "и имеющих общие места.");
            System.out.println("Номер меню: ");
            Scanner scanner = new Scanner(System.in);
            int numberMenu = scanner.nextInt();
            scanner.nextLine();
            if (numberMenu <= 0 && numberMenu > 3) {
                System.out.println("Уведіть номер меню!");
            } else {
                List<Train> listRes = null;
                System.out.println("Уведіть місто: ");
                String city = scanner.nextLine();
                switch (numberMenu) {
                    case (1) -> {
                        listRes = executor.getListTrainDestination(city);
                    }
                    case (2) -> {
                        System.out.println("Уведіть час: ");
                        double time = scanner.nextDouble();
                        scanner.nextLine();
                        listRes = executor.getListTrainDestinationAfterTime(city, time);
                    }
                    case (3) -> {
                        listRes = executor.getListTrainDestinationHavePlaces(city);
                    }
                }
                print(listRes);
            }
        }
    }

    private void print(List<Train> list) {
        if (list == null) {
            System.out.println("Нічого не знайдено!");
        } else {
            for (Train train : list) {
                System.out.println(train);
                System.out.println();
            }
        }
    }
}
