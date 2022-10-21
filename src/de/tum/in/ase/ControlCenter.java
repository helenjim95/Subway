package de.tum.in.ase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ControlCenter {
    /**
     * This class represents the control center which is responsible for running our simulation.
     */
    private Depot depotFroettmannig;
    private List<Station> stations;
    private List<Train> trains;

    private int steps;

    /**
     * This constructor initializes a simplified version of the U6 and adds the given trains to the depot.
     * @param trains A list of trains
     */
    public ControlCenter(List<Train> trains) {
        depotFroettmannig = new Depot();
        this.trains = trains;
        this.trains.stream().forEach(t -> depotFroettmannig.addTrain(t));

        setUpStations();
    }

    /**
     * This constructor initializes a simplified version of the U6 with an empty depot.
     */
    public ControlCenter() {
        depotFroettmannig = new Depot();
        trains = new ArrayList<>();
        for (int i = 0; i<10; i++) {
            Train train = new Train(0.5f);
            trains.add(train);
            depotFroettmannig.addTrain(train);
        }

        setUpStations();
    }

    private void setUpStations() {
        Station garching = new Station("Garching Forschungszentrum", null, null);
        Station kieferngarten = new Station("Kieferngarten", garching, null);
        garching.setNextStationToGrosshadern(kieferngarten);
        Station studentenstadt = new Station("Studentenstadt", kieferngarten, null);
        kieferngarten.setNextStationToGrosshadern(studentenstadt);
        Station freiheit = new Station("Münchner Freiheit", studentenstadt, null);
        studentenstadt.setNextStationToGrosshadern(freiheit);
        Station marienplatz = new Station("Marienplatz", freiheit, null);
        freiheit.setNextStationToGrosshadern(marienplatz);
        Station westpark = new Station("Westpark", marienplatz, null);
        marienplatz.setNextStationToGrosshadern(westpark);
        Station grosshadern = new Station("Klinikum Großhadern", westpark, null);
        westpark.setNextStationToGrosshadern(grosshadern);

        stations = Arrays.asList(garching, kieferngarten, studentenstadt, freiheit, marienplatz, westpark, grosshadern);
    }

    /**
     * Simulates a day of subway traffic by first taking on train after another from the depot, calling dispatch() on
     * all stations multiple times and returning the trains to the depot.
     */
    public void simulateDay() {
        for (int i = 0; i < 48; i++) {
            if (!depotFroettmannig.isEmpty()) {
                Train train = depotFroettmannig.getNextTrain();
                stations.get(1).addTrainToGrosshadern(train);
            }
            callDispatch();
            System.out.print(i+": ");
            printCurrentState();
        }
        steps = 48;
        while (depotFroettmannig.numberOfTrains()<10) {
            System.out.print(steps + ": ");
            printCurrentState();
            steps++;
            Train train = stations.get(1).removeTrainToGrosshadern();
            if (train!=null) {
                depotFroettmannig.addTrain(train);
            }
            callDispatch();
        }
    }

    private void callDispatch() {
        List<Station> nonEmptyStationsToGarching = stations.stream().filter(s -> !s.getToGarching().isEmpty()).toList();
        List<Station> nonEmptyStationsToGrosshadern = stations.stream().filter(s -> !s.getToGrosshadern().isEmpty()).toList();
        stations.forEach(s -> {
            if (nonEmptyStationsToGarching.contains(s)) {
                s.dispatchTrainsToGarching();
            }
            if (nonEmptyStationsToGrosshadern.contains(s)) {
                s.dispatchTrainsToGrosshadern();
            }
        });
    }

    private void printCurrentState() {
        stations.forEach(s -> {
            System.out.print(s.getToGrosshadern().size() + "/" + s.getToGarching().size() + " ");;
        });
        System.out.println(" ");
    }

    /**
     * Prints some info about the simulated day.
     */
    public void evaluateDay() {
        int drove = 0;
        for (int i = 0; i<trains.size(); i++) {
            drove += trains.get(i).getHistory().stream().filter(b -> b).toList().size();
        }
        System.out.println("All train actions: " + (steps*10) + ", waited: " + ((steps*10)-drove) + ", driven: " + drove);
        System.out.println("A train passed on average " + (drove/10) + " stations.");
        System.out.println("A train waited on average " + ((480-drove)/10) + " times.");
    }

    public static void main(String[] args) {
        ControlCenter cs = new ControlCenter();
        cs.simulateDay();
        cs.evaluateDay();
    }
}
