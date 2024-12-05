/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package asmmau;

import java.util.Arrays;

/**
 *
 * @author ADMIN
 */
public class Asmmau {
    public static Object[] initializeStack(int maxSize) {
        Object[] stack = new Object[maxSize];

        for (int i = 0; i < maxSize; i++) {
            stack[i] = null;
        }

        return stack;
    }

    public static void main(String[] args) {
        int maxSize = 10;

        Object[] stack = initializeStack(maxSize);

        int top = -1;

        System.out.println("Stack initialized with size: " + maxSize);
        System.out.println("Top: " + top);
    }
}