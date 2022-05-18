package test.slidingwindow;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {
    public static void main(String[] args) {
        String s = "cbbebi";
        System.out.println(getLongestSubstringKDistinct(s, 3));
    }

    private static String getLongestSubstringKDistinct(final String s, final int k) {
        if(k < 1)
            throw new IllegalArgumentException();
        Map<Character,Integer> map = new HashMap<>();
        int windowStart = 0;
        int windowEnd = 0;
        int finalStart = 0;
        int finalEnd = Integer.MIN_VALUE;
        int charCount;

        while(windowEnd < s.length()){
            Character charAtEnd = s.charAt(windowEnd);
            if(map.containsKey(charAtEnd)){
                map.put(charAtEnd, map.get(charAtEnd) + 1 );
            }
            else
                map.put(charAtEnd, 1);
            charCount = getCharCount(map);
            if(charCount > k){
                if(windowEnd - windowStart > finalEnd - finalStart ){
                    finalEnd = windowEnd;
                    finalStart = windowStart;
                }
                Character charAtStart = s.charAt(windowStart);
                if(map.get(charAtStart) == 1)
                    map.remove(charAtStart);
                else
                    map.put(charAtStart, map.get(charAtStart) - 1);
                windowStart++;
            }
            windowEnd++;
        }
        return finalEnd > s.length() ? null : s.substring(finalStart,finalEnd);
    }

    private static int getCharCount(final Map<Character, Integer> map) {
        return map.entrySet().size();
    }
}
