# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
	def rightSideView1(self, root: TreeNode) -> List[int]:
		# Time Complexity : O(n) where n is the number of nodes in the tree
		# Accpeted on Leetcode
		if root == None:
			return None
		q = []
		q.append(root) # queue to store the elements visited in the tree in every level
		res = []
		while len(q) > 0:
			temp = [] # to store all the elements in a particular level
			tempq = [] # to store the nodes that are present in the next level
			for i in q:
				temp.append(i.val)
				if i.left != None:
					tempq.append(i.left)
				if i.right != None:
					tempq.append(i.right)
			res.append(temp[-1]) # Append the values of particular level to the result
			q = tempq # Assign the nodes that are present in the next level so that we can iterate over them
		return res

	def rightSideView2(self, root: TreeNode) -> List[List[int]]:
		# Time Complexity : O(n) where n is the number of nodes in the tree
		# Space used by the code is reduced because we are not creating a new queue for every level
		# Accpeted on Leetcode
		if root == None:
			return None
		queue = deque()
		queue.append(root) # queue to store the elements visited in the tree in every level
		res = []
		while len(queue) > 0:
			temp = len(queue) # to store the number of elements at a particular level
			tempList = [] # to store the values of a node present at that level
			for i in range(temp):
				tempNode = queue.popleft()
				tempList.append(tempNode.val)
				if tempNode.left != None:
					queue.append(tempNode.left)
				if tempNode.right != None:
					queue.append(tempNode.right)
			res.append(tempList[-1]) # Append the values of that level to the result
		return res