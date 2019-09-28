/*
 * SE1011 - 011
 * Winter 2015
 * Lab 9 - Parking Lot
 * Name: Donal Moloney
 * Created: 2/7/2017
 */
package Moloneyda;
import java.util.Arrays;
/*
   This public class tracks data from the parking lot for the district
 */

public class District {
    public static final int MAX_LOTS = 20;
    private ParkingLot lot1;
    private ParkingLot lot2;
    private ParkingLot lot3;
    private int sumTimeClosed;
    private int numLots;

    private ParkingLot[] lots = new ParkingLot[MAX_LOTS];

    public District() {
    }


    public String toString() {
        String status = "District status:\n";
        if (numLots > 0) {
            for (int i = 0; i < numLots; i++) {
                status += lots[i].toString() + "\n";
            }
        }
            return status;
    }



    /**
     * Record a vehicle entering a given lot at a given time.
     *
     * @param lotNumber Number of lot, 1-3
     * @param time      Entry time in minutes since all lots were opened.
     *                  This calls ParkingLot.markVehicleEntry for the lot corresponding
     *                  to lotNumber (1 -> lot1, 2 -> lot2, 3 -> lot3).
     *                  If lotNumber is out of range, the behavior is unspecified.
     */
    public void markVehicleEntry(int lotNumber, int time) {
        //convert to work with array
        if (0 <= lotNumber && lotNumber < numLots) {
            lots[lotNumber].markVehicleEntry(time);

        } else {
            System.out.println(" The range is unspecified");
        }
    }

    /**
     * Record a vehicle exiting a given lot at a given time.
     *
     * @param lotNumber Number of lot, 1-3
     * @param time      Entry time in minutes since all lots were opened.
     *                  This calls ParkingLot.markVehicleExit for the lot corresponding
     *                  to lotNumber (1 -> lot1, 2 -> lot2, 3 -> lot3).
     *                  If lotNumber is out of range, the behavior is unspecified.
     */
    public void markVehicleExit(int lotNumber, int time) {
        //convert to work in an array
        lots[lotNumber].markVehicleExit(time);


    }

    /**
     * Checks the status of all three lots in the district and
     * returns true if they are all closed and false otherwise.
     *
     * @return whether all lots are closed in the district
     */
    public boolean isClosed() {
        boolean closed = true;
        for (int g = 0; g < numLots; g++) {
            if (!lots[g].isClosed()) {
                closed = false;
            }
        }return closed;
    }


    /**
     * Computes the time all lots were reported as closed.
     *
     * @return number of minutes all three lots were closed
     */
    public int closedMinutes() {
        for(int k = 0; k < numLots; k++){
            sumTimeClosed += lots[k].closedMinutes();
        }
        return sumTimeClosed;
    }

    public int add(String color, int capacity) {
        int index = numLots;
        lots[index] = new ParkingLot(color, capacity);
        numLots++;
        return index;
    }

    public ParkingLot getLot(int index){
        return lots[index];
    }

    public int vehiclesParkedInDistrict(){
        int total = 0;
        int currentVehicles = 0;
        for(int i = 0; i < numLots; i++){
            total += lots[i].vehiclesInLot();
        }
        {
            return  currentVehicles + total;
        }
    }
}
