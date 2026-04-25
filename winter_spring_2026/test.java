package Tin_const.summer_2025.programming.winter_spring_2026;

import java.util.HashSet;
import java.util.Random;

public class test {
    static void main(String[] args) {
        var set = new HashSet<Integer>();
        Random random = new Random();

        for(int i = 0; i < 100; i++){
            set.add(random.nextInt(10));
        }

        System.out.println(set.size());
    }

}
