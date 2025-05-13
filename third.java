package Tin_const.summer_2025.programming;

import java.io.*;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class third {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Integer> set = new HashSet<>();

        int n = Integer.parseInt(reader.readLine());
        String[] mas = reader.readLine().split(" ");

        int[] arr = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(mas[i]);
        }
        Arrays.sort(arr);

        for (int i = n - 1; i >= 0; i--) {
            int num = arr[i];
            while(num >= 0){
                if(!set.contains(num)){
                    set.add(num);
                    break;
                }
                if(num == 0){
                    break;
                }
                num /= 2;
            }
        }

        writer.write(String.valueOf(set.size()));
        writer.newLine();
        writer.flush();
        reader.close();
        writer.close();
    }
}

