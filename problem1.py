#time complexity: O(n)
#space complexity: O(n)
#ran on leetcode: Yes
#initialize a queue with root. To get elements in each level, pop out n elements from the queue at each iteration where n= size of queue at the start of the iteration. Continue iteration till elements are present in the queue.
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        i=0
        #print(root)
        ans=[]
        k=0
        #1,2,4,8,16
        lim=1
        Q=[]
        vals=[]
        L=[]
        #Q.append(root)
        if(root!=None):
            #vals.append(root)
            Q.append(root)
            Q.append(None)
        else:
            return []
        
        flag=True
        k=0
        j=0
        while((j==0)or(Q[j]!=None or Q[j-1]!=None)):
            #print("HERE")
            curr=Q[j]
        
            if(curr==None):
                ans.append(L)
                #print(L)
                L=[]
                Q.append(None)
                j=j+1
                #vals.append(None)
                #vals.append(None)
            else:
                j=j+1
                L.append(curr.val)
                if(curr.left!=None):
                    #L.append(curr.val)
                    Q.append(curr.left)
                    #vals.append(curr.left)    
                if(curr.right!=None):
                    #L.append(curr.val)
                    Q.append(curr.right)
                    #vals.append(curr.right)
                

                    
        
        
        return ans
