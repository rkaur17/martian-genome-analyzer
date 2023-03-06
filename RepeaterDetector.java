import java.util.ArrayList;

/**
 * detects when there is sequence of same letter repeated 5 times.
 * uses findsimplesequence.
 */

public class RepeaterDetector implements PatternDetector{
    public String letter = "";
    ArrayList<Integer> indexes = new ArrayList<>();

    @Override
    public int detect(GenomeAnalyzer analyzer) {
        int smallest = 1000000;
        int G = analyzer.findSimpleSequence("GGGGG");
        if (G != -1) {
            indexes.add(G);
            if (G < smallest) {
                smallest = G;
            }
        }
        int A = analyzer.findSimpleSequence("AAAAA");
        if (A != -1) {
            indexes.add(A);
            if (A < smallest) {
                smallest = A;
            }
        }
        int T = analyzer.findSimpleSequence("TTTTT");
        if (T != -1) {
            indexes.add(T);
            if (T < smallest) {
                smallest = T;
            }
        }
        int C = analyzer.findSimpleSequence("CCCCC");
        if (C != -1) {
            indexes.add(C);
            if (C < smallest) {
                smallest = C;
            }
        }
        if (smallest < analyzer.buffer.length()) {
            int index = smallest;
            while (index < analyzer.buffer.length()
                    && analyzer.buffer.charAt(index) ==
                    analyzer.buffer.charAt(smallest)) {
                letter += (Character.toString(analyzer.buffer.charAt(index)));
                index++;
            }
            detect();
            return smallest;
        } else {
            detect();
            letter = "No repeated sequence was found";
            return -1;
        }
    }

    ArrayList<Integer> detect() {
        if (indexes.size() > 0) {
            System.out.println("(Extra credit) List of starting indexes for all matches found: " + indexes);
            return indexes;
        }
        System.out.println("(Extra credit) List of starting indexes for all matches found: null");
        return indexes;
    }



    @Override
    public String labelString() {
        return "RepeaterDetector, detects whether an any letter is repeated 5 times, and returns the earliest pattern occurrence found";
    }

    @Override
    public String additionalInfo() {
        return "The matching letter string: " + letter;
    }
}
