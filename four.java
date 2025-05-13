package to_repository.Tinkoff;

import java.io.*;
import java.util.Arrays;

public class four {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(reader.readLine());
        String[] mas = reader.readLine().split(" ");
        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(mas[i]);
        }

        int[][] last = new int[n][11];
        int[][] next = new int[n][11];
        int[] current = new int[11];
        Arrays.fill(current, -1);

        for(int i = 0; i < n; i++){
            current[arr[i]] = i;
            System.arraycopy(current, 0, last[i], 0, 11);
        }
        Arrays.fill(current, -1);

        for(int i = n - 1; i >= 0; i--){
            current[arr[i]] = i;
            System.arraycopy(current, 0, next[i], 0, 11);
        }

        int[] minR = new int[n];
        Arrays.fill(minR, -1);

        for(int j = 0; j < n; j++){
            int b = arr[j];
            for(int arr_value = 1; arr_value < 11; arr_value++){
                int value = 0;
                if(j > 0){
                    value = last[j - 1][arr_value];
                } else {
                    value = -1;
                }

                if(value == -1){
                    continue;
                }

                int d = b - arr_value;
                int c_value = b + d;

                if(c_value < 1 || c_value > 10){
                    continue;
                }

                int k = 0;
                if(j + 1 < n){
                    k = next[j + 1][c_value];
                } else {
                    k = -1;
                }

                if(k == -1){
                    continue;
                }

                if(minR[value] == -1 || k < minR[value]){
                    minR[value] = k;
                }
            }
        }

        for(int i = n - 2; i >= 0; i--){
            if(minR[i] == -1 || (minR[i + 1] != -1 && minR[i + 1] < minR[i])){
                minR[i] = minR[i + 1];
            }
        }

        long result = 0;
        for(int i = 0; i < n; i++){
            if(minR[i] != -1){
                result += n - minR[i];
            }
        }

        writer.write(String.valueOf(result));
        writer.newLine();
        writer.flush();
        reader.close();
        writer.close();

    }
}
