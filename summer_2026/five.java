package Tin_const.summer_2025.programming.summer_2026;

import java.io.*;
//O(n^2)
public class five {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine().trim());
        String s = reader.readLine().trim();

        int[][] dp = new int[n][n];

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            dp[i][i] = (c == 'T' || c == 'O' || c == 'I') ? 0 : 1;
        }

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i <= n - len; i++) {
                int j = i + len - 1;

                int opt1 = dp[i + 1][j] + 1;

                int opt2 = dp[i][j - 1] + 1;

                int matchCost = Integer.MAX_VALUE;
                for (char c : new char[]{'T', 'O', 'I'}) {
                    int cost = (s.charAt(i) != c ? 1 : 0) + (s.charAt(j) != c ? 1 : 0);
                    matchCost = Math.min(matchCost, cost);
                }
                int opt3 = (len == 2 ? 0 : dp[i + 1][j - 1]) + matchCost;

                dp[i][j] = Math.min(opt1, Math.min(opt2, opt3));
            }
        }

        writer.write(String.valueOf(dp[0][n - 1]));
        writer.newLine();
        writer.flush();

        reader.close();
        writer.close();
    }
}