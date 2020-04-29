package model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@AllArgsConstructor
@Data
public class SubArray {
    private int leftIndex;
    private int rightIndex;
    private long sum;
}
