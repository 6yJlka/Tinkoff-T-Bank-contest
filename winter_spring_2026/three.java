package Tin_const.summer_2025.programming.winter_spring_2026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class three {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder answer = new StringBuilder();

        int t = Integer.parseInt(reader.readLine().trim());
        while (t-- > 0) {
            String s = reader.readLine().trim();
            int n = s.length();
            boolean allOnes = true;

            for (int i = 0; i < n; i++) {
                if (s.charAt(i) == '0') {
                    allOnes = false;
                    break;
                }
            }

            if (allOnes) {
                answer.append(1L * n * n).append('\n');
                continue;
            }

            int longest = 0;
            int current = 0;

            for (int i = 0; i < 2 * n; i++) {
                if (s.charAt(i % n) == '1') {
                    current++;
                    if (current > longest) {
                        longest = current;
                    }
                } else {
                    current = 0;
                }
            }

            if (longest > n) {
                longest = n;
            }

            long sum = longest + 1L;
            long h = sum / 2;
            long w = sum - h;
            long best = h * w;
            answer.append(best).append('\n');
        }

        writer.write(String.valueOf(answer));
        writer.flush();

        reader.close();
        writer.close();
    }
}
