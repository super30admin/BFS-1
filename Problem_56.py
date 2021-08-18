class Solution(object):

	def levelOrder(self, root: TreeNode) -> List[List[int]]:

		if root == None:

			return None

		queue = deque()

		queue.append(root) 
		res = []

		while len(queue) > 0:

			temp = len(queue) 

			tempList = [] 

			for i in range(temp):

				tempNode = queue.popleft()

				tempList.append(tempNode.val)

				if tempNode.left != None:

					queue.append(tempNode.left)

				if tempNode.right != None:

					queue.append(tempNode.right)

			res.append(tempList) 

		return res

# TC: O(n) 
# SC : O(n)