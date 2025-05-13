package to_repository.Tinkoff;

import java.io.*;

public class five {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        String[] values = reader.readLine().split(" ");
        int n = Integer.parseInt(values[0]);
        int a = Integer.parseInt(values[1]);
        int b = Integer.parseInt(values[2]);
        String scobochki = reader.readLine();

        int needOpen = 0;
        int balance = 0;
        for(char ch : scobochki.toCharArray()){
            if(ch == '(') {
                balance++;
            } else {
                balance--;
            }

            if(balance < 0){
                needOpen++;
                balance += 2;
            }
        }

        int extraOpen = balance / 2;
        int invertionCost = (needOpen + extraOpen) * b;

        if(a < 2 * b){
            int possibleSwaps = 0;
            if(needOpen > 0 && extraOpen > 0){
                possibleSwaps = 1;
            }

            invertionCost -= possibleSwaps * (2 * b - a);
        }

        writer.write(String.valueOf(invertionCost));
        writer.newLine();
        writer.flush();
        reader.close();
        writer.close();
    }
}
