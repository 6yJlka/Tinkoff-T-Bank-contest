package Tin_const.summer_2025.programming.summer_2026;

import java.io.*;
import java.util.*;
//O(n log n)
public class six {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(reader.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[][] cands = new long[n][2];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(reader.readLine());
            cands[i][0] = Long.parseLong(st.nextToken());
            cands[i][1] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(cands, (p, q) -> Long.compare(q[0] - q[1], p[0] - p[1]));

        long[] prefBack = new long[n + 1];

        PriorityQueue<Long> backHeap = new PriorityQueue<>();
        long backSum = 0;
        for (int i = 0; i < n; i++) {
            backHeap.add(cands[i][0]);
            backSum += cands[i][0];
            if (backHeap.size() > a) {
                backSum -= backHeap.poll();
            }
            prefBack[i + 1] = (backHeap.size() == a) ? backSum : Long.MIN_VALUE;
        }

        long[] sufML = new long[n + 1];
        PriorityQueue<Long> mlHeap = new PriorityQueue<>();
        long mlSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            mlHeap.add(cands[i][1]);
            mlSum += cands[i][1];
            if (mlHeap.size() > b) {
                mlSum -= mlHeap.poll();
            }
            sufML[i] = (mlHeap.size() == b) ? mlSum : Long.MIN_VALUE;
        }

        long answer = Long.MIN_VALUE;
        for (int k = a; k <= n - b; k++) {
            if (prefBack[k] != Long.MIN_VALUE && sufML[k] != Long.MIN_VALUE) {
                answer = Math.max(answer, prefBack[k] + sufML[k]);
            }
        }

        writer.write(String.valueOf(answer));
        writer.newLine();
        writer.flush();

        reader.close();
        writer.close();
    }
}