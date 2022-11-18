package de.tum.in.ase;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("JavadocReference")
public class Depot {
    /**
     * This class represents the depot that is used to store trains that are currently not in use.
     */

    // Done: Add the attribute trains as seen in the UML diagram
    private List<Train> trains;

    /**
     * This constructor creates an empty depot.
     */

    public Depot() {
        // Done: Initialize the variable trains with an empty list
        this.trains = new ArrayList<>();
    }

    /**
     * This constructor creates a depot that already contains trains.
     * @param trains The trains that are already in the depot.
     */
    public Depot(List<Train> trains) {
        // Done: Initialize the variable trains with the given list
        this.trains = trains;
    }

    public List<Train> getTrains() {
        return trains;
    }

    public void setTrains(List<Train> trains) {
        this.trains = trains;
    }

    /**
     * This method checks if the depot is empty.
     * @return True if there are no trains in the depot.
     */
    public boolean isEmpty() {
        // Done: Implement this method. The method description above tells you what the method should do.
        return trains.size() == 0;
    }

    /**
     * This method returns the number of trains in the depot.
     * @return The number of trains in the depot
     */
    public int numberOfTrains() {
        // Done: Implement this method. The method description above tells you what the method should do.
        return trains.size();
    }

    /**
     * This method removes the last train added to the depot and returns it.
     * @return The last train added
     */
    public Train getNextTrain() {
        // Done: Implement this method. The method description above tells you what the method should do.
        return trains.remove(trains.size() - 1);
    }

    /**
     * This method adds a new Train to the depot.
     * @param The train that will be added to the depot
     */
    public void addTrain(Train train) {
        // Done: Implement this method. The method description above tells you what the method should do.
        trains.add(train);
    }
}
