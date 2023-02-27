"""
Rasika Sasturkar
Time Complexity: O(n), n is total no. of elements
Space Complexity: O(h), h is max. height of the tree
"""

from collections import deque


class TreeNode:
    def __init__(self, val=0, left=None, right=None):
        """
        tree node constructor
        """
        self.val = val
        self.left = left
        self.right = right


def createTree(array_order, index, n):
    """
    Used for constructing a binary tree.
    """
    if array_order is None:
        return None
    root = None
    if index < n and array_order[index] is not None:
        root = TreeNode(val=array_order[index])
        root.left = createTree(array_order, 2 * index + 1, n)
        root.right = createTree(array_order, 2 * index + 2, n)
    return root


class Solution:
    def levelOrder(self, root):
        """
        BFS using a queue.
        DFS using recursive stack.
        """
        result = []
        if root is None:
            return result

        # using BFS
        queue = deque([root])
        while queue:
            size = len(queue)
            temp = []
            for i in range(size):
                curr = queue.popleft()
                temp.append(curr.val)
                if curr.left != None:
                    queue.append(curr.left)
                if curr.right != None:
                    queue.append(curr.right)
            result.append(temp)

        # Using DFS
        # def dfs(root, depth):
        #     if root is None:
        #         return
        #     if depth == len(result):
        #         result.append([])
        #     result[depth].append(root.val)
        #     dfs(root.left, depth + 1)
        #     dfs(root.right, depth + 1)
        #
        # dfs(root, 0)
        return result


def main():
    """
    Main function - examples from LeetCode problem to show the working.
    This code ran successfully on LeetCode and passed all test cases.
    """
    array_order = [3, 9, 20, None, None, 15, 7]
    root = createTree(array_order, 0, len(array_order))
    s = Solution()
    print(s.levelOrder(root))  # return [[3], [9, 20], [15, 7]]

    array_order = [1]
    root = createTree(array_order, 0, len(array_order))
    print(s.levelOrder(root))  # return [[1]]

    array_order = []
    root = createTree(array_order, 0, len(array_order))
    print(s.levelOrder(root))  # return []


if __name__ == "__main__":
    main()
