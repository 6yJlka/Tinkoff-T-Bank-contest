package Tin_const.summer_2025.programming;

import java.io.*;

public class first {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String input = reader.readLine().trim();
        int cnt = 0;

        for(int i = input.length() - 1; i >= 0; i--){
            String line = input.substring(0,i) + input.substring(i+1);
            if(line.charAt(0) == line.charAt(line.length() - 1)){
                writer.write("YES");
                cnt++;
                break;
            }
        }
        if(cnt == 0){
            writer.write("NO");
        }
        writer.newLine();
        writer.flush();
        reader.close();
        writer.close();
    }
}
