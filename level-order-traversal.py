# Initialize a queue and append the initial root to it. While the queue is not empty,
#  find the size of the queue and initialize list l with None of size of the queue.
#  Until the size of the queue, run a loop where the elemetns are popped from the queue and added
#  into the last avaialble spot of l and then append the left and right of the element to
#  the queue. Append the list l to the result.

#  Time complexity: O(n)
#  Space complexity:O(n)



# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[List[int]]

        """
        
        q=deque()
        if root==None:
            return []
        q.append(root)
        result=[]
        l=[None]
        
        while q:
            # print("-----",q,"++")
            size=len(q)
            l=[None for i in range(size)]
            for i in range(size):
                q_pop=q.popleft()
                
                l[i]=q_pop.val
                # print(q_pop)
                if q_pop.left:
                    q.append(q_pop.left)
                if q_pop.right:
                    q.append(q_pop.right)
            result.append(l)

        return result
            
        

# Using DFS
# Initialize global variable for level and list. In recursion, check if root is null,
#  if so return. Else check if len(l)<level, if it is , append list l with a new list 
#  containing the the root.val else add the root value at the end of l[level]

Time complexity: O(n)
Space conplexity: O(n)

# Definition for a binary tree node.
# class TreeNode(object):
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution(object):
    def levelOrder(self, root):
        """
        :type root: Optional[TreeNode]
        :rtype: List[List[int]]
        """
        level=0
        l=[]
        self.helper(root,level,l)
        return l
        

    def helper(self, root, level, l):
        if root==None:
            return

        if len(l)-1<level:
            l.append([root.val])
        else:
            l[level].append(root.val)



        self.helper(root.left, level+1, l)
        


        self.helper(root.right,level+1,l)
        