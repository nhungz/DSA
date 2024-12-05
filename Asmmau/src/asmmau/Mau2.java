/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package asmmau;

/**
 *
 * @author ADMIN
 */
public class Mau2 {
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
    public static Object pop(Object[] stack, int[] top) {
        if (top[0] == -1) { 
            System.out.println("Stack Underflow! Cannot pop.");
            return null;
        }
        Object element = stack[top[0]];
        stack[top[0]] = null;
        top[0]--;
        return element;
    }
    public static void main(String[] args) {
        int maxSize = 5; 
        Object[] stack = initializeStack(maxSize);
        int[] top = {-1};

        top[0] = push(stack, top[0], maxSize, 10);
        top[0] = push(stack, top[0], maxSize, 20);

        System.out.println("Popped: " + pop(stack, top));
        System.out.println("Popped: " + pop(stack, top));
        System.out.println("Popped: " + pop(stack, top));
    }
}

