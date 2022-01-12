package com.maks.algorithmics.non.linear.data.structure;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class PriorityQueueHeap {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void main(String[] args) throws IOException {
        Integer K ;
        while((K = readIntFromLineOrNull(br)) != null) {
            testCase(K);
        }
    }

    private static void testCase(Integer k) throws IOException {
        List<Integer> result;
        List<Integer> nextInput;

        result = readListOfIntegersFromLineOrNull(br);
        for(int i = 1; i < k; i++) {
            nextInput = readListOfIntegersFromLineOrNull(br);
            result = merge(result, nextInput);
        }
        System.out.println(createResult(result));
    }

    private static List<Integer> merge(List<Integer> a, List<Integer> b) {
        Node top;
        List<Integer> result = new ArrayList<>();
        int k = a.size();
        Collections.sort(b);
        PriorityQueue<Node> pQueue = new PriorityQueue<>();
        for(int i = 0; i < k; i++) {
            pQueue.add(new Node(a.get(i) + b.get(0), 0));
        }
        for(int i = 1; i < k; i++) {
            top = pQueue.poll();
            result.add(top.sum);
            pQueue.add(new Node(top.sum - b.get(top.id) + b.get(top.id + 1), top.id + 1));
        }
        result.add(pQueue.poll().sum);
        return result;
    }

    private static String createResult(List<Integer> result) {
        return result.stream()
            .sorted()
            .map(n -> String.valueOf(n))
            .collect(Collectors.joining(" ", "", ""));
    }

    private static PriorityQueue<Integer> initQueue() throws IOException {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Collections.reverseOrder());
        for(Integer x : readListOfIntegersFromLineOrNull(br)) {
            priorityQueue.add(x);
        }
        return priorityQueue;
    }

    public static List<Integer> readListOfIntegersFromLineOrNull(BufferedReader br) throws IOException {
        String line = br.readLine();
        if(line != null) {
            return Arrays.asList(line.split(" ")).stream()
                .map(Integer::parseInt)
                .collect(toList());
        } else {
            return null;
        }
    }

    public static Integer readIntFromLineOrNull(BufferedReader br) throws IOException {
        String line = br.readLine();
        if(line != null) {
            return Integer.parseInt(line);
        } else {
            return null;
        }
    }

    private static class Node implements Comparable<Node> {
        Integer sum;
        Integer id;

        Node(Integer sum, Integer id) {
            this.sum = sum;
            this.id = id;
        }

        @Override public int compareTo(Node node) {
            return this.sum.compareTo(node.sum);
        }
    }

}
