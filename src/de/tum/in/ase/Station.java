package de.tum.in.ase;

import java.util.ArrayList;
import java.util.List;

public class Station {
    /**
     * This class represents the train stations that make up the connection from Garching to Grosshadern.
     */

    // Done: Add private attributes as seen in the UML diagram on Artemis.
    private String name;
    private List<Train> toGarching;
    private List<Train> toGrosshadern;

    private Station nextStationToGarching;
    private Station nextStationToGrosshadern;
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
        // Done: Initialize your attributes. Don't forget to initialize the waiting lists.
        this.name = name;
        this.nextStationToGrosshadern = nextDirectionGrosshadern;
        this.nextStationToGarching = nextDirectionGarching;
        this.toGarching = new ArrayList<>();
        this.toGrosshadern = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setToGarching(List<Train> toGarching) {
        this.toGarching = toGarching;
    }

    public void setToGrosshadern(List<Train> toGrosshadern) {
        this.toGrosshadern = toGrosshadern;
    }

    public Station getNextStationToGarching() {
        return nextStationToGarching;
    }

    public Station getNextStationToGrosshadern() {
        return nextStationToGrosshadern;
    }

    public void setNextStationToGrosshadern(Station nextStationToGrosshadern) {
        // Done: Implement this setter.
        this.name = TERMINAL_STATION2;
    }

    public void setNextStationToGarching(Station nextStationToGarching) {
        // Done: Implement this setter.
        this.name = TERMINAL_STATION1;
    }


    public List<Train> getToGrosshadern() {
        // Done: Implement this getter.
        return toGrosshadern;
    }

    public List<Train> getToGarching() {
        // Done: Implement this setter.
        return toGarching;
    }


    /**
     * This method adds a train to the waiting list in direction Grosshadern
     * @param train The train to be added
     */
    public void addTrainToGrosshadern(Train train) {
        // Done: Implement this method. The method description above tells you what the method should do.
        toGrosshadern.add(train);
    }

    /**
     * This method adds a train to the waiting list in direction Garching
     * @param train The train to be added
     */
    public void addTrainToGarching(Train train) {
        // Done: Implement this method. The method description above tells you what the method should do.
        toGarching.add(train);
    }

    /**
     * This method dispatches the trains that entered the current station on their way to Garching and sends them
     * to the next station on the way to Garching.
     */
    public void dispatchTrainsToGarching() {
        // Done: Implement this method. It dispatched one train in direction Garching.
        //  Remember that there might be no train waiting to be dispatched and that terminal station behave different.
        //  The train can only be dispatched if it is working, make sure to check for that by calling drive()
        if (!toGarching.isEmpty()) {
            Train train = toGarching.get(0);
            boolean isWorking = train.drive();
            if (isWorking) {
                removeTrainToGarching();
            }
            if (name.equals(TERMINAL_STATION1)) {
                addTrainToGrosshadern(train);
            } else {
                addTrainToGarching(train);
            }
        }
    }

    /**
     * This method dispatches the trains that entered the current station on their way to Grosshadern and sends them
     * to the next station on the way to Grosshadern.
     */
    public void dispatchTrainsToGrosshadern() {
        // Done: Implement this method. It dispatched one train in direction Grosshadern.
        //  Remember that there might be no train waiting to be dispatched and that terminal station behave different.
        //  The train can only be dispatched if it is working, make sure to check for that by calling drive()
        if (!toGrosshadern.isEmpty()) {
            Train train = toGrosshadern.get(0);
            boolean isWorking = train.drive();
            if (isWorking) {
                removeTrainToGrosshadern();
            }
            if (name.equals(TERMINAL_STATION2)) {
                addTrainToGarching(train);
            } else {
                addTrainToGrosshadern(train);
            }
        }
    }

    /**
     * This method removes one train from the waiting list in direction Grosshadern
     * @return null if no train in direction Grosshadern is currently waiting and the train otherwise
     */
    public Train removeTrainToGrosshadern() {
        // Done: Implement this method. The method description above tells you what the method should do.
        if (toGrosshadern.isEmpty()) {
            return null;
        } else {
            return toGrosshadern.remove(0);
        }
    }

    /**
     * This method removes one train from the waiting list in direction Garching
     * @return null if no train in direction Garching is currently waiting and the train otherwise
     */
    public Train removeTrainToGarching() {
        // Done: Implement this method. The method description above tells you what the method should do.
        if (toGarching.isEmpty()) {
            return null;
        } else {
            return toGarching.remove(0);
        }
    }

    /**
     * This method returns how many trains are waiting to be dispatched in direction Garching
     * @return the number of waiting trains
     */
    public int getLengthOfWaitingListToGarching() {
        // TODO Implement this method. The method description above tells you what the method should do.
        return toGarching.size();
    }

    /**
     * This method returns how many trains are waiting to be dispatched in direction Grosshadern
     * @return the number of waiting trains
     */
    public int getLengthOfWaitingListToGrosshadern() {
        // TODO Implement this method. The method description above tells you what the method should do.
        return toGrosshadern.size();
    }

}
