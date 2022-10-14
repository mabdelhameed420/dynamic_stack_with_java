package com.company;


import java.util.Arrays;

class ArrayStack<T> {
    private int size;
    private int top;
    private int i;
    Object[] stackArray;

    public ArrayStack(int size) {
        top = -1;
        this.size = size;
        stackArray = new Object[this.size];
    }

    public void push(Object newItem) {
        ensureCapacity(top + 2);
        top++;
        stackArray[top] = newItem;
        i = top;
    }

    public void pop() {
        if (isEmpty()) {
            System.out.println("stack is empty");
            return;
        }
        stackArray[top] = null;
        top--;
        i = top;
    }

    public T outTop() {
        T item = (T) stackArray[top];
        return item;
    }

    public void ensureCapacity(int minCapacity) {
        int oldCapacity = stackArray.length;
        if (minCapacity > oldCapacity) {
            int newCapacity = oldCapacity * 2;
            if (newCapacity < minCapacity)
                newCapacity = oldCapacity;
            stackArray = Arrays.copyOf(stackArray, newCapacity);
        }
    }

    public void printItem() {
        if (isEmpty()) {
            System.out.println("stack is empty");
        } else {
            T item = (T) stackArray[i];
            System.out.println(item);
            i--;
            if (i > -1) printItem();
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
        var array = new ArrayStack(2);
        System.out.println("size of array "+array.stackArray.length);
        array.push(7);
        array.push(3);
        array.push(5);
        array.push(8);
        array.printItem();
        System.out.println("size of array "+array.stackArray.length);
    }
}

