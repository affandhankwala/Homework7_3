import jdk.jfr.StackTrace;
import org.junit.Test;

import java.util.*;

import static org.junit.Assert.assertEquals;

public class testAutocomplete {
    
    @Test
    public void testAutoComplete(){
        Trie myTrie = new Trie();
        myTrie.insert("hello");
        myTrie.insert("high");
        myTrie.insert("seattle");
        myTrie.insert("seatac");
        myTrie.insert("see");
        myTrie.insert("hollow");
        myTrie.insert("how");

        assertEquals(makeList(List.of("hello", "high", "hollow", "how")), myTrie.autocomplete("h"));
        assertEquals(makeList(List.of("seattle", "seatac", "see")), myTrie.autocomplete("se"));
        assertEquals(makeList(List.of("seattle", "seatac")), myTrie.autocomplete("sea"));
        assertEquals(makeList(List.of("hollow",  "how")), myTrie.autocomplete("ho"));
        assertEquals(makeList(List.of()), myTrie.autocomplete("xyz"));

        Trie myTrie2 = new Trie();
        myTrie2.insert("You");
        myTrie2.insert("YouTube");
        myTrie2.insert("Tube");
        myTrie2.insert("tub");
        myTrie2.insert("Yeti");
        myTrie2.insert("ye");

        assertEquals(makeList(List.of("you", "youtube")), myTrie2.autocomplete("you"));
        assertEquals(makeList(List.of("you", "youtube", "ye", "yeti")), myTrie2.autocomplete("y"));
        assertEquals(makeList(List.of("tub", "tube")), myTrie2.autocomplete("tub"));
        assertEquals(makeList(List.of()), myTrie2.autocomplete("xye"));


        Trie emptyTrie = new Trie();

        assertEquals(makeList(List.of()), emptyTrie.autocomplete("yes"));
        assertEquals(makeList(List.of()), emptyTrie.autocomplete(""));



    }
    public ArrayList<String> makeList(List<String> data){
        ArrayList<String> str = new ArrayList<>();
        str.addAll(data);
        return str;
    }
}
