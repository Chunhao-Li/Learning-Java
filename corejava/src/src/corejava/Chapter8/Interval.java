package corejava.Chapter8;

import java.io.Serializable;

public class Interval<T extends Comparable & Serializable> implements Serializable{
    private T lower;
    private T upper;

    @SuppressWarnings("unchecked")
    public Interval(T first, T second) {
        if (first.compareTo(second) <= 0) { lower =first; upper = second;}
        else {lower = second; upper = first;}
    }
}
