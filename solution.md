# Problem 1
## Time Complexity :
O(n)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
Yes. Should I create a seperate class to create a queue, or is it okay to just import the library in python. In this problem, I have imported the queue library. Or can I use list as queue?

## Your code here along with comments explaining your approach
### Solution 1: BFS.
        import queue
        class Solution:
            def levelOrder(self, root: TreeNode) -> List[List[int]]:
                #Initializing lists and queue
                result=[]
                q = queue.Queue()
                #Edge case
                if not root:
                    return result
                #Adding the root in queue
                q.put(root)
                while not q.empty():
                    # size=q.qsize
                    temp=[]
                    for i in range(q.qsize()):
                        curr = q.get()
                        temp.append(curr.val)
                        if(curr.left!=None):
                            q.put(curr.left)
                        if(curr.right!=None):
                            q.put(curr.right)
                    result.append(temp)
                return result

# Problem 2
## Time Complexity :
O(n)

## Space Complexity :
O(h)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

## Your code here along with comments explaining your approach
### Solution 1: BFS.
        import queue
        class Solution:
            def rightSideView(self, root: TreeNode) -> List[int]:
                result=[]
                #Edge Case
                if not root:
                    return result
                q=queue.Queue()
                q.put(root) #Add root in queue
                #Condition 
                while not q.empty():
                    last=0
                    for i in range(q.qsize()):
                        curr=q.get()
                        last=curr.val
                        if curr.left!=None:
                            q.put(curr.left)
                        if curr.right!=None:
                            q.put(curr.right)
                    result.append(last)
                return result
                
# Problem 2
## Time Complexity :
O(n)

## Space Complexity :
O(h)

## Did this code successfully run on Leetcode :
No.\
NameError: name 'result' is not defined.

## Any problem you faced while coding this :
Yes. I have initialized global variable result. I even tried to access the global variable using global keyword, inside the function.

## Your code here along with comments explaining your approach
### Solution 2: DFS.
            class Solution:
                result=[]
                def rightSideView(self, root: TreeNode) -> List[int]:
                    #Edge Case
                    if not root:
                        return result
                    self.dfs(root,0)
                    return result 

                def dfs(self,root: TreeNode, depth):
                    #Base Case
                    if not root:
                        return result
                    #Logic
                    if(depth==len(result)):
                        result.append(root.val)
                    self.dfs(root.right,depth+1)
                    self.dfs(root.left,depth+1)

  
# Problem 3
## Time Complexity :
O()

## Space Complexity :
O()

## Did this code successfully run on Leetcode :


## Any problem you faced while coding this :


## Your code here along with comments explaining your approach
### Solution:
