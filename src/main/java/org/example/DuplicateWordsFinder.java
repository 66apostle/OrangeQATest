package org.example;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DuplicateWordsFinder {
    public static void main(String[] args) {
        String text = "The enormous room on the ground floor faced towards the north. Cold for all the summer beyond the panes, for all the tropical heat of the room itself, a harsh thin light glared through the windows, hungrily seeking some draped lay figure, some pallid shape of academic gooseflesh, but finding only the glass and nickel and bleakly shining porcelain of a laboratory. Wintriness responded to wintriness. The overalls of the workers were white, their hands gloved with a pale corpse-colored rubber. The light was frozen, dead, a ghost. Only from the yellow barrels of the microscopes did it borrow a certain rich and living substance, lying along the polished tubes like butter, streak after luscious streak in long recession down the worktables.";
        try {
            HashMap<String, Integer> wordCount = findDuplicateWords(text);
            if (wordCount.isEmpty()) {
                throw new Exception("No repeated words");
            }
            for (String word : wordCount.keySet()) {
                System.out.println(word + ": " + wordCount.get(word));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public static HashMap<String, Integer> findDuplicateWords(String text) {
        HashMap<String, Integer> wordCount = new HashMap<>();
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b");
        Matcher matcher = pattern.matcher(text);
        while (matcher.find()) {
            String word = matcher.group(1).toLowerCase();
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        HashMap<String, Integer> duplicateWords = new HashMap<>();
        for (String word : wordCount.keySet()) {
            int count = wordCount.get(word);
            if (count > 1) {
                duplicateWords.put(word, count);
            }
        }
        return duplicateWords;
    }
}
