package words_with_computers;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.List;
import java.io.FileInputStream;
import net.didion.jwnl.JWNL;
import net.didion.jwnl.JWNLException;
import net.didion.jwnl.data.*;
import net.didion.jwnl.data.list.PointerTargetNodeList;
import net.didion.jwnl.dictionary.Dictionary;


public class PlayComputer {
    
    private char letters[] = new char[7];
    private ArrayList<String> dictionary = new ArrayList();
    
    public void giveLetters(char[] letterArray) {
        for(int i=0; i<letterArray.length; i++){
            letters[i] = letterArray[i];
        }
    }
    
    public void playTurn() throws JWNLException{
        System.out.println(letters);
        ArrayList<String> allPossible = new ArrayList();
        ArrayList<String> words = new ArrayList();
        
        allPossible = getAllPossible(letters);
        
//        for(String s: allPossible){
//            System.out.println(s);
//        }
//        ArrayList<String> testWords = new ArrayList();
//        testWords.add("ball");
//        testWords.add("car");
//        testWords.add("youkert");
//        testWords.add("backtor");
//        testWords.add("back");
        
        words = checkWords(allPossible);
        System.out.println(words);
    }
    
    public ArrayList<String> getAllPossible(char[] letters) {
        ArrayList<String> stringWordList = new ArrayList();
        ArrayList<ArrayList<String>> combo = new ArrayList();
        ArrayList<ArrayList<String>> permList = new ArrayList();
        for(int i=3; i<letters.length +1; i++){
            combo.add(getCombinations(letters,i));
        }
        for(ArrayList<String> comb : combo){
            for(String word: comb){
                permList.add(getPermutations(word));
            }
        }
        for(ArrayList<String> perm: permList) {
            for(String word: perm) {
                stringWordList.add(word);
            }
        }
        
        for(ArrayList<String> comb : combo){
            for(String word: comb){
                stringWordList.add(word);
            }
        }
        return stringWordList;
    }
    
    private ArrayList<String> getCombinations(char[] letters, int k){
        ArrayList<String> combos = new ArrayList();
        List<String> letterList = new ArrayList();
        for(char letter: letters) {
            String str = Character.toString(letter);
            letterList.add(str);
        }
        comboHelper(letterList, k, "", combos);
        return combos;
    }
    private void comboHelper(List<String> characters, int k, String accumulated,
            ArrayList<String> combos){
        if (characters.size() == k){
            for(String s : characters){
                accumulated+=s;
            }
            combos.add(accumulated);
        }
        if(characters.size() > k){
            for(int i=0;i<characters.size();i++) {
                comboHelper(characters.subList(i+1, characters.size()), k-1, 
                        accumulated+characters.get(i),combos);
            }
        }
    }
    
    private ArrayList<String> getPermutations(String elements) {
        char[] letterArray = new char[elements.length()];
        for(int i =0; i<elements.length(); i++) {
            letterArray[i] = elements.charAt(i);
        }
        ArrayList<ArrayList<Character>> result = new ArrayList();
        ArrayList<String> stringResult = new ArrayList();
        permutationHelper(0, letterArray, result);
        for(ArrayList<Character> arr: result){
            stringResult.add(getString(arr));
        }
        return stringResult;
    }
    
    private void permutationHelper(int start, char[] letterArray, ArrayList<ArrayList<Character>> result){
        
        if(start == letterArray.length-1) {
            ArrayList<Character> list = new ArrayList();
            for(char letter:letterArray) {
                list.add(letter);
            }
            result.add(list);
            return;
        }
        for(int i = start; i < letterArray.length; i++) {
            swap(letterArray, i, start);
            permutationHelper(start+1, letterArray, result);
            swap(letterArray, i, start);
        }
    }
    
    private void swap(char[] input, int a, int b) {
        char tmp = input[a];
        input[a] = input[b];
        input[b] = tmp;
    }
    
    private String getString(ArrayList<Character> list) {
        StringBuilder builder = new StringBuilder(list.size());
        for(Character ch : list) {
            builder.append(ch);
        }
        return builder.toString();
    }
    
    private ArrayList<String> checkWords(ArrayList<String> words) throws JWNLException {
        ArrayList<String> wordArray = new ArrayList();
        configureJWordNet();
        Dictionary wordnet = Dictionary.getInstance();
        IndexWord[] word;
        for(String s : words){
            word = wordnet.lookupAllIndexWords(s).getIndexWordArray();
            if(word.length != 0) {
                wordArray.add(s);
            }
        }
        return wordArray;
    }
    
   private void configureJWordNet(){
       try{
           JWNL.initialize(new FileInputStream("C:\\Users\\david\\Documents\\NetBeansProjects\\Words-With-Computers\\Words_With_Computers\\file_properties.xml"));
       } catch (Exception ex) {
            ex.printStackTrace();
            System.exit(-1);
       }
   }  
}

