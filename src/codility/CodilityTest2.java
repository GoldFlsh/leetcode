package codility;

import java.util.HashMap;
import java.util.Map;

class CodilityTest2 {
    public int solution(String S) {
        Map<String, Integer> firstDigrams = new HashMap<>();
        int furtherIdenticalDigrams = -1;
        for(int i = 0; i < S.length() - 1; i++) {
            String currentDigram = S.substring(i, i+2);
            if(!firstDigrams.containsKey(currentDigram)) {
                firstDigrams.put(currentDigram, i);
            } else {
                int firstIndex = firstDigrams.get(currentDigram);
                if(furtherIdenticalDigrams < i - firstIndex) {
                    furtherIdenticalDigrams = i - firstIndex;
                }
            }
        }

        return furtherIdenticalDigrams;
    }
}
