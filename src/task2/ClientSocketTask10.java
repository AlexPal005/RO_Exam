package task2;

import Train.Train;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

public class ClientSocketTask10 {
    private Socket socket;

    public static void main(String[] args) {
        ClientSocketTask10 client = new ClientSocketTask10();
        client.menu();

    }

    private void menu() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("--------Меню-----------");
            System.out.println("1. Список поездов, следующих до заданного пункта назначения");
            System.out.println("2. Список поездов, следующих до заданного пункта назначения и отправ-\n" +
                    "ляющихся после заданного часа;");
            System.out.println("3. Cписок поездов, отправляющихся до заданного пункта назначения\n" +
                    "и имеющих общие места.");
            System.out.println("Номер меню: ");

            ObjectInputStream inputStream;
            PrintWriter out;
            try{
                socket = new Socket("localhost", 12345);
                inputStream = new ObjectInputStream(socket.getInputStream());
                out = new PrintWriter(socket.getOutputStream(), true);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

            int numberMenu = scanner.nextInt();
            scanner.nextLine();
            if(numberMenu == 1 || numberMenu == 3) {
                System.out.println("Уведіть назву міста: ");
                String city = scanner.nextLine();
                out.println(numberMenu + "#" + city);
            }
            else{
                System.out.println("Уведіть назву міста: ");
                String city = scanner.nextLine();
                System.out.println("Уведіть час: ");
                Scanner newScanner = new Scanner(System.in);
                double time = newScanner.nextDouble();
                out.println(numberMenu + "#" + city + "#" + time);
            }

            try {
                SerializableList list = (SerializableList) inputStream.readObject();
                List<Train> result = list.getList();
                if(result != null) {
                    for (Train train : result) {
                        System.out.println(train);
                        System.out.println();
                    }
                }
                else{
                    System.out.println("Помилка або нічого не знайдено!");
                }
            } catch (IOException | ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
