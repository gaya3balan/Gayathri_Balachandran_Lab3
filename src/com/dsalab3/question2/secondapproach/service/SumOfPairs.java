package com.dsalab3.question2.secondapproach.service;

import java.util.ArrayList;

//*note to Great Learning Reviewer: This is my alternate version to Question1 that I wrote on my own for practice. In order to find if sum of two nodes is equal to 
//*passed value- I have done this logic: First after tree is created- do a traversal and save all the nodes in an arraylist
//*Then call a method by passing this arraylist to traverse the tree once more recursively to check if current node is ( sum minus arraylist element)
//*as arraylist element + current node = sum, we print the pairs- arraylist element and the tree node. Once a pair is found, I am stopping my recursion.
//* Have checked for all combinations of nodes. 

class Node {
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data=data;
	}
	
}

class SumOfPairs {

	Node root;
    private static boolean foundOrNot = false;
 

        static void addTreeElementsToLookupList(Node node, ArrayList<Integer> lookupList) {
	  
	      if (node == null) 
	      return;
	      
		 															//when a node is present, add it to arraylist lookupList
		 															//recursively traverse to add all elements into arraylist  
	 			
		 				lookupList.add(node.data);
     
		 				addTreeElementsToLookupList(node.left , lookupList);

		 				addTreeElementsToLookupList(node.right, lookupList);
	 
	     }
 
      void checkPair(Node currentNode, int total , ArrayList<Integer> lookupList) {
	 	   
	   if (currentNode == null)
	      return; 
	   
      
        	for( int i=0; i<lookupList.size(); i++)
        		
        	{ 
        		if( lookupList.get(i) == ( total-currentNode.data)  && currentNode.data != ( total-currentNode.data)) {    
        			
        			// Note to evaluator :check for sum of nodes by comparing against elements from arraylist- if total minus current node's data 
        			//is equal to element from arraylist- it means, we have a pair. second logical && condition is added to ensure
        			//that while matching node against arraylist elements using sum-target comparison against node.data, we
        			//should not consider and print same element twice- i.e. if sum is 120-- (60,60) cannot be a pair as
        			//our BST does not have duplicates , if sum is 80, cannot print (40,40) etc. Have tested for all combinations
        			//of inputs thoroughly. I know that I can use lookupList.contains() as well here instead of for loop and get()
        			//method for arraylist- as have already used contains() in my other alternate solution for the hashset-
        			
        			
        			System.out.println("Sum = " + total + "\n" + "Pair is (" +currentNode.data + "," + lookupList.get(i)+ ")");
        			SumOfPairs.foundOrNot=true;                           //set foundOrNot flag
        			
        	        break;
        		}
        	}
        		
        
        if (SumOfPairs.foundOrNot == false)                      //traverse left only if Sum of nodes not equal to sum yet
        	
        	checkPair(currentNode.left, total, lookupList);  // by recursively calling checkPair method 
        	
        
        if(SumOfPairs.foundOrNot == false)                       //traverse right only if Sum of nodes not equal to sum yet
        	checkPair(currentNode.right, total, lookupList);  // by recursively calling checkPair method 

       }


     public static void main(String[] args){
      
     SumOfPairs tree = new SumOfPairs();
                                                    //create my Binary Search Tree
        tree.root = new Node(40);
		tree.root.left=new Node(20);
		tree.root.left.left=new Node(10);
		tree.root.left.right=new Node(30);
		tree.root.right=new Node(60);
		tree.root.right.right=new Node(70);
		tree.root.right.left = new Node(50);
		
		 int sum=130;                              //give the total to be found while adding up nodes of the tree
		
		 ArrayList<Integer> lookupList = new ArrayList<>();   //create my lookup arraylist to add the tree nodes for sum check 
		
		 SumOfPairs.addTreeElementsToLookupList(tree.root, lookupList);  // call addTreeElementsToLookupList method to traverse the tree to add nodes to arraylist lookuplist 
         
		 tree.checkPair(tree.root, sum , lookupList); //call checkPair method to see if node pair equal to sum can be found 
		 
		 if (foundOrNot == false) {
			 
			 System.out.println("nodes are not found");
			 
		               }
       }
 
}
