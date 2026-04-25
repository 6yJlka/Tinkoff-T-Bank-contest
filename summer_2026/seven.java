package Tin_const.summer_2025.programming.summer_2026;

import java.io.*;
import java.util.*;
//O(n²)
public class seven {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(st.nextToken());
        long x = Long.parseLong(st.nextToken());

        long[] a = new long[n];
        st = new StringTokenizer(reader.readLine());
        for (int i = 0; i < n; i++) a[i] = Long.parseLong(st.nextToken());

        Set<Long> candidates = new LinkedHashSet<>();
        candidates.add(x);
        for (int i = 0; i < n; i++) {
            long y = ((x + a[i] - 1) / a[i]) * a[i];
            candidates.add(y);
        }

        long answer = Long.MAX_VALUE;

        for (long y : candidates) {

            long cy = 0, vy = y;
            for (int i = a.length - 1; i >= 0; i--) { cy += vy / a[i]; vy %= a[i]; }

            long cx = 0, vx = y - x;
            for (int i = a.length - 1; i >= 0; i--) { cx += vx / a[i]; vx %= a[i]; }

            answer = Math.min(answer, cy + cx);
        }

        writer.write(String.valueOf(answer));
        writer.newLine();
        writer.flush();

        reader.close();
        writer.close();
    }
}