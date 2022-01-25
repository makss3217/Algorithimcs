package com.maks.algorithmics.linear.data.structure;

import com.maks.algorithmics.Utils.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Stack;
import java.util.List;

public class StackBracket {

    private static final BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    public static void run() throws IOException {
        List<Integer> list;
        while ((list = Input.readListOfIntegersFromLineOrNull(br)) != null) {
            if (isCorrect(list)) {
                System.out.println(":-) Matrioshka!");
            } else {
                System.out.println(":-( Try again.");
            }
        }
    }

    private static boolean isCorrect(List<Integer> list) {
        Stack<Integer> brackets = new Stack<>();
        Stack<Integer> availablePlaces = new Stack<>();
        for (Integer i : list) {
            if (i < 0) {
                brackets.push((-1) * i);
                availablePlaces.push((-1) * i);
            } else {
                if (Objects.equals(brackets.peek(), i)) {
                    brackets.pop();
                    availablePlaces.pop();
                    if(!availablePlaces.empty()) {
                        if (i < availablePlaces.peek()) {
                            availablePlaces.push(availablePlaces.pop() - i);
                        } else {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }

}
