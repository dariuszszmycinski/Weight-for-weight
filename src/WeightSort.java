import java.util.*;

public class WeightSort {

    public static String orderWeight(String strng) {
        String[] numbersAsStrings = strng.split(" ");
        List<NumberAndWeight> numbersAsStringsAndWeight = new ArrayList<>();
        for (String s : numbersAsStrings) numbersAsStringsAndWeight.add(new NumberAndWeight(s));
        numbersAsStringsAndWeight.sort(Comparator.comparing(NumberAndWeight::getWeight).thenComparing(NumberAndWeight::getNumber));
        StringBuilder sb = new StringBuilder();
        for (NumberAndWeight n : numbersAsStringsAndWeight) sb.append(n.number).append(" ");
        return sb.toString().trim();
    }

    static class NumberAndWeight {
        String number;
        int weight;

        public NumberAndWeight(String number) {
            this.number = number;
            int weight = 0;
            char[] digitsAsChars = number.toCharArray();
            for (char c : digitsAsChars) weight += Character.getNumericValue(c);
            this.weight = weight;
        }
        public String getNumber() {
            return number;
        }
        public int getWeight() {
            return weight;
        }
    }
}