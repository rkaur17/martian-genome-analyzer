import java.util.ArrayList;

/**
 * detects specfic sequence GAGA
 * and returns first index of found sequence.
 */

public class GeniusDetector implements PatternDetector {

    String genius = "The matching sequence was not found";
    GenomeAnalyzer g;

    @Override
    public int detect(GenomeAnalyzer analyzer) {
        g = analyzer;
        int g = analyzer.findSimpleSequence("GAGA");
        if (g != -1) {
            genius = "GAGA";
        }
        return g;
    }

    public ArrayList<Integer> detect() {
        ArrayList<Integer> indexes = new ArrayList<>();
        return indexes;
    }

    @Override
    public String labelString() {
        return "GeniusDetector, a detector that detects if the sequence has the string GAGA";
    }

    @Override
    public String additionalInfo() {
        return "The sequence: " + genius;
    }
}

