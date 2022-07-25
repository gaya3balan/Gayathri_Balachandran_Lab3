package com.dsalab3.question2.firstapproach.service;

import java.util.HashSet;

class Node {
	int data;
	Node left;
	Node right;
	Node(int data){
		this.data=data;
	}
	
}

public class SumOfPairsInBinarySearchTree {


  static boolean checkNodeSum(Node currentNode, int totalSum, HashSet<Integer> hash){

      if (currentNode == null)
          return false;

      if (checkNodeSum(currentNode.left, totalSum, hash))
          return true;

      if (hash.contains(totalSum - currentNode.data)) {
             System.out.println("Sum = " + totalSum + "\n" + "Pair is (" + (totalSum - currentNode.data) + ","   + currentNode.data + ")");
          
             return true;                               // if the node data matches totalSum minus hash element- it means match is found
                                                         //print the pair and return true
                     }
      else
              hash.add(currentNode.data);                //add elements to hash when hash already does not contain totalSum minus currentNode value       
                                                         //in next recursive call currentNode data will be compared against hash elements 
      
       return checkNodeSum(currentNode.right, totalSum, hash); 
    }
	
  public static void main(String[] args) {
	                                                 //create the BST provided 
		Node root = new Node(40);
		root.left=new Node(20);
		root.left.left=new Node(10);
		root.left.right=new Node(30);
		root.right=new Node(60);
		root.right.right=new Node(70);
		root.right.left = new Node(50);
		                                             
		int sumOfNodes=130;                         //sum of Nodes to be checked 
		
		HashSet<Integer> lookupHash = new HashSet<Integer>();   //create a HashSet for lookup for match
		
		boolean result= checkNodeSum(root,sumOfNodes,lookupHash); // call checkNodeSum method to see if pairs of nodes exist in tree that match the sum passed
                                                                  //also pass the hash in the call to add elements and perform lookup
        if (result == false)
        	 System.out.println("nodes are not found");

   }
  
}




