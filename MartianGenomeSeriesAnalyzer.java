import java.util.ArrayList;

/**
 * pass patern detector to determine type and index
 * uses both positive and negative test files.
 */

public class MartianGenomeSeriesAnalyzer extends GenomeAnalyzer {
    ArrayList<PatternDetector> detectors;

    public MartianGenomeSeriesAnalyzer(String filename) {
        super(filename);
        detectors = new ArrayList<PatternDetector>();
    }

    void addDetector(PatternDetector patternDetector) {
        detectors.add(patternDetector);
    }

    void runAll() {
        for (PatternDetector d : detectors) {
            System.out.println("Pattern type: " + d.labelString());
            System.out.println("Pattern index: " + d.detect(this));
            System.out.println(d.additionalInfo() + "\n");
        }



    }
    public static void main(String args[]){
        MartianGenomeSeriesAnalyzer seriesAnalyzer = new MartianGenomeSeriesAnalyzer("test.txt");
        seriesAnalyzer.addDetector(new GeniusDetector());
        seriesAnalyzer.addDetector(new GastroDiseaseDetector());
        seriesAnalyzer.addDetector(new RepeaterDetector());

        seriesAnalyzer.runAll();

    }
}
