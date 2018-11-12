package tudelft.roman;


import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class RomanNumeral {

    private static Map<Character, Integer> map;

    private void initMap() {
        map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
    }

    public int convert(String romanNumber) {
        initMap();
        String romanNumbers = StringUtils.join(map.keySet(), null);
        int result = 0;
        if (romanNumber != null && StringUtils.containsOnly(romanNumber, romanNumbers)) {
            for (int i = 0; i < romanNumber.length(); i++) {
                int num = map.get(romanNumber.charAt(i));
                int numNext = 0;
                int numPrev = 0;
                try {
                    numNext = map.get(romanNumber.charAt(i + 1));
                } catch (IndexOutOfBoundsException ignored) {
                }
                try {
                    numPrev = map.get(romanNumber.charAt(i - 1));
                } catch (IndexOutOfBoundsException ignore) {
                }
                if (numNext != 0 && num < numNext) {
                    if (num == numPrev) {
                        System.out.println("Roman number is incorrect");
                        return 0;
                    } else {
                        result -= num;
                    }
                } else {
                    result += num;
                }
            }
        } else {
            System.out.println("Roman number is incorrect");
        }
        return result;
    }


}
