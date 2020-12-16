# As taught in the class, if the level of node and length of final array is equal, then I append the element to result array, else I replace it. I keep trversing the tree recursively to traverse all nodes.
#Time Complexity: O(n)
#Space Complexity: O(h)
class Node:
    def __init__(self,val):
        self.val = val
        self.left = None
        self.right = None
class Solution:
    def __init__(self):
        self.result = list()

    def rightView(self,root):
        if root is None:
            return self.result
        self.dfs(root,0)

    def dfs(self,root,level):
        if root is None:
            return
        if level == len(self.result):
            self.result.append(root.val)
        else:
            self.result[level] = root.val
        self.dfs(root.right,level+1)
        self.dfs(root.left,level+1)

n1 = Node(1)
n2 = Node(2)
n3 = Node(3)
n4 = Node(4)
n1.left = n2
n1.right = n3
n2.right = n4
s = Solution()
s.rightView(n1)
print(s.result)