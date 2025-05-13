package to_repository.Tinkoff;

import java.io.*;
import java.util.PriorityQueue;

public class six {
    static class Pair implements Comparable<Pair> {
        int diff;
        int left;
        int right;

        Pair(int left, int right, int diff){
            this.left = left;
            this.right = right;
            this.diff = diff;
        }

        public int compareTo(Pair other) {
            return Integer.compare(other.diff, this.diff);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out));

        int sotrudniki = Integer.parseInt(reader.readLine());
        String[] mas = reader.readLine().split(" ");
        int[] high = new int[sotrudniki];
        for(int i = 0; i < sotrudniki; i++){
            high[i] = Integer.parseInt(mas[i]);
        }

        PriorityQueue<Pair> queue = new PriorityQueue<>();
        int[] prev = new int[sotrudniki];
        int[] next = new int[sotrudniki];
        boolean[] can_be_neighbours = new boolean[sotrudniki];

        for(int i = 0; i < sotrudniki; i++){
            prev[i] = i - 1;
            next[i] = i + 1;
            can_be_neighbours[i] = true;
        }

        for(int i = 0; i < sotrudniki - 1; i++){
            queue.add(new Pair(i, i + 1, Math.abs(high[i] - high[i + 1])));
        }

        int result = 0;
        while (!queue.isEmpty()){
            Pair top = queue.poll();
            int i = top.left;
            int j = top.right;

            if(!can_be_neighbours[i] || !can_be_neighbours[j] || next[i] != j || prev[j] != i){
                continue;
            }

            result += top.diff;
            can_be_neighbours[i] = false;
            can_be_neighbours[j] = false;

            int left_i = prev[i];
            int right_j = next[j];

            if(left_i != -1){
                next[left_i] = right_j;
            }

            if(right_j != sotrudniki){
                prev[right_j] = left_i;
            }

            if(left_i != -1 && right_j != sotrudniki && can_be_neighbours[left_i] && can_be_neighbours[right_j]){
                queue.add(new Pair(left_i, right_j, Math.abs(high[left_i] - high[right_j])));
            }
        }

        writer.write(String.valueOf(result));
        writer.newLine();
        writer.flush();
        reader.close();
        writer.close();
    }
}
