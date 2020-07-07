package ch16.s3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CharacterComponent implements Comparable<CharacterComponent>{
    private Character character;
    private int frequency;

    @Override
    public int compareTo(CharacterComponent that) {
        return Integer.compare(this.getFrequency(), that.getFrequency());
    }
}
