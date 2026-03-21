package Tin_const.summer_2025.programming.winter_spring_2026;

import java.io.*;

public class two {
    private static final String FIRST = "tbank";
    private static final String SECOND = "study";
    private static final int LEN = 5;
    private static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = reader.readLine().trim();
        int n = s.length();
        int positions = n - LEN + 1;

        int[] firstCost = new int[positions];
        int[] secondCost = new int[positions];

        for (int i = 0; i < positions; i++) {
            int currentFirstCost = 0;
            int currentSecondCost = 0;

            for (int j = 0; j < LEN; j++) {
                if (s.charAt(i + j) != FIRST.charAt(j)) {
                    currentFirstCost++;
                }
                if (s.charAt(i + j) != SECOND.charAt(j)) {
                    currentSecondCost++;
                }
            }

            firstCost[i] = currentFirstCost;
            secondCost[i] = currentSecondCost;
        }

        int answer = INF;

        int[] prefixMinSecond = new int[positions];
        int[] suffixMinSecond = new int[positions];

        prefixMinSecond[0] = secondCost[0];
        for (int i = 1; i < positions; i++) {
            prefixMinSecond[i] = Math.min(prefixMinSecond[i - 1], secondCost[i]);
        }

        suffixMinSecond[positions - 1] = secondCost[positions - 1];
        for (int i = positions - 2; i >= 0; i--) {
            suffixMinSecond[i] = Math.min(suffixMinSecond[i + 1], secondCost[i]);
        }

        for (int i = 0; i < positions; i++) {
            if (i - LEN >= 0) {
                answer = Math.min(answer, firstCost[i] + prefixMinSecond[i - LEN]);
            }
            if (i + LEN < positions) {
                answer = Math.min(answer, firstCost[i] + suffixMinSecond[i + LEN]);
            }
        }

        for (int shift = -LEN + 1; shift <= LEN - 1; shift++) {
            boolean compatible = true;
            for (int i = 0; i < LEN; i++) {
                int secondIndex = i - shift;
                if (secondIndex >= 0 && secondIndex < LEN && FIRST.charAt(i) != SECOND.charAt(secondIndex)) {
                    compatible = false;
                    break;
                }
            }

            if (!compatible) {
                continue;
            }

            int leftStart = Math.max(0, -shift);
            int rightStart = Math.min(positions - 1, positions - 1 - shift);

            for (int firstStart = leftStart; firstStart <= rightStart; firstStart++) {
                int secondStart = firstStart + shift;
                int unionStart = Math.min(firstStart, secondStart);
                int unionEnd = Math.max(firstStart + LEN, secondStart + LEN);
                int currentCost = 0;

                for (int pos = unionStart; pos < unionEnd; pos++) {
                    char need;
                    if (pos >= firstStart && pos < firstStart + LEN) {
                        need = FIRST.charAt(pos - firstStart);
                    } else {
                        need = SECOND.charAt(pos - secondStart);
                    }

                    if (s.charAt(pos) != need) {
                        currentCost++;
                    }
                }

                answer = Math.min(answer, currentCost);
            }
        }

        writer.write(String.valueOf(answer));
        writer.newLine();
        writer.flush();

        reader.close();
        writer.close();
    }
}
