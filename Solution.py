'''
PROBLEM 1

TIME COMPLEXITY: O(number of nodes)
SPACE COMPLEXITY: O(number of nodes)

- push the root into queue
- maintain a size variable to process one level at a time. for a node in one level, push its left and right child into the queue
-  after processing nodes on a level, put them into the result array
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        if root==None:
            return root
        queue=[]
        result=[]
        queue.append(root)
        
        while(len(queue) !=0):
            queueSize=len(queue)
            temp=[]
            for i in range(queueSize):
                parent=queue.pop(0)
                temp.append(parent.val)
                if parent.left!=None:
                    queue.append(parent.left)
                if parent.right!=None:
                    queue.append(parent.right)
            
            result.append(temp)
        return result
        
        

'''
PROBLEM 2

TIME COMPLEXITY: O(number of courses)
SPACE COMPLEXITY: O(number of courses)

- create a hashmap with keys as a course and array of dependencies as value and create an array with index numbers denoting the course and value denoting number of courses it depends on
- go through the array and push indexes in queues that have 0 dependencies
- for every course in queue, get all the dependencies from the hashmaop and reduce their value by 1 in the array, if the value becomes 0, add the course to the queue
- if all the values in array are 0 , return True else return false
'''
class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        if numCourses==1 or numCourses==0:
            return True
        
        #create hashmap and array
        hashmap={}
        array=[0 for i in range(numCourses)]
        queue=[]
        
        for dependency in prerequisites:
            if dependency[1] not in hashmap:
                hashmap[dependency[1]]=[]
            hashmap[dependency[1]].append(dependency[0])
            array[dependency[0]]+=1
        
        print("array",array)
        print("hashmap", hashmap)
        
        for i in range(numCourses):
            if array[i]==0:
                queue.append(i)
        
        while(len(queue)!=0):
            course=queue.pop(0)
            
            if course in hashmap:
                for i in hashmap[course]:
                    array[i]-=1
                    if array[i]==0:
                        queue.append(i)
        for i in array:
            if i!=0:
                return False
        return True

'''
PROBLEM 3

TIME COMPLEXITY: O(number of nodes)
SPACE COMPLEXITY: O(number of nodes)

- traverse the tree using Preorder traversal
- add the root for each level if the length of result array is equal to the level
-  update the value result[level] in array if the length of result array  is greater than the level
'''
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


#DFS TRAVERSAL
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        if root==None:
            return None
        
        self.result=[]
        
        self.dfs(root, 0)
        return self.result
    def dfs(self, root: TreeNode, level):
        if root==None:
            return
        
        if len(self.result)==level:
            self.result.append(root.val)
        else:
            self.result[level]=root.val
            
        self.dfs(root.left, level+1)
        self.dfs(root.right, level+1)
    
'''
PROBLEM 3

TIME COMPLEXITY: O(N)
SPACE COMPLEXITY: O(N/2)= O(N)

- traverse the tree by level order traversal
- for each level, add the last element of the level to the result
-  return result
'''
BFS TRAVERSAL          
        if root==None:
            return None
        result=[]
        queue=[]
        queue.append(root)
        
        while(len(queue)!=0):
            size=len(queue)
            for i in range(size):
                parent=queue.pop(0)
                if i==size-1:
                    result.append(parent.val)
                
                if parent.left!=None:
                    queue.append(parent.left)
                if parent.right!=None:
                    queue.append(parent.right)
        return result
            