package Tin_const.summer_2025.programming.winter_spring_2026;

import java.io.*;
import java.util.Arrays;

public class one {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        char[] digits = reader.readLine().trim().toCharArray();
        Arrays.sort(digits);

        int firstNonZero = 0;
        while (digits[firstNonZero] == '0') {
            firstNonZero++;
        }

        char firstDigit = digits[firstNonZero];
        digits[firstNonZero] = digits[0];
        digits[0] = firstDigit;

        writer.write(new String(digits));
        writer.newLine();
        writer.flush();

        reader.close();
        writer.close();
    }
}
