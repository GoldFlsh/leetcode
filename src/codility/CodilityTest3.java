package codility;

import java.util.Arrays;

class CodilityTest3 {

    public int solution(int[] A, int[] B) {
        int size = A.length;
        int fairIndex = 0;
        for(int i = 1; i < size; i++) {
            if(isFair(A, B, i)) {
                fairIndex++;
            }
        }

        return fairIndex;
    }

    private boolean isFair(int[] A, int[] B, int k) {
        // Probably a faster way to calculate the sums,
        // looping through Array once
        int[] A1 = Arrays.copyOfRange(A, 0, k);
        int[] A2 = Arrays.copyOfRange(A, k, A.length);
        int[] B1 = Arrays.copyOfRange(B, 0, k);
        int[] B2 = Arrays.copyOfRange(B, k, B.length);

        int sumA1 = sumOf(A1);
        return sumA1 == sumOf(A2) && sumA1 == sumOf(B1) && sumA1 == sumOf(B2);
    }

    private int sumOf(int[] nums) {
        return Arrays.stream(nums).sum();
    }
}
