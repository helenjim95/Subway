package de.tum.in.ase;

import java.util.List;

public class Station {
    /**
     * This class represents the train stations that make up the connection from Garching to Grosshadern.
     */

    // TODO Add private attributes as seen in the UML diagram on Artemis.
    //  Remember to add getters and setters for all of them.


    // TODO use these two constants to check if current station is a terminal station in dispatch methods
    private static final String TERMINAL_STATION1 = "Garching-Forschungszentrum";
    private static final String TERMINAL_STATION2 = "Klinikum Grosshadern";

    /**
     * This constructor sets up a new Station.
     *
     * @param name                     The name of the Station, e.g. "Garching Forschungszentrum"
     * @param nextDirectionGarching    The next station when driving in the direction of Garching Forschungszentrum
     * @param nextDirectionGrosshadern The next station when driving in the direction of Klinikum Grosshadern
     */
    public Station(String name, Station nextDirectionGarching, Station nextDirectionGrosshadern) {
        // TODO Initialize your attributes. Don't forget to initialize the waiting lists.
    }

    /**
     * This method adds a train to the waiting list in direction Grosshadern
     * @param train The train to be added
     */
    public void addTrainToGrosshadern(Train train) {
        // TODO Implement this method. The method description above tells you what the method should do.

    }

    /**
     * This method adds a train to the waiting list in direction Garching
     * @param train The train to be added
     */
    public void addTrainToGarching(Train train) {
        // TODO Implement this method. The method description above tells you what the method should do.

    }

    /**
     * This method dispatches the trains that entered the current station on their way to Garching and sends them
     * to the next station on the way to Garching.
     */
    public void dispatchTrainsToGarching() {
        // TODO Implement this method. It dispatched one train in direction Garching.
        //  Remember that there might be no train waiting to be dispatched and that terminal station behave different.
        //  The train can only be dispatched if it is working, make sure to check for that by calling drive()
    }

    /**
     * This method dispatches the trains that entered the current station on their way to Grosshadern and sends them
     * to the next station on the way to Grosshadern.
     */
    public void dispatchTrainsToGrosshadern() {
        // TODO Implement this method. It dispatched one train in direction Grosshadern.
        //  Remember that there might be no train waiting to be dispatched and that terminal station behave different.
        //  The train can only be dispatched if it is working, make sure to check for that by calling drive()
    }

    /**
     * This method removes one train from the waiting list in direction Grosshadern
     * @return null if no train in direction Grosshadern is currently waiting and the train otherwise
     */
    public Train removeTrainToGrosshadern() {
        // TODO Implement this method. The method description above tells you what the method should do.
        return null;
    }

    /**
     * This method removes one train from the waiting list in direction Garching
     * @return null if no train in direction Garching is currently waiting and the train otherwise
     */
    public Train removeTrainToGarching() {
        // TODO Implement this method. The method description above tells you what the method should do.
        return null;
    }

    /**
     * This method returns how many trains are waiting to be dispatched in direction Garching
     * @return the number of waiting trains
     */
    public int getLengthOfWaitingListToGarching() {
        // TODO Implement this method. The method description above tells you what the method should do.
        return 0;
    }

    /**
     * This method returns how many trains are waiting to be dispatched in direction Grosshadern
     * @return the number of waiting trains
     */
    public int getLengthOfWaitingListToGrosshadern() {
        // TODO Implement this method. The method description above tells you what the method should do.
        return 0;
    }

    public void setNextStationToGrosshadern(Station nextStationToGrosshadern) {
        // TODO Implement this setter.
    }

    public List<Train> getToGrosshadern() {
        // TODO Implement this getter.
        return null;
    }

    public List<Train> getToGarching() {
        // TODO Implement this setter.
        return null;
    }

    // TODO Implement the remaining getters and setters for all attributes
}