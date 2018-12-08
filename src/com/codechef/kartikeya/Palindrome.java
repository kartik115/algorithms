package com.codechef.kartikeya;

public class Palindrome {
	
	boolean isPalindrome(String s) {
		Boolean flag = true;
		int len  = s.length();
		String s1 = s.toLowerCase();
		for(int i=0; i<(len/2); i++) {
			if (s1.charAt(i) == s1.charAt(len-i-1)){
				continue;
			}
			else {
				flag = false;
				break;
			}
		}
		return flag;
	}
	
//	void postOrderTraversal(Node node) {
//		if (node == null)
//			return ;
//		
//		postOrderTraversal(node.left);
//		postOrderTraversal(node.right);
//		
//		System.out.println(node.data);
//		
//	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	}

}
