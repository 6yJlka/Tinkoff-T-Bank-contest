package Tin_const.summer_2025.programming.summer_2026;

import java.io.*;
//O(1)
public class one {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        long n = Long.parseLong(reader.readLine().trim());

        if (n % 2 == 0) {
            writer.write("Anya");
        } else {
            writer.write("Masha");
        }

        writer.newLine();
        writer.flush();

        reader.close();
        writer.close();
    }
}
