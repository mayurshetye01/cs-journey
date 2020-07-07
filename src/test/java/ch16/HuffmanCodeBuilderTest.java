package ch16;

import ch16.s3.CharacterCode;
import ch16.s3.HuffmanCodeBuilder;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class HuffmanCodeBuilderTest {

    @Test
    void testHuffmanCodes() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 45; i++)
            sb.append("a");
        for (int i = 0; i < 13; i++)
            sb.append("b");
        for (int i = 0; i < 12; i++)
            sb.append("c");
        for (int i = 0; i < 16; i++)
            sb.append("d");
        for (int i = 0; i < 9; i++)
            sb.append("e");
        for (int i = 0; i < 5; i++)
            sb.append("f");
        HuffmanCodeBuilder huffmanCodeBuilder = new HuffmanCodeBuilder();
        List<CharacterCode> result = huffmanCodeBuilder.build(sb.toString().toCharArray());
        List<CharacterCode> expected = new ArrayList<>();
        Integer[] a = {0};
        Integer[] b = {1, 0, 1};
        Integer[] c = {1, 0, 0};
        Integer[] d = {1, 1, 1};
        Integer[] e = {1, 1, 0, 1};
        Integer[] f = {1, 1, 0, 0};
        expected.add(new CharacterCode('a', a));
        expected.add(new CharacterCode('b', b));
        expected.add(new CharacterCode('c', c));
        expected.add(new CharacterCode('d', d));
        expected.add(new CharacterCode('e', e));
        expected.add(new CharacterCode('f', f));

        assertEquals(expected.size(), result.size());
        
        Collections.sort(result, Comparator.comparing(CharacterCode::getCharacter));
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getCharacter(), result.get(i).getCharacter());
            assertArrayEquals(expected.get(i).getCode(), result.get(i).getCode());
        }
    }
}
