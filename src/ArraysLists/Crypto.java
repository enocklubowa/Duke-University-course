package ArraysLists;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import edu.duke.FileResource;

public class Crypto {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//FileResource fileResource = new FileResource();
		//String message = fileResource.asString();
		
		//System.out.println(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD! ",21));
		//System.out.println(decrypt(encrypt("At noon be in the conference room with your hat on for a surprise party. YELL LOUD! ",21),21));

		bruteForce();
		//System.out.println(encryptTwoKeys("First Legion", 23, 17));
		FileResource resource = new FileResource("C:\\Users\\Lubowa\\Eclipse projects\\Duke course\\src\\ArraysLists\\lotsOfWords.txt");

		countWordLengths(resource);

		//countWordLengths(resource);
	}
	
	private static String encrypt(String input, int key) {
		StringBuilder encrypted = new StringBuilder(input);
		
		String alphabet1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphabet2 = "abcdefghijklmnopqrstuvwxyz";
		
		String shiftedAlphabet1 = alphabet1.substring(key)+alphabet1.substring(0,key);
		String shiftedAlphabet2 = alphabet2.substring(key)+alphabet2.substring(0,key);

		for(int i=0;i<encrypted.length();i++) {
			char currChar = encrypted.charAt(i);
			int idx;
			if(Character.isUpperCase(currChar)) {
				idx = alphabet1.indexOf(currChar);
				if(idx!=-1) {
					char newChar = shiftedAlphabet1.charAt(idx);
					
					encrypted.setCharAt(i, newChar);
				}
			}
			
			else {
				idx = alphabet2.indexOf(currChar);
				if(idx!=-1) {
					char newChar = shiftedAlphabet2.charAt(idx);
					
					encrypted.setCharAt(i, newChar);
				}
			}
			
			
		}
		return encrypted.toString();
	}
	
	private static boolean isVowel(char ch) {
		String vowels = "A,E,I,O,U";
		if(vowels.contains(String.valueOf(Character.toUpperCase(ch)))) {
			return true;
		}
		return false;
	}
	
	private static String replaceVowels(String phrase, char ch) {
		StringBuilder builder = new StringBuilder(phrase);
		for(int i=0;i<phrase.length();i++) {
			if(isVowel(phrase.charAt(i))) {
				builder.setCharAt(i, ch);
			}
		}
		return builder.toString();
	}
	
	private static String emphasize(String phrase, char ch) {
		StringBuilder builder = new StringBuilder(phrase);
		int idx = phrase.indexOf(ch);
		if(idx != -1) {
			for(int i = 0; i<phrase.length();i++) {
				char currCur = phrase.charAt(i);
				if(currCur==ch && (i+1)%2 == 0) {
					builder.setCharAt(i, '+');
				}
				else if(currCur==ch && (i+1)%2!=0) {
					builder.setCharAt(i, '*');
				}
			}
		}
		return builder.toString();
	}
	
	private static String encryptTwoKeys(String input, int key1, int key2) {
		StringBuilder builder = new StringBuilder("");
		for(int i=0;i<input.length();i+=2) {
			builder.append(encrypt(String.valueOf(input.charAt(i)), key1));
			builder.append(encrypt(String.valueOf(input.charAt(i+1)), key2));
		}
		return builder.toString();
	}
	
	private static void countShakes() {
		String[] plays = {"romeo.txt"};
		
		String[] common = getCommon();
		int[] counts = new int[common.length];
		for(int k=0;k<plays.length;k++) {
			FileResource resource = new FileResource("C:\\Users\\Lubowa\\Eclipse projects\\Duke course\\src\\ArraysLists\\"+plays[k]);
			counts = countWords(resource, common);
			System.out.println("done with "+plays[k]);
		}
		
		//for(int k = 0; k<common.length;k++) {
			//System.out.println(common[k]+"\t"+counts[k]);
		//}
	}
	
	private static int[] countWords(FileResource resource, String[] common) {
		int[] count = new int[common.length];
		for(String s : resource.words()) {
			for(int i = 0;i<common.length;i++) {
				if((s.toLowerCase()).equals(common[i])) {
					count[i]++;
				}
			}
		}
		
		
		for(int i=0;i<common.length;i++) {
			System.out.println(common[i]+"\t"+count[i]);
		}
		
		return count;
	}
	
	private static String[] getCommon() {
		FileResource resource = new FileResource("C:\\Users\\Lubowa\\Eclipse projects\\Duke course\\src\\ArraysLists\\common.txt");
		String[] common = new String[20];
		int index = 0;
		for(String s : resource.words()) {
			common[index] = s;
			index++;
		}
		return common;
	}
	
	private static void countWordLengths(FileResource resource) {
		List<Integer> counts = new ArrayList<Integer>();
		for(String s:resource.words()) {
			if(!Character.isLetter(s.charAt(0)) && !Character.isLetter(s.charAt(s.length()-1))) {
				counts.add(s.length()-2);
			}
			else if(!Character.isLetter(s.charAt(0))) {
				counts.add(s.length()-1);
			}
			else if(!Character.isLetter(s.charAt(s.length()-1))) {
				counts.add(s.length()-1);
			}
			else {
				counts.add(s.length());
			}
		}
		System.out.println(counts);
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(Integer i:counts) {
			int inc = 0;
			map.put(i,inc);
			for(Integer j:counts) {
				if(i==j) {
					map.replace(i, (map.get(i))+1);
				}
			}
		}
		System.out.println(map);

	}
	
	private static void bruteForce() throws IOException {
		/*
		for(int i =0;i<26;i++) {
			decrypt("Vo ijji wz di ocz xjiazmzixz mjjh rdoc tjpm cvo ji ajm v npmkmdnz kvmot. TZGG GJPY! \r\n" + 
					"", i);
		}
		*/
		FileResource resource = new FileResource("C:\\Users\\Lubowa\\Eclipse projects\\Duke course\\src\\ArraysLists\\mysteryTwoKeysPractice.txt");

		int index =0;
		
		String message = "Top ncmy qkff vi vguv vbg ycpx";
		for(int i =0; i<26;i++) {
			for(int j=0;j<26;j++) {
				decryptTwo(message, i, j);
				index++;
			}
		}
		System.out.println("The total is "+index);
	}
	
	private static String decrypt(String input, int key) {
		StringBuilder encrypted = new StringBuilder(input);
		
		String alphabet1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String alphabet2 = "abcdefghijklmnopqrstuvwxyz";
		
		String shiftedAlphabet1 = alphabet1.substring(key)+alphabet1.substring(0,key);
		String shiftedAlphabet2 = alphabet2.substring(key)+alphabet2.substring(0,key);

		for(int i=0;i<encrypted.length();i++) {
			char currChar = encrypted.charAt(i);
			int idx;
			if(Character.isUpperCase(currChar)) {
				idx = alphabet1.indexOf(currChar);
				if(idx!=-1) {
					char newChar = shiftedAlphabet1.charAt(idx);
					
					encrypted.setCharAt(i, newChar);
				}
			}
			
			else {
				idx = alphabet2.indexOf(currChar);
				if(idx!=-1) {
					char newChar = shiftedAlphabet2.charAt(idx);
					
					encrypted.setCharAt(i, newChar);
				}
			}
			
			
		}
		System.out.println(encrypted.toString());
		return encrypted.toString();
	}
	
	private static String decryptTwo(String input, int key1, int key2) throws IOException {
		StringBuilder builder = new StringBuilder("");
		for(int i=0;i<input.length();i+=2) {
			builder.append(encrypt(String.valueOf(input.charAt(i)), key1));
			builder.append(encrypt(String.valueOf(input.charAt(i+1)), key2));
		}
		// resource = new FileResource("C:\\Users\\Lubowa\\Eclipse projects\\Duke course\\src\\ArraysLists\\mysteryTwoKeysPractice.txt");

		String message = builder.toString()+" With keys "+key1+" and "+key2;
		BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\Lubowa\\Eclipse projects\\Duke course\\src\\ArraysLists\\small.txt", true));
	    writer.append(' ');
	    writer.append(message);
	     
	    writer.close();
		return builder.toString();
	}

}




















