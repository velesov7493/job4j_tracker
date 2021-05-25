package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class EasyStream {

    private List<Integer> buffer;

    private EasyStream(List<Integer> src) {
        buffer = new ArrayList<>(src);
    }

    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> tmpResult = new ArrayList<>();
        for (Integer entry : buffer) {
            tmpResult.add(fun.apply(entry));
        }
        buffer = tmpResult;
        return this;
    }

    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> tmpResult = new ArrayList<>();
        for (Integer entry : buffer) {
            if (fun.test(entry)) {
                tmpResult.add(entry);
            }
        }
        buffer = tmpResult;
        return this;
    }

    public List<Integer> collect() {
        return new ArrayList<>(buffer);
    }
}
