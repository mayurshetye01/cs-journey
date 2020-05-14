package ch09.s3;

import annotations.Quality;
import annotations.Stage;
import services.Selector;

@Quality(Stage.INCOMPLETE)
public class MedianSelector<E extends Comparable<E>> implements Selector<E> {

    @Override
    public E select(E[] items, int i) {
        return null;
    }
}
