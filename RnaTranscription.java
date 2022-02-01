import java.util.Hashtable;

class RnaTranscription {
    String transcribe(String dnaString) {
        Hashtable<Character, Character> ht = new Hashtable<Character, Character>();

        String output = "";

        ht.put('G', 'C');
        ht.put('C', 'G');
        ht.put('T', 'A');
        ht.put('A', 'U');

        for (int i = 0; i < dnaString.length(); i++) {
            char c;
            if (ht.containsKey(dnaString.charAt(i)))
                c = ht.get(dnaString.charAt(i));
            else
                c = dnaString.charAt(i);
            output += c;
        }
        return output;
    }
}
