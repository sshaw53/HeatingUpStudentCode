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
        int longestSpan = 0;

        // Go through every temperature
        for (int i = 0; i < tempLen; i++) {
            int currentTemp = temperatures[i];
            int mostDays = 0;

            // For every value up to that temperature, check to find the longest length of days that stems from
            // the current temperature we're at (must be below current temperature to add another step)
            for (int j = 0; j < i; j++) {
                if (temperatures[j] < currentTemp && days[j] > mostDays) {
                    mostDays = days[j];
                }
            }

            // Adding one to the largest "streak"
            days[i] = mostDays + 1;

            // Check as you go to find the max number of days
            if (days[i] > longestSpan) {
                longestSpan = days[i];
            }
        }

        return longestSpan;
    }

    /* NEW ATTEMPT
    public static int longestWarmingTrend(int[] temperatures) {
        int tempLen = temperatures.length;
        int[] days = new int[tempLen];
        int longestSpan = 0;

        Dictionary dict = new Dictionary(temperatures, tempLen);
        ArrayList<int[]> sorted = dict.getDictionary();

        // Go through every temperature
        for (int i = 0; i < tempLen; i++) {
            int currentTemp = temperatures[i];
            int mostDays = 0;

            // For every value up to that temperature, check to find the longest length of days that stems from
            // the current temperature we're at (must be below current temperature to add another step)
            for (int j = 0; j < sorted.size(); j++) {
                int[] look = sorted.get(j);
                if (look[0] < currentTemp && look[1] < i && days[j] > mostDays) {
                    mostDays = days[j];
                }
                if (look[0] > currentTemp) {
                    break;
                }
            }

            // Adding one to the largest "streak"
            days[i] = mostDays + 1;

            // Check as you go to find the max number of days
            if (days[i] > longestSpan) {
                longestSpan = days[i];
            }
        }

        return longestSpan;
    }
*/
}