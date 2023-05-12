package sdf;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TextAnalyser 
{
    public static void main( String[] args ) throws IOException
    {
    
        String dirPath = args[0];
        File f = new File(dirPath);
        Map<String, Integer> distribution = new HashMap<>();
        List<String> listofwords = new ArrayList<>();
        Set<String> hash_Set = new HashSet<>();
        File[] authors = f.listFiles((dir, name) -> !name.equals(".DS_Store"));
        for (int i = 0; i < authors.length; i++) {
            File[] authorFiles = authors[i].listFiles();
            System.out.println(authorFiles);
            for (File text : authorFiles) {
                Reader r = new FileReader(text);
                BufferedReader br = new BufferedReader(r);
                String line;
                String word1 = "";
                String word2 = "";
                String key = "";
                while (null != (line = br.readLine())) {
                    // put everything on one line
                    line = line.trim().toLowerCase().replaceAll("\\p{Punct}", "");
                    listofwords.addAll(Arrays.asList(line.split("\\s+")));
                    //handles the tranmission to next line by combining 
                    //last word from previous line with first word of current line
                    }
                    for (int j = 1; j < listofwords.size(); j++) {
                            word1 = listofwords.get(j-1);
                            hash_Set.add(word1);
                            word2 = listofwords.get(j);
                            key = word1 + ":" + word2;
                            int count = distribution.computeIfAbsent(key, (String k) -> 0);
                            distribution.put(key, count + 1);
                            
                }
                //starts a new list of words when theres a new fiel
                listofwords.removeAll(listofwords);
                System.out.print("FILE");
            }
        }
        for (String k: hash_Set) {
            int total = 0;
            System.out.println(k);
            for(String l: distribution.keySet()) {
                if (l.startsWith(k + ":")){
                    total += distribution.get(l);
                }

        }
        for(String m: distribution.keySet()) {
            if (m.startsWith(k + ":")){
                float probability = (float) (distribution.get(m))/total;
                System.out.println("    " + m.replace((k + ":"), "") + " " + probability);
            } 
        }


    }
    
    }
    }

      
