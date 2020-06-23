/*
 *
 * Classname Main
 *
 *  23 June 2020
 *
 * Copyright Holovey Ivan
 *
 * 1. GLOSSARY
 * 1.1. Download a text about Harry Potter.
 * 1.2. For each distinct word in the text calculate the number of occurrence.
 * 1.3. Use RegEx..
 * 1.4. Sort in the DESC mode by the number of occurrence..
 * 1.5. Find  the first 20 pairs.
 * 1.6  Find all the proper names.
 * 1.7.  Count them and arrange in alphabetic order.
 * 1.8.   First 20 pairs and names write into to a file test.txt.
 * 1.9.  Create a fine header for the file.
 * 1.10  Use Java  Collections to demonstrate your experience (Map, List ).
 */
package com.company;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.counting;

public class Main {

    public static void main(String[] args) throws IOException {

        // 1.1. Download a text about Harry Potter.
        /**
         * @param text - to taking our text
         * @return the text into String text
         */
        String text = new String(Files.readAllBytes(Paths.get("C:\\Users\\MyPC\\Desktop\\harry.txt")));

        //System.out.println(text);
        //**********************************

        // 1.3. RegEx
        /**
         * @param cleanedText - RegEx implementing
         * @return cleaned text from some things
         */
        String cleanedText = text.replaceAll("\\.", "")
                .replaceAll(",", "")
                .replaceAll("\"", "")
                .replaceAll("�", "")
                .replaceAll("\\?", "")
                .replaceAll("\\!", "")
                .replaceAll("\\(", "")
                .replaceAll("\\)", "")
                .replaceAll("\\.", "")
                .replaceAll("\\;", "")
                .replaceAll("\\:", "")
                .replaceAll("--", "");

        // splitting it
        String[] words = cleanedText.split(" ");

        // 1.2. For each distinct word in the text calculate the number of occurrence. Upper case matters.
        /**
         * @param Arrays.stream... - to show distinct words and calculate their occurrence
         * @return arrays with words and its number of occurence
         */
        Arrays.stream(words).collect(Collectors
                .groupingBy(Function.<String>identity(), HashMap::new, counting())).entrySet()
                .forEach(System.out:: println);
        //**********************************

        // 1.4. Sort in the DESC mode by the number of occurrence.
        // AND
        // 1.10. Using Map and Streams
        /**
         * @param Map<String, Long> result - to DESC mode by the words occurrence
         * @return sorting DESC of occurrence
         */
        Map<String, Long> result = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.<String>identity(),
                        counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long> comparingByValue().reversed())
                //.limit(20)
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (l,r) -> l,
                        LinkedHashMap::new));

        System.out.println(result);
        //**********************************

        // 1.5. Find  the first 20 pairs.
        // AND
        // 1.10. Using Map and Streams
        /**
         * @param Map<String, Long> result1 - finding the first 20 pairs
         * @return first 20 pairs
         */

        Map<String, Long> result1 = Arrays.stream(words)
                .collect(Collectors.groupingBy(Function.<String>identity(),
                        counting()))
                .entrySet().stream()
                .sorted(Map.Entry.<String, Long> comparingByValue().reversed())
                .limit(20)
                .collect(Collectors.toMap(Map.Entry::getKey,
                        Map.Entry::getValue,
                        (l,r) -> l,
                        LinkedHashMap::new));

        // 1.8.   First 20 pairs and names write into to a file test.txt
        // AND
        // 1.9.  Create a fine header for the file
        /**
         * @param String content - our header
         * @param File f - creating file test.txt
         * @return header with our 20 pairs
         */

        // 20 first to String
        String twenty2 = result1.toString();

        // Creating file and taking there our Header

        try {

            // Our Header
            String content = "This is the HEADER of the file\n"
            + twenty2; // HEADER and our text with occurrence

            // Creating file
            File f = new File("C:\\Users\\MyPC\\IdeaProjects\\src\\com\\company");

            FileWriter fw = new FileWriter(f.getAbsoluteFile());
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(content);
            bw.close();

        } catch (IOException e) {
            e.printStackTrace();
    }

        //-------------Outcome of the file test.txt-------------//
        // This is the HEADER of the file
        // {the=3311, to=1845, and=1799, a=1577, of=1242, was=1178, he=1029, Harry=969, in=933,
        // his=896, it=804, said=789, you=734, had=697, on=617, at=581, that=580, I=537, him=495, as=483}
        //-------------Outcome of the file test.txt-------------//

}
}
