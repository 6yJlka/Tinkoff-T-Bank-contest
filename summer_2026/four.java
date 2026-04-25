package Tin_const.summer_2025.programming.summer_2026;

import java.io.*;
import java.util.*;
//O(n)
public class four {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine().trim());
        StringTokenizer st = new StringTokenizer(reader.readLine());
        long[] p = new long[n];
        for (int i = 0; i < n; i++) p[i] = Long.parseLong(st.nextToken());

        long[] left = new long[n];
        long minPrice = p[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], p[i] - minPrice);
            minPrice = Math.min(minPrice, p[i]);
        }

        long[] right = new long[n];
        long maxPrice = p[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], maxPrice - p[i]);
            maxPrice = Math.max(maxPrice, p[i]);
        }

        long answer = 0;
        for (int i = 0; i < n; i++) {
            answer = Math.max(answer, left[i] + right[i]);
        }

        writer.write(String.valueOf(answer));
        writer.newLine();
        writer.flush();

        reader.close();
        writer.close();
    }
}