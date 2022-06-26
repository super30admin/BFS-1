#Time complexity : O(n) i.e. n is the number of nodes in the tree
#Space complexity : O(h) i.e. for the recursion stack where h is the height of the tree
#Did this code successfully run on Leetcode : No it is showing wrong result when submitted but if same test case is tested at run time it is giving correct result
#youtube : https://www.youtube.com/watch?v=JW2KxAHFqv8&ab_channel=%7BS30%7D
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    result =[]
    def levelOrder(self, root: Optional[TreeNode]) -> List[List[int]]:
        #when root is none then it return empty list
        if root == None:
            return self.result
        #calling the dfs recursion function from the root node and maintaining the level for aapending the value of the node at each level
        self.dfs(root,0)
        return self.result
    def dfs(self, root: TreeNode, level :int):
        #base condition
        if root == None:
            return
        #logic 
        #check the size of the result and if the list belong to the level check it snf then if not then start an empty list in the result
        if len(self.result) == level:
            self.result.append([])
        #append the value of the current root in result according to the level it belong to
        self.result[level].append(root.val)
        #calling the left sub part and right subpart and increasing the level each time
        self.dfs(root.left, level+1)
        self.dfs(root.right, level+1)
