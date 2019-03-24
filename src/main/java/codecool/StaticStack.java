package codecool;

import java.util.ArrayList;
import java.util.List;

public class StaticStack<T> {

    private T[] array;
    private int index = 0;
    private T[] result;

    public StaticStack(int size) {
        array = (T[]) new Object[size];
    }

    public void push(T value) throws StackOverflowException {
        if(index >= array.length) {
            throw new StackOverflowException("Stack is full");
        }
        array[index++] = value;
    }

    public int size() {
        return array.length;
    }

    public T pop() throws StackUnderflowException {
        int count = 0;
        for(int i=0; i<array.length; i++) {
            if(array[i] == null) {
                count++;
            }
            if(count == array.length - 1) {
                throw new StackUnderflowException("Stack is empty");
            }
        }
        List<T> element = new ArrayList<>();

        result = (T[]) new Object[array.length - 1];
        for(int i=0; i<array.length-2; i++) {
            result[i] = array[i];
        }
        element.add(array[array.length-1]);

        array = result;

        return element.get(0);
    }

    public T peek() throws StackUnderflowException {
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
