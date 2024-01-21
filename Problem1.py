'''

Time Complexity : O(n)
Space Complexity : O(n)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No issues faced

Your code here along with comments explaining your approach

For each element in the tree we traverse, either thru BFS or DFS we appropriately add elements to a list of elements either
at each level in BFS or at every node in DFS

'''

# solution 1 - using DFS and recursion
def helper(root,level):
    if root is None:
        return

    if level in levelmap:
        levelmap[level].append(root.val)

    if level not in levelmap:
        levelmap[level] = [root.val]

    if root.left:
        helper(root.left, level+1)

    if root.right:
        helper(root.right, level+1)


levelmap = defaultdict(int)
helper(root, 0)
return levelmap.values()


# solution 2 - using BFS and queues

res = []
q = collections.deque()
q.append(root)

while q:
    level = []
    length = len(q)
    for i in range(length):
        node = q.popleft()
        if node:
            q.append(node.left)
            q.append(node.right)
            level.append(node.val)

    if level:
        res.append(level)

return res