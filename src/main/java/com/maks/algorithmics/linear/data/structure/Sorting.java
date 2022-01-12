package com.maks.algorithmics.linear.data.structure;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

    class Contestant implements Comparable<Contestant> {

        private int id;
        private int problemSolved;
        private int totalPenaltyTime;
        private int[] tryForProblems;
        private boolean[] alreadySolvedProblems;
        private boolean hasAnySubmision;

        Contestant(int id) {
            this.id = id;
            this.problemSolved = 0;
            this.totalPenaltyTime = 0;
            this.tryForProblems = new int[11];
            this.alreadySolvedProblems = new boolean[11];
            this.hasAnySubmision = false;
        }

        public int getProblemSolved() {
            return this.problemSolved;
        }

        public boolean hasAnySubmision() {
            return this.hasAnySubmision;
        }

        void catchSubmission(int problemNumber, int penalty, char verdict) {
            if (verdict == 'C' && !alreadySolvedProblems[problemNumber]) {
                problemSolved++;
                alreadySolvedProblems[problemNumber] = true;
                totalPenaltyTime += (tryForProblems[problemNumber] * 20) + penalty;
            }
            if (verdict == 'I' && !alreadySolvedProblems[problemNumber]) {
                tryForProblems[problemNumber]++;
            }
            hasAnySubmision = true;
        }

        @Override
        public int compareTo(Contestant other) {
            if (problemSolved != other.problemSolved) {
                return other.problemSolved - problemSolved;
            } else if (totalPenaltyTime != other.totalPenaltyTime) {
                return totalPenaltyTime - other.totalPenaltyTime;
            } else {
                return id - other.id;
            }
        }

        @Override
        public String toString() {
            return id + " " + problemSolved + " " + totalPenaltyTime;
        }

    }

    public class Sorting {

        private static final int MAX_CONTESTANT = 102;

        private static BufferedReader br;
        private static StringBuilder strBuilder;
        private static List<Contestant> contestans;

        public static void run() throws IOException {
            br = new BufferedReader(new InputStreamReader(System.in));
            strBuilder = new StringBuilder();
            int testCases = Integer.parseInt(br.readLine());
            br.readLine();
            for (int t = 1; t <= testCases; t++) {
                testCase();
                if (t < testCases) {
                    strBuilder.append("\n");
                }
            }
            System.out.print(strBuilder.toString());
        }

        private static void testCase() throws IOException {
            contestans = new ArrayList<>();
            for (int i = 0; i < MAX_CONTESTANT; i++) {
                contestans.add(new Contestant(i));
            }
            List<String> inputLine;
            String readedLine;
            int contestanNumber;
            int problemNumber;
            int time;
            char veridct;

            while (checkIsValue(readedLine = br.readLine())) {
                inputLine = Arrays.asList(readedLine.split(" "));
                contestanNumber = Integer.parseInt(inputLine.get(0));
                problemNumber = Integer.parseInt(inputLine.get(1));
                time = Integer.parseInt(inputLine.get(2));
                veridct = inputLine.get(3).charAt(0);
                contestans.get(contestanNumber).catchSubmission(problemNumber, time, veridct);
            }

            Collections.sort(contestans);
            for (int i = 0; i < MAX_CONTESTANT; i++) {
                if (contestans.get(i).hasAnySubmision()) {
                    strBuilder.append(contestans.get(i).toString());
                    strBuilder.append("\n");
                }
            }

        }

        private static boolean checkIsValue(String str) {
            return str != null && !str.trim().isEmpty();
        }

    }


