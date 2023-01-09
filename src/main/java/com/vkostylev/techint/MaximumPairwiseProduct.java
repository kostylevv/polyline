package com.vkostylev.techint;

import java.util.*;
import java.io.*;

public class MaximumPairwiseProduct {
    static int getMaxPairwiseProduct(int[] numbers) {
        int max_product = 0;
        int n = numbers.length;

        int indexMax = -1;
        int maxValue = 0;

        for (int i = 0; i < n; i++) {
            if (numbers[i] > maxValue) {
                maxValue = numbers[i];
                indexMax = i;
            }
        }

        int secMax = 0;

        for (int i = 0; i < n; i++) {
            if (numbers[i] > secMax && i != indexMax) {
                secMax = numbers[i];
            }
        }


        return (maxValue*secMax);
    }

    public static void main(String[] args) {
        FastScanner scanner = new FastScanner(System.in);
        int n = scanner.nextInt();
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }
        System.out.println(getMaxPairwiseProduct(numbers));
    }

    static class FastScanner {
        BufferedReader br;
        StringTokenizer st;

        FastScanner(InputStream stream) {
            try {
                br = new BufferedReader(new
                        InputStreamReader(stream));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String next() {
            while (st == null || !st.hasMoreTokens()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }
    }

}
