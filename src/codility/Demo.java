package codility;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

class Demo {
    public int solution(int[] A) {
        Set<Integer> set = Arrays.stream(A)
                .filter(num -> num > 0)
                .boxed()
                .collect(Collectors.toSet());

        int smallestIndex = 1;
        boolean found = false;
        while(!found) {
            if(!set.contains(smallestIndex)) {
                found = true;
            } else {
                smallestIndex++;
            }
        }
        return smallestIndex;
    }
}



//    int smallestMissingInteger = 1;
//    List<Integer> sorted = Arrays.stream(A)
//            .sorted()
//            .filter(num -> num > 0)
//            .boxed()
//            .collect(Collectors.toList());
//
//    int currentSmallestIndex = 1;
//
//        for (Integer integer : sorted) {
//                if (integer == currentSmallestIndex) {
//                currentSmallestIndex++;
//                } else if(integer > currentSmallestIndex){
//                return currentSmallestIndex;
//                }
//                }
//
//                return currentSmallestIndex;
//                }

