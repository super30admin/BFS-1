"""
 FAANMG Problem #57 {Easy}

102. Binary Tree Level Order Traversal

Time Complexity : O(N)


Space Complexity : O(N)


Did this code successfully run on Leetcode : Yes
  
BFS

We will start by pushing the root node into the queue and start a loop till the queue 
becomes empty.

For each node of the tree at any arbitrary level, 
    we will first visit that node from the queue and pop it off. 
    Then we push its left and then right children (since we are required to traverse from left to right) 
    into the queue. 
    
This process will repeat for each level of binary tree.

In a normal binary tree BFS traversal, the above simple process would suffice but here, 
we are required to distinguish between each level and group all nodes of a level into different vectors. 

For this, we will use another inner loop. 
We will take the size of queue and iterate the above process n times. 
The only addition here would be - with each pop from the queue, 
    we will also push that node into curLevel array denoting all nodes on current level.
    
    
In the above process, after n iterations, 
we have basically visited all the nodes on the current level and pushed all the nodes (from left-to-right) of the next level into the queue, 
thus preparing us to traverse the next row as well. This above process will repeat till the queue becomes empty 

@name: Rahul Govindkumar_RN27JUL2022
"""

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
        result = []
        if(root==None):
            return result
        #BFS Approach
        q = collections.deque()
        
        q.append(root)
        
        while(q):
            #To iterate through One level at a time
            qLen = len(q)
            
            level = []
            
            #Loop through every value in the queue
            for i in range(qLen):
                
                node = q.popleft()
                
                if node:
                    level.append(node.val)
                    
                    #Adding children to the queue
                    q.append(node.left)
                    q.append(node.right)
            
            if level:
                result.append(level)
                
        return result


"""
 FAANMG Problem #57 {Easy}

102. Binary Tree Level Order Traversal

Time Complexity : O(N)


Space Complexity : O(H)


Did this code successfully run on Leetcode : Yes
  
DFS - Recursion

We would need to maintain a depth variable that tells us the current depth we are at. 

This allows us to push the current node into the result vector at its correct depth (result[depth]).
At each depth, 
    if this is the first time we are visiting this deep, 
    then push an empty vector into result. 
    
    This would allow us to index the current depth and push the node into ans at its correct depth. 
    
Then continue with the DFS traversal as usual.

@name: Rahul Govindkumar_RN27JUL2022
"""                    

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
    def __init__(self):
        self.result=[]
        
    def dfs(self, root, depth):
        
        #base
        if not root:
            return
            
        #logic
        if(depth == len(self.result)):
            self.result.append([])
            
        self.result[depth].append(root.val)
        
        self.dfs(root.left, depth + 1)
        self.dfs(root.right, depth + 1)
        
        
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
   
        
        if(root==None):
            return self.result
        
        
        #DFS Approach
        self.dfs(root, 0)
        
        return self.result
                    
                   
                
"""
 FAANMG Problem #57 {Easy}

102. Binary Tree Level Order Traversal

Time Complexity : O(N)


Space Complexity : O(H)


Did this code successfully run on Leetcode : Yes
  
DFS - Iterative



@name: Rahul Govindkumar_RN27JUL2022
"""                  
        
        
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    
         
        
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        
   
        result=[]
    
        if(root==None):
            return result
        
        
        #DFS Approach
        st = collections.deque()
        depth_st = collections.deque() 
        
        st.append(root)
        depth_st.append(0)
        
        while(st):
            curr = st.pop()
            depth = depth_st.pop()
            
            if(depth == len(result)):
                result.append([])
            
            result[depth].append(curr.val)
            
            if(curr.right):
                st.append(curr.right)
                depth_st.append(depth +1)
                
            if(curr.left):
                st.append(curr.left)
                depth_st.append(depth +1)
        
        
        return result
                    
                   
                
                
                