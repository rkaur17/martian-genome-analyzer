public interface PatternDetector {

    int detect(GenomeAnalyzer analyzer);

    String labelString();

    default String additionalInfo() {
        return "";
    }
}