public class GastroDiseaseDetector implements PatternDetector{
    String sequence = "";

    /**
     * detects seqeunce of G, followed by 1 or more T and followed by G.
     */


    @Override
    public int detect(GenomeAnalyzer analyzer) {
        int gIndex = analyzer.findSimpleSequence("GT");
        if (gIndex != -1) {
            sequence += "GT";
            if (gIndex + 2 < analyzer.buffer.length()) {
                int index = gIndex + 2;
                while (index < analyzer.buffer.length()) {
                    if (analyzer.buffer.charAt(index) == 'T') {
                        index++;
                        sequence += Character.toString(analyzer.buffer.charAt(index));
                    } else {
                        break;
                    }
                }
                if (index < analyzer.buffer.length() && analyzer.buffer.charAt(index) == 'G') {
                    return gIndex;
                }
            }
            sequence = "No matching sequence found";
            return -1;
        }
        sequence = "No matching sequence found";
        return -1;
    }


    @Override
    public String labelString() {
        return "GastroDiseaseDetector, detects if there is a sequence that starts with G," +
                " by one or more Ts, followed by another G";
    }

    @Override
    public String additionalInfo() {
        return "The matching sequence: " + sequence;
    }
}


