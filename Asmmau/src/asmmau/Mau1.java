/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmmau;

/**
 *
 * @author ADMIN
 */
public class Mau1 {
    public static Object[] initializeStack(int maxSize) {
        return new Object[maxSize];
    }
    public static int push(Object[] stack, int top, int maxSize, Object element) {
        if (top >= maxSize - 1) {
            System.out.println("Stack overflow! Cannot push element: " + element);
            return top;
        }
        top++;
        stack[top] = element;
        return top;
    }

    public static void main(String[] args) {
        int maxSize = 5;
        Object[] stack = initializeStack(maxSize);
        int top = -1;
        top = push(stack, top, maxSize, 10);
        top = push(stack, top, maxSize, 20);
        System.out.print("Current stack: ");
        for (int i = 0; i <= top; i++) {
            System.out.print(stack[i] + " ");
        }
    }
}

