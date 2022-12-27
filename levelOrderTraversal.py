# // Time Complexity : O(N)
# // Space Complexity : O(N)
# // Did this code successfully run on Leetcode : Yes
# // Any problem you faced while coding this : No


# // Your code here along with comments explaining your approach

class solution:
    ## in bfs solution we have a queue and each time we process a node , we put its children inside the queue. once we process all emenets inside 
    ## one level we add it to our result.
    def bfs(self, root):

        queue = collections.deque()
        res = []
        queue.append(root)
        while queue:
            qsize = len(queue)
            level = []
            for i in range(qsize):
                curr =  queue.pop()
                level.append(curr)

                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            res.append(level)

        return res

    ## we can solve the above question using dfs as well. we have to maintain the level also along with the node in recursive stack
    ## we check if the level already exists in the result. if it doesnt we create a new level else we appened it the existing one.
    ## ened the end we process all nodes and return the result.
    def dfs(self, root):
        self.res = []
        self.helper(root, 0)
        return self.res

    def helper(self, root, level):
        if root == None:
            return

        if len(self.res) == level:
            self.res.append([])

        ##logic
        self.res[level].append(root.val)

        if root.left:
            self.helper(root.left, level+1)
        if root.right:
            self.helper(root.right, level+1)

