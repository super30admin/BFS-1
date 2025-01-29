############# Level order traversal of binary tree

# Time Complexity :  O(n)
# Space Complexity : O(h) where h is the height of the tree
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

# perform dfs on the binary tree and keep track of the element and the level. Based on the level add the elements to the list.

def level_order_traversal(root):
        if not root:
            return []

        result = []
        stack = [(root,0)]

        while stack:
            elem,level = stack.pop(0)
            if level == len(result):
                result.append([])

            result[level].append(elem.val)

            if elem.left:
                stack.append((elem.left,level+1))
            if elem.right:
                stack.append((elem.right,level+1))

        return result
    
