#Time complexity: O(n)
#Space complexity: O(n)
#Works on leetcode: yes
#Approach:  We use DFS here and traverse the tree right to left using recursion. Whenever, we reach the new depth, we
# add the value to the answer as the right most node will always come first at the latest level. 
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        def dfs(node, h):
            if node:
                if len(view)==h:
                    view.append(node.val)
                dfs(node.right, h+1)
                dfs(node.left, h+1)
        view = []
        dfs(root,0)
        return view