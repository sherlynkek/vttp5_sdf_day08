package day08;

@FunctionalInterface
public interface ArithmaticInterface<T> {
    
    T process(T a, T b);
}
