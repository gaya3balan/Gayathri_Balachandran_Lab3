package com.dsalab3.question1.secondapproach.service;

import java.util.HashMap;
import java.util.Stack;

public class CheckForBalancingBracekts {
	
	//*Note to Great Learning reviewer: This is my alternate version to Question 1 that I wrote on my own for practice. As we are covering Data Structure lab sessions- have used hashmap as a lookup for matching braces.
    //logic is -use a for loop to read characters of the string- push all left braces into a stack. As and when right braces are encountered while reading string
	//check against hashmap by passing right brace as key to see if the popped character from stack is the corresponding left brace
	//In the end stack should be empty and all characters should be read for the expression to be balanced.


     public static boolean checkBalancedBrackets(String input) {
		
		if ( input.length() % 2 != 0)  //if length is not even- brackets are anyway unbalanced 
			return false;

		HashMap<Character, Character> lookupHash = new HashMap<Character, Character>();  //create a hashmap of brackets
		lookupHash.put(')', '(');   // we will compare current character against popped character from stack for matching braces  
		lookupHash.put(']', '[');   //hence creating an instance of HashMap
		lookupHash.put('}', '{');    

		Stack<Character> stackOfBrackets = new Stack<Character>();  //create a stack to store left braces 
		
				for(int index = 0; index < input.length(); index++) {
					
					char readChar = input.charAt(index);  //read character from string
					
					//adding all left braces into stack
					if (readChar =='{' ||readChar =='[' || readChar=='('  ) {   
						stackOfBrackets.push(readChar);	   //push any left braces read into stack
						continue; 
					}
					
					char poppedChar =stackOfBrackets.pop();
					
					//If we encounter any right brace, compare with hashmap to see if the popped character is the key Value of the corresponding right brace
		           
					switch(readChar) {
					
					case '}' : 
					
							if (poppedChar !=lookupHash.get(readChar)) 
							return false;
						    break;
						          
					
					
					case ']' :
						
							if (poppedChar!=lookupHash.get(readChar))
							return false;
							break;
							
					
					case ')' :
						
						if (poppedChar!=lookupHash.get(readChar))
							return false;
							break;	
						
					
					}
					
				}
				
				
				return stackOfBrackets.isEmpty();  //once all left braces are popped out and exact right brace match is found stack will be empty
			}                                      //once stack is empty-the isempty check will return true 
                                                   //this is the source of setting if brackets are balanced or not- stack should be empty
                                                 //even if one of the braces is unbalanced and stack is not empty- braces are not balanced


     public static void main(String[] args) {
 		String stringToCheckForBalancedBrackets = "([[{}]])";
 		if (checkBalancedBrackets(stringToCheckForBalancedBrackets))
 			System.out.println("The entered String has Balanced Brackets");
 		else
 			System.out.println("The entered Strings do not contain Balanced Brackets");
 	      }
     
     
}