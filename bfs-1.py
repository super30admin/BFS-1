# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

#Problem 1: Binary Tree Level Order Traversal
#Time Complexity : O(n)
#Space Complexity O(n)
#Did it work on leetcode? Yes

'''
Brute force: Traverse each branch and stop at each level and append the element
to the appropriate array in the result array
'''

'''
BFS traversal, but when we get to the next level we unload the whole queue and save
to an intermediate array, iterate trough the intermediate array and put the children
nodes to the queue. Finally we append the values of the intermediate array to result
array.
'''


class Solution:
    def levelOrder(self, root: TreeNode) -> List[List[int]]:
        #edge case
        if not root:
            return []
        res=[]
        q=collections.deque()
        q.append(root)

        while q:
            intermediate=[]
            while q:
                intermediate.append(q.popleft())

            #next level
            for c in intermediate:
                if c.left:
                    q.append(c.left)
                if c.right:
                    q.append(c.right)
            res.append([r.val for r in intermediate])
        return res



#Problem 2:  Course Schedule
#Time Complexity: O(V+E) V the number of vertices and E the number of edges (in the graph)
#Space Complexity O(n) , n number of courses
'''
Brute force: I take all the combinations of courses and check if they are feasible given the prereqisites.
Test all the sequences.
'''
'''
Idea: Create a graph such that each element point to what class should be taken to be able to
take it. We keep a count for each element of how many classes it's the prerequisite of.
Then when we've visited all the required prerequisite , we put in the stack and add the result count.
For each element in the stack , we visit all the prereq and reduce their counts. If each
prequisites where visited by the number of times they should be visited by, it means
that we were able to take all the classes.Simply put, we've performed BFS traversal (or not anymore)
and if one prereq wasn't visited by all the classes it was a prereq for, it means that we couldn't reach
one of the class. Only if a class hasn't been visited by all of the classes that need it, it becomes a class
that isn't a prereq for anyone.
'''
'''
To understand:
In principle, we want to check for ALL class, if it can create valid paths (to an end) from ALL
its neighbours. To be able to visit one node, we need to be able to visit the parents first. So naturally, we start with the ones
without parents. If there's one node that wasn't visited by all of it's parents, it means
that there's one path that did not contain one of the parents. So for a node to be
considered cleared (so we can continue on our paths), it need to had been visited by
ALL of its parents (So all the parents were reached and cleared before end).
After starting with all the nodes without parents, and the nodes that were cleared after.
If there's one class that is still a prerequisite for a certain parent. It means that
the path parent-class couldn't be reached from a valid path.
'''

class Solution:


    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        #edge case
        if not numCourses or not prerequisites:
            return True

        count=0
        #create graph
        queue=collections.deque()
        graph={i:[] for i in range(numCourses)}
        prereq_of=[0]*numCourses
        for pair in prerequisites:
            graph[pair[0]].append(pair[1])
            prereq_of[pair[1]]+=1


        for i,num in enumerate(prereq_of):
            if num==0:
                queue.append(i)
                #can reach this node from all paths
                count+=1

        while queue:
            root=queue.popleft()
            for i in graph[root]:
                prereq_of[i]-=1
                if prereq_of[i]==0:
                    queue.append(i)
                    count+=1

        return (count==numCourses)





#problem 3: Binary Tree Right Side View
#Time Complexity: O(n) (for each element we will append it, search it)
#Space Complexity: O(n) worse case , for the intermediate array

'''
At each level create an array with the children in order from right to left (including None)
iterate through this array at the next outer loop and a pick the first one that is not None
(furthest from the right).
'''
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        res=[]
        intermediate=[root]
        while any(intermediate):
            temp=[]
            found=False
            for i in range(len(intermediate)):
                if intermediate[i]:
                    temp.append(intermediate[i].right)
                    temp.append(intermediate[i].left)
                    if not found:
                        res.append(intermediate[i].val)
                        found=True
            intermediate=temp
        return res
