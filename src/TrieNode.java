// Got help from httAps://www.lavivienpost.com/autocomplete-with-trie-code/
/*
Affan Dhankwala
 */
import java.util.*;
public class TrieNode {
    char value;
    LinkedList<TrieNode> children;
    TrieNode parent;
    boolean end;

    public TrieNode(char c) {                    //Creates new Trie Node
        value = c;
        children = new LinkedList<TrieNode>();
        end = false;
    }

    public TrieNode getChild(char c) {          //Traverses all of children and finds the node that has specified character
        if (children != null){
            for(int i = 0; i < children.size(); i++){
                if(children.get(i).value == c){
                    return children.get(i);
                }
            }
        }
        return null;
    }

    protected List<String> getWords() {         //Traverses the list of Nodes until it is null then adds that word to a list containing all words in that tree.
        List<String> list = new ArrayList<String>();
        if (end) {
            list.add(toString());
        }

        if (children != null) {
            for (int i = 0; i< children.size(); i++) {
                if (children.get(i) != null) {
                    list.addAll(children.get(i).getWords());
                }
            }
        }
        return list;
    }
    @Override
    public String toString(){
        if (parent == null){
            return "";
        }
        return parent.toString() + new String(new char[] {value});
    }
}
