package com.co.pa;

import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

	    int N = scanner.nextInt();
        int K = scanner.nextInt();
        int[] heights = new int[N];

        for(int i = 0; i < N; i++){
            heights[i] = scanner.nextInt();
        }

        int result = solver(N, K, heights);
        System.out.println(result);

    }


    public static int solver(int N, int K, int[] heights){
        int result = 0;
        for(int i = 0; i < N; i++)
            result = getMinimum(i, heights, K) ? (result + 1) : result;

        return result;
    }

    public static boolean getMinimum(int index, int[] heights, int k){
        int sum = 0, indicator = 0;
        int newIndex = index + 1;
        int toSum = k - (heights.length - newIndex);

        for(int i = newIndex; (i < heights.length && indicator < k); i++){
            if(i < heights.length)
                if (heights[index] > heights[newIndex])
                    sum++;

            newIndex++;
            indicator++;
        }

        sum = toSum > 0 ? sum + toSum : sum;

        return sum == k;
    }
}
