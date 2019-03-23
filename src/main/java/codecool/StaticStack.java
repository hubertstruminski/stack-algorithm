package codecool;

import java.util.ArrayList;
import java.util.List;

public class StaticStack<T> {

    private static int[] array;
    private static int index = 0;

    public StaticStack(int size) {
        array = new int[size];
    }

    public void push(int value) throws StackOverflowException {
        if(index >= array.length) {
            throw new StackOverflowException("Stack is full");
        }
        array[index++] = value;
    }

    public int size() {
        return array.length;
    }

    public int pop() throws StackUnderflowException {
        List<Integer> element = new ArrayList<>();

        if(array.length == 0) {
            throw new StackUnderflowException("Stack is empty");
        }
        int[] result = new int[array.length - 1];
        for(int i=0; i<array.length-2; i++) {
            result[i] = array[i];
        }
        element.add(array[array.length-1]);
        array = result;

        return element.get(0);
    }

    public int peek() throws StackUnderflowException {
        if(array.length == 0) {
            throw new StackUnderflowException("Stack is empty");
        }
        return array[array.length - 1];
    }



    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        for(int i=0; i<array.length; i++) {
            builder.append(" " + array[i]);
        }
        return builder.toString();
    }
}
