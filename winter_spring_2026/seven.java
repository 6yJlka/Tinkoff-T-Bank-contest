package Tin_const.summer_2025.programming.winter_spring_2026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class seven {
    static final long MOD = 1_000_000_007L;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int k = Integer.parseInt(tokenizer.nextToken());

        int maxBishops = n == 1 ? 1 : 2 * n - 2;
        if (k > maxBishops) {
            writer.write("0");
            writer.newLine();
            writer.flush();
            reader.close();
            writer.close();
            return;
        }

        ArrayList<Integer> firstColor = new ArrayList<>();
        ArrayList<Integer> secondColor = new ArrayList<>();

        for (int d = -(n - 1); d <= n - 1; d++) {
            int length = n - Math.abs(d);
            if ((d & 1) == 0) {
                firstColor.add(length);
            } else {
                secondColor.add(length);
            }
        }

        Collections.sort(firstColor);
        Collections.sort(secondColor);

        long[] waysFirst = new long[k + 1];
        long[] waysSecond = new long[k + 1];
        waysFirst[0] = 1;
        waysSecond[0] = 1;

        for (int length : firstColor) {
            for (int bishops = k; bishops >= 1; bishops--) {
                int free = length - bishops + 1;
                if (free > 0) {
                    waysFirst[bishops] = (waysFirst[bishops] + waysFirst[bishops - 1] * free) % MOD;
                }
            }
        }

        for (int length : secondColor) {
            for (int bishops = k; bishops >= 1; bishops--) {
                int free = length - bishops + 1;
                if (free > 0) {
                    waysSecond[bishops] = (waysSecond[bishops] + waysSecond[bishops - 1] * free) % MOD;
                }
            }
        }

        long answer = 0;
        for (int i = 0; i <= k; i++) {
            answer = (answer + waysFirst[i] * waysSecond[k - i]) % MOD;
        }

        writer.write(String.valueOf(answer));
        writer.newLine();
        writer.flush();
        reader.close();
        writer.close();
    }
}
