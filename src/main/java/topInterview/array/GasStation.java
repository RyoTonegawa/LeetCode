package topInterview.array;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // initialize variables
        int totalTank = 0;
        int currentTank = 0;
        int startingStation = 0;

        // Iterate over each gas station to calcurate the total gas and determint the
        // starting startion
        for (int i = 0; i < gas.length; i++) {
            // in this for loop,calculating 'total' gas amont because
            totalTank += gas[i] - cost[i];
            // this variable trach how much gas we hace in the tank while traveling
            // If currentTank becomes negative, it means we cannnot reach the next station
            // from the current stating point
            currentTank += gas[i] - cost[i];
            if (currentTank < 0) {
                // reset the potential starting station to the next one
                startingStation = i + 1;
                // Also, reset currentTank because we need to start a new journey from the next
                // station!
                currentTank = 0;
            }
        }
        // if total tank bigger than 0, it means we can travel
        return totalTank >= 0 ? startingStation : -1;
    }
}
