package Tin_const.summer_2025.programming.winter_spring_2026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class four {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int m = Integer.parseInt(tokenizer.nextToken());

        ArrayList<Integer>[] graph = new ArrayList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int a = Integer.parseInt(tokenizer.nextToken());
            int b = Integer.parseInt(tokenizer.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        int answer = Integer.MAX_VALUE;
        int[] dist = new int[n + 1];
        int[] parent = new int[n + 1];
        int[] queue = new int[n + 1];

        for (int start = 1; start <= n; start++) {
            Arrays.fill(dist, -1);
            Arrays.fill(parent, -1);

            int head = 0;
            int tail = 0;
            queue[tail++] = start;
            dist[start] = 0;

            while (head < tail) {
                int v = queue[head++];

                if (dist[v] * 2 + 1 >= answer) {
                    continue;
                }

                for (int to : graph[v]) {
                    if (dist[to] == -1) {
                        dist[to] = dist[v] + 1;
                        parent[to] = v;
                        queue[tail++] = to;
                    } else if (parent[v] != to) {
                        int cycleLength = dist[v] + dist[to] + 1;
                        if (cycleLength < answer) {
                            answer = cycleLength;
                        }
                    }
                }
            }

            if (answer == 3) {
                break;
            }
        }

        if (answer == Integer.MAX_VALUE) {
            writer.write("-1");
        } else {
            writer.write(String.valueOf(answer));
        }
        writer.newLine();
        writer.flush();
        reader.close();
        writer.close();
    }
}
