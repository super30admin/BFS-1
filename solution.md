# Problem 1
## Time Complexity :
O(n)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
No.

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

# Problem 1
## Time Complexity :
O(n)

## Space Complexity :
O(1)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
Yes. I had problem with initializing variable globally and using it inside the function. So, after a few attempts, I created the function inside the function.

## Your code here along with comments explaining your approach
### Solution 2: DFS.
        class Solution:
            def levelOrder(self, root: TreeNode) -> List[List[int]]:
                def helper(root: TreeNode,level):
                    #Base Case
                    if not root:
                        return self.result
                    #Logic
                    if len(self.result)==level:
                        self.result.append([])
                    self.result[level].append(root.val)    
                    helper(root.left,level+1)
                    helper(root.right,level+1)
                self.result=[]
                #Edge case
                if not root:
                    return self.result
                helper(root,0)
                return self.result
    
                
# Problem 2
## Time Complexity :
O()

## Space Complexity :
O()

## Did this code successfully run on Leetcode :


## Any problem you faced while coding this :


## Your code here along with comments explaining your approach
### Solution:




# Problem 3
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
                
# Problem 3
## Time Complexity :
O(n)

## Space Complexity :
O(h)

## Did this code successfully run on Leetcode :
Yes.

## Any problem you faced while coding this :
Yes. Yes. I had problem with initializing variable globally and using it inside the function. So, after a few attempts, I created the function inside the function.

## Your code here along with comments explaining your approach
### Solution 2: DFS.
        class Solution:

            def rightSideView(self, root: TreeNode) -> List[int]:
                def dfs(root: TreeNode, depth):
                    #Base Case
                    if not root:
                        return self.result
                    #Logic
                    if(depth==len(self.result)):
                        self.result.append(root.val)
                    dfs(root.right,depth+1)
                    dfs(root.left,depth+1)
                self.result=[]
                #Edge Case
                if not root:
                    return self.result
                dfs(root,0)
                return self.result 
