#Problem1: Reorder List

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''
Traversing the tree level by level
Maintaining the size of the queue for every level
At every level adding the value of the nodes to a list and combining it with the final list
'''



# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        List1 = []
        Queue = []
    
    
    
        if root is None:
            return List1
        Queue.append(root) # adding root calue to the queue
    
        while(Queue!=[]):
            size = len(Queue) # finding the size of the queue
            # if size==0:
            #     break
            temp = []
            for i in range(size): 
                
                a= Queue.pop(0) # popping the element out of the queue
                temp.append(a.val) # adding the value into a temp list
                
                if(a.left is not None): # adding the children nodes to the queue
                    Queue.append(a.left)
                if(a.right is not None):
                    Queue.append(a.right)
            List1.append(temp)  # adding the temp list to the final list
        return List1
###############################################################################################

# Problem 2: Course Scheduler

# Time Complexity : O(vertices* edges)
# Space Complexity : O(vertices + edges)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''

Taking in indgree array to find the number of dependencies each subject has
Maintaining a hash map for each course and the course dependent on that particular course
Taking the independent courses first and perfoming Breadth first search
reducing the dependency of the course dependent on the independent course
if the dependency = 0 then the courses with dependency are pushed into the queue
'''

class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        """
        indegree = []
        dict = {}
        
        for i in range(len(prerequisites)):
            indegree.append(prerequisites[i][0])
        # print(indegree)
            if(prerequisites[i][1] not in dict.keys()):
                dict.update({prerequisites[i][1]:[]}) 
            # print(dict)
            dict.update({prerequisites[i][1]: [prerequisites[i][0]]}) # maintaining a hash map
        # print(dict)
        Queue = []
        
        for i in range(len(indegree)):
            if(i==0):
                Queue.append(i)
        while(Queue!=[]):
            course = Queue.pop(0)
            children = dict.get(course)
            
            if(children is not None ):
                for child in range(len(children)):
                    indegree[child]-=1
                    if(indegree[child] == 0): # if the dependency of the dependent course become 0 the they are pushed in the queue
                        Queue.append(child)
        for i in range(len(indegree)): # if there is any course left then return false
            if(indegree[i]> 0):
                return False
        return True
##########################################################################################

#Problem 3: Binary tree right side view (BFS)

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''
Traversing the tree level by level 
for every level adding the right node first in the queue and then the left node
Once right node is found append its value in the list
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        List1 = []
        Queue = []
        
        if root is None:
            return List1
        
        Queue.append(root) # adding root to the queue
        
        while(Queue!=[]):
            size = len(Queue) # maintaining the level
            for i in range(size): 
                a = Queue.pop(0)
                if(i==0): # if right node is found add it to the list
                    List1.append(a.val)
                if(a.right!= None):
                    Queue.append(a.right) # adding right node into the queue first
                if(a.left!= None):
                    Queue.append(a.left)
        return List1

#Problem 3: Binary tree right side view (DFS)

# Time Complexity : O(n)
# Space Complexity : O(h)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No


# Your code here along with comments explaining your approach

'''
Traversing the tree depth wise
taking an empty list and checking if the depth = len of list
if true add the rightmost node value in the list
Calling the recursive function
'''

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution(object):
    
    List1 = []
    
    def rightSideView(self, root):
        """
        :type root: TreeNode
        :rtype: List[int]
        """
        # global List1
        self.dfs(root,0)
        return self.List1
    
    def dfs(self, root,depth):
        
        # global List1
        
        if(root is None):
            return
        
        
        #logic

        # if depth == length add the right element to the list
       
        if(len(self.List1) == depth):
            self.List1.append(root.val)
        self.dfs(root.right, depth+1)
        self.dfs(root.left, depth+1)
        
    
            
        
            
                
                        
        




            