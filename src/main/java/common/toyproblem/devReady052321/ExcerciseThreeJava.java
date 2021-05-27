package common.toyproblem.devReady052321;


public class ExcerciseThreeJava {

    public static void main(String[] args) {

        int[] k = {1, 1, 3, 3, 3, 4, 5, 5, 5, 5};
        int t = 2;
        int result = solution(k, t);
        System.out.println("result: " + result);
    }

    static int solution(int[] A, int K) {
        int n = A.length;
        int best = 0;
        int count = 1;
        int bestValue = A[0];
        for (int i = 0; i < n - 1; i++) {
//            for (int i = 0; i < n - K - 1; i++) {
            if (A[i] == A[i + 1])
                count = count + 1;
            else
                count = 0;
            if (count > best )
                best = count;
                bestValue = A[i];
        }
        int result = best + K;

        return result;
    }
}
