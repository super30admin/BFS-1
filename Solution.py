class Solution(object):
    def levelOrder(self, root):
        """
        :type root: TreeNode
        :rtype: List[List[int]]
        time: O(n)
        space: O(n)
        """
        if not root:
            return []
        q = collections.deque([root])
        res = []
        while q:
            size = len(q)
            res.append([])
            for _ in range(size):
                cur = q.popleft()
                if cur.left:
                    q.append(cur.left)
                if cur.right:
                    q.append(cur.right)
                res[-1].append(cur.val)
        return res

    def canFinish(self, numCourses, prerequisites):
        """
        :type numCourses: int
        :type prerequisites: List[List[int]]
        :rtype: bool
        m = #edges
        n = #courses
        time: O(m + n)
        space: O(m + n)
        """
        course2dependent = defaultdict(list)
        numPreq = [0] * numCourses        
        for dependent, course in prerequisites:
            course2dependent[course].append(dependent)
            numPreq[dependent] += 1
        q = deque([i for i in range(numCourses) if numPreq[i] == 0])
        num_completed = 0
        while q:
            course = q.popleft()
            num_completed += 1
            dependents = course2dependent[course]
            for dependent in dependents:
                numPreq[dependent] -= 1
                if numPreq[dependent] == 0:
                    q.append(dependent)
        if num_completed == numCourses:
            return True
        return False