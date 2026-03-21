package Tin_const.summer_2025.programming.winter_spring_2026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class five {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine().trim());
        int[] a = new int[n];
        int[] count = new int[100001];
        boolean[] good = new boolean[100001];

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(tokenizer.nextToken());
            count[a[i]]++;
        }

        for (int i = 0; i < n; i++) {
            int x = a[i];
            int left = a[(i - 1 + n) % n];
            int right = a[(i + 1) % n];

            if ((left < x && right < x) || (left > x && right > x)) {
                good[x] = true;
            }

            int next = a[(i + 1) % n];
            int nextNext = a[(i + 2) % n];

            if (x == next || x == nextNext) {
                good[x] = true;
            }
            if (next == nextNext) {
                good[next] = true;
            }
        }

        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int value = a[i];
            int current;

            if (count[value] == n) {
                current = 0;
            } else if (good[value]) {
                current = n - count[value];
            } else {
                current = n - count[value] + 1;
            }

            if (i > 0) {
                answer.append(' ');
            }
            answer.append(current);
        }

        writer.write(answer.toString());
        writer.newLine();
        writer.flush();

        reader.close();
        writer.close();
    }
}
