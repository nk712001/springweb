package com.example.springweb;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public static void main(String[] args) {
        boolean si = isAnagram("slkmksms");
        System.out.print(si);

    }

    public static boolean isAnagram(String s) {
        Map<Character,Integer> item =new HashMap<>();
            item.put('I', 1);
            item.put('V', 5);
            item.put('X', 10);
            item.put('L', 50);
            item.put('C', 100);
            item.put('D', 500);
            item.put('M', 1000);

item.size();
        System.out.println(item.get('I'));
//        char[] first = s.toCharArray();
//        char[] second = t.toCharArray();
//        Arrays.sort(first);
//        Arrays.sort(second);
//        return Arrays.equals(first, second);
//        for (int i = 0; i < first.length; i++) {
//            System.out.println(first[i] + "----kmalm---" + first[i+1]+"----+"+i++);
//
//            if (first[i] < first[i++]) {
//                System.out.println(first[i]);
//            }
//        }
        return true;
    }
}