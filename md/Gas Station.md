## [Gas Station](https://leetcode.com/problems/gas-station/)

### Problem

There are N gas stations along a circular route, where the amount of gas at station i is `gas[i]`.

You have a car with an unlimited gas tank and it costs `cost[i]` of gas to travel from station i to its next station (i+1). You begin the journey with an empty tank at one of the gas stations.

Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.

__Note__:

The solution is guaranteed to be unique.

### Solution


### Code

``` Java
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        if (gas == null || gas.length == 0) {
            return -1;
        }
        int numStations = gas.length;
        int tank = 0;
        int start = 0;
        for (int i = 0; i < 2 * numStations - 1; i++) {
            int pos = i % numStations;
            tank += gas[pos] - cost[pos];
            if (tank < 0) {
                start = i + 1;
                if (start >= numStations) {
                    return -1;
                }
                tank = 0;
            }
        }
        return start;
    }
}
```

### Refinement
