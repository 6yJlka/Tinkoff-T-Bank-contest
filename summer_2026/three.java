package Tin_const.summer_2025.programming.summer_2026;

import java.io.*;
//O(log n)
public class three {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] line = reader.readLine().trim().split(" ");
        long n = Long.parseLong(line[0]);
        long m = Long.parseLong(line[1]);

        long MOD = 1_000_000_007L;

        long base = ((m * m % MOD) - 3 * m % MOD + 3 + MOD) % MOD;
        long first = m % MOD * ((m - 1 + MOD) % MOD) % MOD;

        long power = 1L;
        long exp = n - 1;
        long b = base % MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) power = power * b % MOD;
            b = b * b % MOD;
            exp >>= 1;
        }

        long answer = first * power % MOD;

        writer.write(String.valueOf(answer));
        writer.newLine();
        writer.flush();

        reader.close();
        writer.close();
    }
}