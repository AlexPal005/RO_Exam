package Train;

import java.io.Serializable;

public class Train implements Serializable {
    private int number;
    private String destination;
    private double departureTime;
    private int numberGeneral;
    private int numberCompartment;
    private int numberPlaceCard;
    private int numberLuxe;

    public Train(int number, String destination, double departureTime, int numberGeneral,
                 int numberCompartment, int numberPlaceCard, int numberLuxe){

        this.number = number;
        this.destination = destination;
        this.departureTime = departureTime;
        this.numberGeneral = numberGeneral;
        this.numberCompartment = numberCompartment;
        this.numberPlaceCard = numberPlaceCard;
        this.numberLuxe = numberLuxe;
    }

    public String getDestination() {
        return destination;
    }

    public double getDepartureTime() {
        return departureTime;
    }

    public int getNumberGeneral() {
        return numberGeneral;
    }

    @Override
    public String toString() {
        return  "Number:  " + number + "\n" +
                "Destination:   " + destination + "\n" +
                "Time:   " + departureTime + "\n" +
                "Number general seats: " + numberGeneral + "\n"+
                "Number compartment: " + numberCompartment + "\n" +
                "Number PlaceCard: " + numberPlaceCard + "\n" +
                "Number luxe: " + numberLuxe;
    }
}
