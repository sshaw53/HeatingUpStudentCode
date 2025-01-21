import java.util.ArrayList;

/**
 * The class WeatherPatterns finds the longest span of days in which
 * each day’s temperature is higher than on the previous day in that sequence.
 *
 * @author Zach Blick
 * @author SIERRA SHAW
 */

public class WeatherPatterns {

    /**
     * Longest Warming Trend
     * @param temperatures
     * @return the longest run of days with increasing temperatures
     */

    public static int longestWarmingTrend(int[] temperatures) {
        int tempLen = temperatures.length;
        int[] days = new int[tempLen];
        // Build the Adjacency List
        ArrayList<Integer>[] adjList = new ArrayList[tempLen];
        // For each node, create a list of nodes that lead to it
        for (int i = 0; i < tempLen; i++) {
            for (int j = i; j < tempLen; j++) {
                if (temperatures[j] > temperatures[i]) {
                    adjList[j].add(i);
                }
            }
        }

        for (int i = 0; i < tempLen; i++) {
            int idk = longestPathTo(i, days, adjList);
        }

        int longestSpan = 0;

        // Go through every temperature
        for (int i = 0; i < tempLen; i++) {
            // Check as you go to find the max number of days
            if (days[i] > longestSpan) {
                longestSpan = days[i];
            }
        }

        return longestSpan;
    }

    // Recursive call function
    public static int longestPathTo(int vertex, int[] days, ArrayList<Integer>[] adjList) {
        int len = 0;
        int toLook = adjList[vertex].size();

        for (int i = 0; i < toLook; i++) {
            // Before recursing, check to see if we have been to that node already & if so, use its saved value
            if (days[adjList[vertex].get(i)] != 0) {
                len = days[adjList[vertex].get(vertex)];
            }

            // During recursive step: If we've never been there, recurse. When done, add its new value to array.
            else {
                len = Math.max(len, longestPathTo(adjList[vertex].get(i), days, adjList));
            }
            days[days[adjList[vertex].get(i)]] = 1 + len;
        }
        return 1 + len;
    }
}