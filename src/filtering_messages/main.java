package filtering_messages;

public class main {

    static int filteringMessages(String messageA, String messageB, String virusC) {
        int result = 0;
        int messageSize = messageA.length();
        if (messageA.startsWith(virusC) && messageB.startsWith(virusC)) {
            result = 0;
        } else if (messageB.compareTo(messageA) >= 0) {
            int optionsA = getOptions(messageA);
            int optionsB = getOptions(messageB);
            result = optionsB - optionsA + 1 - getVirusCombinations(virusC, messageSize, optionsA, optionsB);
        }
        return result;
    }

    private static int module(double result) {
        return (int) (result % 1000000007);
    }

    public static int getVirusCombinations(String virusC, int messageSize, int optionsA, int optionsB) {
        int virusSize = virusC.length();
        int optionsVirus = getOptions(virusC);
        if (virusSize > messageSize) {
            return 0;
        } else if (optionsVirus <= optionsB && optionsVirus >= optionsA) {
            return 1;
        } else if (optionsVirus < optionsA || optionsVirus > optionsB) {
            return 0;
        } else {
            return ((messageSize - virusSize) + 1) * (int) Math.pow(26, (messageSize - virusSize));
        }
    }

    public static int getOptions(String message) {
        int size = message.length();

        // Invert the string and get array from chars
        char c[] = new StringBuilder(message).reverse().toString().toCharArray();

        int options = 0;

        // check all possible combinations
        for (int i = 0; i < size; i++) {
            options = options + module((Math.pow(26, i)) * (c[i] - 96));
        }

        return options;
    }

    public static void main(String[] args) {
        System.out.println("Result : " + filteringMessages("datcugdy", "yidloemb", "fwurpwbpuvhinuapwyndmhtqvkgkbhtytszotw"));
    }
}
