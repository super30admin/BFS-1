Binary Tree Level Order Traversal


Approach 1: BFS

create an empty queue
add the root in a queue
Loop while queue is not empty
	-> iterate through the size of this queue
 -> poll the first element from queue into temp
 -> add it to array list
 -> add its left & right child to queue
 
 
 Time Complexity: O(n)
 Space Complexity: O(n)
 
 
 Approach 2: Recursion
 
  Time Complexity: O(n)
 Space Complexity: O(n)
