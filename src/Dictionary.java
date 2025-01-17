import java.util.ArrayList;

public class Dictionary {
    private ArrayList<int[]> dictionary;

    public Dictionary (int[] temperatures, int tempLen) {
        dictionary = new ArrayList<int[]>();

        // [temp, idx]
        for (int i = 0; i < tempLen; i++) {
            int currentTemp = temperatures[i];
            int j = 0;

            while (dictionary.get(j)[0] < currentTemp) {
                j += 1;
            }
            int[] toAdd = new int[2];
            toAdd[0] = currentTemp;
            toAdd[1] = i;
            dictionary.add(j, toAdd);
        }
    }

    public ArrayList<int[]> getDictionary() {
        return dictionary;
    }

}
