package Tin_const.summer_2025.programming.summer_2026;

import java.io.*;
//O(n)
public class two {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = reader.readLine().trim();
        int n = s.length();

        StringBuilder sb = new StringBuilder(s).reverse();
        for (int i = 0; i < n; i++) sb.append('a');
        String text = sb.toString();

        int[] pf = new int[n];
        for (int i = 1; i < n; i++) {
            int j = pf[i - 1];
            while (j > 0 && s.charAt(i) != s.charAt(j)) j = pf[j - 1];
            if (s.charAt(i) == s.charAt(j)) j++;
            pf[i] = j;
        }

        boolean found = false;
        int j = 0;
        for (int i = 0; i < text.length(); i++) {
            while (j > 0 && text.charAt(i) != s.charAt(j)) j = pf[j - 1];
            if (text.charAt(i) == s.charAt(j)) j++;
            if (j == n) {
                found = true;
                break;
            }
        }

        writer.write(found ? "Yes" : "No");
        writer.newLine();
        writer.flush();

        reader.close();
        writer.close();
    }
}