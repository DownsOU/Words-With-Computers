package words_with_computers;
import java.util.ArrayList;
import java.lang.StringBuilder;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;


public class PlayComputer {
    
    private char letters[] = new char[7];
    private ArrayList<String> dictionary = new ArrayList();
    
    public void giveLetters(char[] letterArray) {
        for(int i=0; i<letterArray.length; i++){
            letters[i] = letterArray[i];
        }
    }
    
    public void playTurn() throws FileNotFoundException{
        System.out.println(letters);
        ArrayList<ArrayList<Character>> charWordList = new ArrayList();
        ArrayList<String> stringWordList = new ArrayList();
        ArrayList<ArrayList<String>> combo = new ArrayList();
        for(int i=3; i<letters.length +1; i++){
            combo.add(getCombinations(letters,i));
        }
        for(ArrayList<String> comb : combo){
            for(String word: comb){
                stringWordList.add(word);
                char[] ch = word.toCharArray();
                charWordList = getPermutations(ch);
                System.out.println(word);
            }
        }
        //System.out.println(combo);
        //charWordList = getPermutations(letters);
        for(ArrayList<Character> c : charWordList) {
            System.out.println(c);
        }
        //System.out.println(charWordList);
        for(int i = 0; i < charWordList.size(); i++) {
            stringWordList.add(getString(charWordList.get(i)));
        }
        //System.out.println(checkWords(stringWordList));
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
    
    private ArrayList<ArrayList<Character>> getPermutations(char[] elements) {
        ArrayList<ArrayList<Character>> result = new ArrayList();
        permutationHelper(0, elements, result);
        return result;
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
    
    private ArrayList<String> checkWords(ArrayList<String> words) throws FileNotFoundException {
        File wordFile = new File("words_alpha.txt");
        Scanner scan = new Scanner(wordFile);
        while(scan.hasNextLine()){
            dictionary.add(scan.nextLine());
        }
        Pattern compile = Pattern.compile("[aeiou]");
        ArrayList<String> wordArray = new ArrayList();
        for(String word: words) {
           if(word.length() < 3){
               words.remove(word);
           }
           else {
               Matcher matcher = compile.matcher(word);
               if (matcher.find() == false) {
                   words.remove(word);
               }
           }
           for(String dict: dictionary) {
               if(word.equals(dict)) {
                   wordArray.add(word);
               }
           }
        }
        return wordArray;
    }
    
     
}

