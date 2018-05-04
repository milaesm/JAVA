import java.io.BufferedReader;

import java.io.FileReader;

import java.util.Arrays;

public class WordLetterOccurrence {

public static void main(String[] args) {



int countArray[] = new int[26];



Arrays.fill(countArray, 0);

try {



BufferedReader br = new BufferedReader(new FileReader("testFile.txt"));

String line = "";


while((line = br.readLine())!=null) {


String words[] = line.split("[\\s,.]+");

// Iterate for each word in array

for(int i=0;i<words.length;i++) {

// Iterate for each letter in each word

for(int j = 0;j<words[i].length();j++) {

// ch represents current character in lower case

char ch = Character.toLowerCase(words[i].charAt(j));

// index represents ASCII value of character ch

int asciiValue = (int)ch;

// Increment value by 1 at position asciiValue-97 in array

// This is done because

// ASCII value for a-b is 97-122

// So , for ch = a, asciiValue = 97

// So, countArray[asciiValue-97] = countArray[0]

// which represents count of character a at position 0

countArray[asciiValue-97]+=1;

}

}

// Print number of words in current line

System.out.println(words.length+ " words");

// Iterate over countArray

// and check if value at index i is not 0

// (value not 0 , means the character was not present in line)

// If yes, print count and corresponding alphabet

for(int i =0 ;i<26;i++) {

if(countArray[i]!=0) {

System.out.println(countArray[i] +" "+(char)(i+97));

}

}

System.out.println();

// Reset the array to all 0,

// for keeping count of character of next line

Arrays.fill(countArray, 0);

}

br.close();

}catch(Exception e) {

System.out.println("File doesn't exits!!");

}

}

}



