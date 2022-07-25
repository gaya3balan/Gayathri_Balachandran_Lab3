package com.dsalab3.question1.firstapproach.service;

import java.util.Stack;

public class BalancingBrackets {
	
	static boolean findIfStringIsBalanced(String input) {
		boolean returnValue= false;
		
		if(input.length()% 2 !=0 )  //if length is not even- brackets are anyway unbalanced 
			returnValue=false;
		
		Stack<Character> bracketsStack = new Stack<>();
		
		
		for(int index = 0; index < input.length(); index++) {
			
			char readChar = input.charAt(index);
			
			//adding all left braces into stack
			if (readChar =='{' ||readChar =='[' || readChar=='('  ) {
				bracketsStack.add(readChar);	
				continue;
			}
			
			if (bracketsStack.isEmpty()){
				returnValue=false;
				break;	
				
			}
			
			char popChar=bracketsStack.pop();
			
			//when we encounter any set of closed braces
			if(readChar=='}' ) {
				
				if (popChar=='{') 
					returnValue=true;
				else {
					returnValue=false;
				    break;
				}
			}
			
			if(readChar==']') {
				
				if (popChar=='[')
					returnValue=true;
				else {
					returnValue=false;
					break;
				}
			}
			
			if(readChar==')') {
				
				if (popChar=='(')
					returnValue=true;
				else {
					returnValue=false;
					break;
					
				}
				
			}
			
		}
		
		if (bracketsStack.isEmpty()== false) {
			returnValue=false;   // this is to prevent scenarios where we have any extra left braces that are not yet popped ([]){[( 
		}                     //eventually making it unbalanced. So we add this check here 
				
		return returnValue;
	}

public static void main(String args[]) {
	String braces = "([[{}]])";
	
	if(findIfStringIsBalanced(braces)) {
		System.out.println("The entered String has Balanced Brackets");
	}
	else {
		System.out.println("The entered Strings do not contain Balanced Brackets");
	}
}

}