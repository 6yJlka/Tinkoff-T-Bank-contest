package Tin_const.summer_2025.programming;

import java.io.*;

public class second {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        int[][] mas = new int[n][2];
        for(int i = 0; i < n; i++){
            String[] arr = reader.readLine().split(" ");
            mas[i][0] = Integer.parseInt(arr[0]);
            mas[i][1] = Integer.parseInt(arr[1]);
        }

        int q = Integer.parseInt(reader.readLine());
        for(int i = 0; i < q; i++){
            String[] query = reader.readLine().split(" ");
            int t = Integer.parseInt(query[0]) - 1;
            int d = Integer.parseInt(query[1]);

            int a = mas[t][0];
            int b = mas[t][1];

            int time;
            if(d <= a){
                time = a;
            } else {
                int k = (d - a + b - 1)/b;
                time = a + k * b;
            }
            writer.write(String.valueOf(time));
            writer.newLine();
            writer.flush();
        }
        reader.close();
        writer.close();

    }
}
