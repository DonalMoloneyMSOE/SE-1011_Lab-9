# SE-1011_Lab-9


Overview

For this lab, you will revise your Lab 8 solution by introducing arrays of ParkingLots in the District class.
Assignment

The previous version of the District class you delivered was limited to districts with three parking lots. This is an artificial limit, and you have been contracted to revise the code to support up to twenty parking lots per district. You are to replace the lot1, lot2, and lot instance variables in District by an array, lots[], of ParkingLot items. The array is to support up to 20 parking lots. You will introduce a variable numLots to track the number of parking lots currently in use. In addition, you will make a small modification to ParkingLot as described below.

It may be helpful to set up your project before reading through the changes. For detailed instructions see below, but the basic steps are to copy your project folder to a new location (perhaps named lab9) and replace your existing ParkingDriver.java by the new version.

The following diagram shows the revised API that you are to implement. Detail on each change is given below.

Changes to ParkingLot

You will need to make just one change to ParkingLot: add a toString method. This method is to return a string of the form "Status for [color] parking lot: [x] vehicles ([p])" where [color] is filled in by the color, [x] by the number of vehicles currently in the lot, and [p] by the percentage full. As before, the percentage full is formatted with at most one digit after the decimal and "FULL" if the percentage is at or above FULL_THRESHOLD. The DecimalFormat #.# can be used to format the numerical percentage.

Having toString is good practice because it allows the client code to print other places besides System.out. You can remove displayStatus if you like, or you can just leave it.
Changes to District

Most of the changes are to District, but you might notice that the parameters and return types for existing methods do not change. The following sequence diagram illustrates how the example from Lab 8 works with the new API.

More specifically, make the following changes to District. Note that you will also need to update the documentation. Whether you do this as you go or later is up to you, but doing it as you go can be easier.

    Delete the old District constructor.
    Declare a constant (a public static final value) called MAX_LOTS. Set it to 20.
    Replace the declaration for lot1, lot2, and lot3 by

            private ParkingLot[] lots = new ParkingLot[MAX_LOTS];
          

    Add an instance variable numLots to track the number of lots actually in use.
    Add a method add (see the class diagram) with the following code:

            int newIndex   = numLots;
            lots[newIndex] = new ParkingLot(color, capacity);
            numLots++;
            return newIndex;
          

    Add a method getLot which returns the ParkingLot at the given index. Note that lot numbers now start at 0. A precondition for this method is that the lot index is valid.
    Rewrite markVehicleEntry and markVehicleExit so they use getLot to retrieve the parking lot.
    Add a method vehiclesParkedInDistrict based on the pseudocode

            total = 0
            for each value of i between 0 and numLots-1
               add number of vehicles in lot i to total
            return total
          

    Rewrite isFull using the pseudocode

            i = 0
            while i < numLots and lot i is full
               add 1 to i
            return true if all lots are full (i = numLots), false otherwise
          

    Rewrite displayStatus as toString. The value returned by toString will be a string with newline characters embedded in it. For example, toString could return a string such as

    District status:
    Status for purple parking lot: 8 vehicles (FULL)
    Status for gold parking lot: 20 vehicles (33.3%)
          

    This code will look similar to vehiclesParkedInDistrict except that you will call ParkingLot.toString for each line, appending "\n" for the newlines. There should be a newline at the end of each line including the last.

Testing and Sample Output

As before, ParkingDriver exercises most of your code. The output is given below, but remember that having slightly different numbers may be ok and that matching our output does not automatically mean your solution is correct.

Tiny District status:
Status for red parking lot: 0 vehicles (0%)
Status for green parking lot: 0 vehicles (0%)
Status for blue parking lot: 0 vehicles (0%)
Final TinyDistrict status:
Status for red parking lot: 1 vehicles (FULL)
Status for green parking lot: 0 vehicles (0%)
Status for blue parking lot: 2 vehicles (FULL)
Lots were full for 3 min. in tiny district.

Testing ParkingLot
Final status: Status for test parking lot: 0 vehicles (0%)

Airport at time 7:
District status:
Status for brown parking lot: 7 vehicles (70%)
Status for green parking lot: 14 vehicles (FULL)
Status for black parking lot: 7 vehicles (58.3%)

Airport at time 8:
District status:
Status for brown parking lot: 8 vehicles (FULL)
Status for green parking lot: 14 vehicles (FULL)
Status for black parking lot: 7 vehicles (58.3%)

Airport at time 10:
District status:
Status for brown parking lot: 8 vehicles (FULL)
Status for green parking lot: 14 vehicles (FULL)
Status for black parking lot: 10 vehicles (FULL)

Testing heavier usage.
At end of day, all lots full 42 min.
Final District status:
Status for pink parking lot: 17 vehicles (68%)
Status for blue parking lot: 28 vehicles (FULL)
Status for gray parking lot: 2 vehicles (20%)

All tests finished.

Detailed Start

A detailed list of steps to set up your project for Lab 9 for those who would like more explicit instructions.

    Make sure your solution is working for Lab 8, especially the ParkingLot class.
    Open Windows File Explorer (see here if you're not sure how) and navigate to the lab8 folder containing your previous solution.
    Right click on the lab8 folder and select Copy.
    Right click on the open space below the folder and select Paste. This will create a fresh copy of the project as "lab8 - Copy".
    Right click on "lab8 - Copy", select Rename, and enter lab9.
    In Windows File Explorer, browse to lab9\src\parking.
    Download ParkingDriver.java and replace the old version of ParkingDriver by the new one.
    Start IntelliJ and open the lab9 project.
    In IntelliJ, confirm that the new ParkingDriver has syntax errors. If it doesn't, that means you're still using the old version - you'll need to fix that before going on. Ask for help if you need it!

When you are done, go back to the top to see what to change.
Lab Deliverables
See your professor's instructions for details on submission guidelines and due dates.
Dr. Hasker's submission instructions
Dr. Taylor's class: See below
See Dr. Thomas for instructions
See Prof. Ung for instructions
Dr. Yoder's submission instructions
If you have any questions, consult your instructor.
Acknowledgement

This laboratory assignment was developed by Dr. Rob Hasker.
