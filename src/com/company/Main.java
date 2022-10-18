package com.company;


import java.util.Arrays;

class ArrayStack<T> {
    private final int size;
    private int top;
    private Object[] stackArray;

    public ArrayStack(int size) {
        top = -1;
        this.size = size;
        stackArray = new Object[this.size];
    }

    public void push(Object newItem) {
        ensureCapacity(top + 2);
        top++;
        stackArray[top] = newItem;
    }

    public void pop() {
        ensureCapacity(top + 2);
        stackArray = Arrays.copyOf(stackArray,top--);
    }

    public int stackSize() {
        return stackArray.length;
    }

    public void ensureCapacity(int minCapacity) {
        int oldCapacity = stackArray.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2;
            if (newCapacity < minCapacity)
                newCapacity = oldCapacity;
            stackArray = Arrays.copyOf(stackArray, newCapacity);
        } else {
            int newCapacity = oldCapacity / 2;
            if (newCapacity < minCapacity)
                newCapacity = oldCapacity;
            stackArray = Arrays.copyOf(stackArray, newCapacity);
        }
    }

    public void printStack() {
        if (isEmpty()) {
            System.out.println("stack is empty");
        } else
            for (int i = stackArray.length - 1; i >= 0; i--) {
                System.out.println(stackArray[i]);
            }
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }
}

public class Main {

    public static void main(String[] args) {
        var array = new ArrayStack<>(2);
        System.out.println("size of array " + array.stackSize());
        array.push(7);
        array.push(3);
        array.printStack();
        array.push(5); // enter new element and increase size of stack multiply by 2
        array.push(8);
        array.printStack();
        System.out.println("size of array " + array.stackSize());
        array.pop(); // remove top --> int 8
        array.pop(); // remove top --> int 5 and reduce size of stack divide by 2
        array.printStack();
        System.out.println("size of array " + array.stackSize());
    }
}

