package ch16.s3;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CharacterCode {
    private final Character character;
    private final Integer[] code;
}
