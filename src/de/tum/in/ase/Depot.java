package de.tum.in.ase;

import java.util.List;

public class Depot {
    /**
     * This class represents the depot that is used to store trains that are currently not in use.
     */

    // TODO Add the attribute trains as seen in the UML diagram

    /**
     * This constructor creates an empty depot.
     */
    public Depot() {
        // TODO Initialize the variable trains with an empty list

    }

    /**
     * This constructor creates a depot that already contains trains.
     * @param trains The trains that are already in the depot.
     */
    public Depot(List<Train> trains) {
        // TODO Initialize the variable trains with the given list

    }

    /**
     * This method checks if the depot is empty.
     * @return True if there are no trains in the depot.
     */
    public boolean isEmpty() {
        // TODO Implement this method. The method description above tells you what the method should do.
        return true;
    }

    /**
     * This method returns the number of trains in the depot.
     * @return The number of trains in the depot
     */
    public int numberOfTrains() {
        // TODO Implement this method. The method description above tells you what the method should do.
        return 0;
    }

    /**
     * This method removes the last train added to the depot and returns it.
     * @return The last train added
     */
    public Train getNextTrain() {
        // TODO Implement this method. The method description above tells you what the method should do.
        return null;
    }

    /**
     * This method adds a new Train to the depot.
     * @param The train that will be added to the depot
     */
    public void addTrain(Train train) {
        // TODO Implement this method. The method description above tells you what the method should do.

    }
}
