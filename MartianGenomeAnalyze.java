public class MartianGenomeAnalyze extends GenomeAnalyzer {
    /**
     * just get the input.
     *
     * @param fileName
     */
    public MartianGenomeAnalyze(String fileName) {
        super(fileName);
    }

    int detectGenius() {
        return super.findSimpleSequence("GAGA");
    }

    int detectRepeater(String letter) { //determine repeated sequence
        String repeat = letter.concat(letter).concat(letter).concat(letter).concat(letter);
        return super.findSimpleSequence(repeat);
    }


    int detectGastroDisease() {
        //GTTTG
        int gIndex = findSimpleSequence("GT");
        if (gIndex != -1) {
            if (gIndex + 2 < buffer.length()) {
                int index = gIndex + 2;
                while (index < buffer.length()) {
                    if (buffer.charAt(index) == 'T') {
                        index++;
                    } else {
                        break;
                    }
                }
                if (index < buffer.length() && buffer.charAt(index) == 'G') {
                    return gIndex;
                }
            }

            return -1;
        }
        return -1;
    }

    public static void main(String args[]) {
        MartianGenomeAnalyze gSequencer = new MartianGenomeAnalyze("test.txt");

        System.out.println("Positive Sample: " + gSequencer.buffer);
        System.out.println("GENIUS INDEX: " + gSequencer.detectGenius());
        System.out.println("REPEATER INDEX: " + gSequencer.detectRepeater("T"));
        System.out.println("GASTRO INDEX: " + gSequencer.detectGastroDisease());

    }
}


