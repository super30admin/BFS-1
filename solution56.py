#Time Complexity:O(n)
#Space Complexity:O(1)

#Breadth First Search

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        result=[]                                               #declaring the output array
        if not root:                                            #if tree is empty return result
            return result
        d=deque()                                               #declaring a queue
        d.append(root)                                          #appending the root into the queue
        while(d):                                               #while the the queue is not empty
            temp=[]                                             #create a temp array
            l=len(d)                                            #obtain the number of elements in the queue
            for r in range(l):                                  #for every element currently in the dequeue
                curr=d.popleft()                                #Pop the first element of the queue
                temp.append(curr.val)                           #append the current node value to the temp array
                if curr.left:                                   #if left node exists append to queue
                    d.append(curr.left)                         
                if curr.right:                                  #if left node exists append to queue
                    d.append(curr.right)
            result.append(temp)                                 #append the temp array to result
        return result                                           #return the final output array

#Depth First Search

class Solution:
    global result                                                   #create a global output array
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        self.result=[]                                              #create the array
        if not root:                                                #if the root is null
            return self.result                                      #return the output array
        self.dfs(root,0)                                            #call dfs recursive function
        return self.result                                          #returning the output array
    
    def dfs(self,root:TreeNode, Level:int)->None:
        if not root:                                                #if the root is null return
            return
        if Level==len(self.result):                                 #if the level number  is same as length of result append empty array in result
            self.result.append([])
        self.result[Level].append(root.val)                         #in the current level position append the value of node
        self.dfs(root.left,Level+1)                                 #recursive call the dfs for left node with next level number
        self.dfs(root.right,Level+1)                                #recursive call the dfs for result node with next level number