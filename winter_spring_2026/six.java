package Tin_const.summer_2025.programming.winter_spring_2026;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class six {
    static final long INF = (long) 4e18;
    static long[] tree;
    static int[] lazy;
    static String s;

    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
        int n = Integer.parseInt(tokenizer.nextToken());
        int q = Integer.parseInt(tokenizer.nextToken());
        s = reader.readLine().trim();

        tree = new long[4 * n];
        lazy = new int[4 * n];
        build(1, 1, n);

        StringBuilder answer = new StringBuilder();

        for (int query = 0; query < q; query++) {
            tokenizer = new StringTokenizer(reader.readLine());
            int type = Integer.parseInt(tokenizer.nextToken());

            if (type == 1) {
                long left = Long.parseLong(tokenizer.nextToken());
                long right = Long.parseLong(tokenizer.nextToken());

                long[] leftInfo = findKth(1, 1, n, left, 0);
                long[] rightInfo = findKth(1, 1, n, right, 0);

                int leftIndex = (int) leftInfo[0];
                long leftBefore = leftInfo[1];
                long leftCount = leftInfo[2];

                int rightIndex = (int) rightInfo[0];
                long rightBefore = rightInfo[1];
                long rightCount = rightInfo[2];

                if (leftIndex == rightIndex) {
                    pointAdd(1, 1, n, leftIndex, right - left + 1);
                } else {
                    long leftOverlap = leftBefore + leftCount - left + 1;
                    long rightOverlap = right - rightBefore;

                    pointAdd(1, 1, n, leftIndex, leftOverlap);
                    pointAdd(1, 1, n, rightIndex, rightOverlap);

                    if (leftIndex + 1 <= rightIndex - 1) {
                        rangeDouble(1, 1, n, leftIndex + 1, rightIndex - 1);
                    }
                }
            } else {
                long position = Long.parseLong(tokenizer.nextToken());
                long[] info = findKth(1, 1, n, position, 0);
                answer.append(s.charAt((int) info[0] - 1)).append('\n');
            }
        }

        writer.write(String.valueOf(answer));
        writer.flush();
        reader.close();
        writer.close();
    }

    static void build(int node, int left, int right) {
        if (left == right) {
            tree[node] = 1;
            return;
        }

        int mid = (left + right) / 2;
        build(node * 2, left, mid);
        build(node * 2 + 1, mid + 1, right);
        tree[node] = tree[node * 2] + tree[node * 2 + 1];
    }

    static void applyDouble(int node) {
        tree[node] = Math.min(INF, tree[node] * 2);
        lazy[node]++;
    }

    static void applyManyDoubles(int node, int times) {
        if (times == 0) {
            return;
        }

        if (times >= 62 || tree[node] > (INF >> times)) {
            tree[node] = INF;
        } else {
            tree[node] <<= times;
        }
        lazy[node] += times;
    }

    static void push(int node) {
        if (lazy[node] == 0) {
            return;
        }

        applyManyDoubles(node * 2, lazy[node]);
        applyManyDoubles(node * 2 + 1, lazy[node]);
        lazy[node] = 0;
    }

    static void pull(int node) {
        tree[node] = Math.min(INF, tree[node * 2] + tree[node * 2 + 1]);
    }

    static void rangeDouble(int node, int left, int right, int ql, int qr) {
        if (ql <= left && right <= qr) {
            applyDouble(node);
            return;
        }

        push(node);
        int mid = (left + right) / 2;

        if (ql <= mid) {
            rangeDouble(node * 2, left, mid, ql, qr);
        }
        if (qr > mid) {
            rangeDouble(node * 2 + 1, mid + 1, right, ql, qr);
        }

        pull(node);
    }

    static void pointAdd(int node, int left, int right, int index, long value) {
        if (left == right) {
            tree[node] = Math.min(INF, tree[node] + value);
            return;
        }

        push(node);
        int mid = (left + right) / 2;

        if (index <= mid) {
            pointAdd(node * 2, left, mid, index, value);
        } else {
            pointAdd(node * 2 + 1, mid + 1, right, index, value);
        }

        pull(node);
    }

    static long[] findKth(int node, int left, int right, long k, long before) {
        if (left == right) {
            return new long[]{left, before, tree[node]};
        }

        push(node);
        int mid = (left + right) / 2;

        if (tree[node * 2] >= k) {
            return findKth(node * 2, left, mid, k, before);
        }

        return findKth(node * 2 + 1, mid + 1, right, k - tree[node * 2], before + tree[node * 2]);
    }
}
