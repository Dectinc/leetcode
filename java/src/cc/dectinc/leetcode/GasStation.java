/**
 * 
 */

package cc.dectinc.leetcode;

/**
 * @author chenshijiang
 * @date Apr 13, 2015 2:54:17 PM
 * 
 */
public class GasStation {
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

	public int canCompleteCircuitNaive(int[] gas, int[] cost) {
		if (gas == null || gas.length == 0) {
			return -1;
		}
		int numStations = gas.length;
		int[] residual = new int[numStations];

		// calculate residual if start at Station 0
		for (int i = 0; i < numStations; i++) {
			residual[i] = gas[i] - cost[i];
		}

		// Roll start station
		int start = 0;
		while (start < numStations) {
			int tank = residual[start];
			int i = start;
			while (tank >= 0 && i < numStations) {
				tank += residual[i % numStations];
				i++;
			}
			if (i == numStations) {
				return start;
			}
			start++;
		}
		return -1;
	}

	public static void main(String[] args) {
		GasStation sol = new GasStation();
		int[] gas = new int[] { 2, 4 };
		int[] cost = new int[] { 3, 4 };
		// int[] gas = new int[] { 0, 5 };
		// int[] cost = new int[] { 2, 3 };
		System.out.println(sol.canCompleteCircuit(gas, cost));
	}

}
