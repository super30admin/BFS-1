# Problem 1
# Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)

# Time Complexity : O(n)
# Space Complexity : O(n)
# Did this code successfully run on Leetcode : Yes
# Any problem you faced while coding this : No

class Solution(object):
    def levelOrder(self, root):
        if not root:
            return []

        result = []
        queue = deque()
        queue.append(root)

        while queue:
            size = len(queue)
            temp = []
            for i in range(size):
                curr = queue.popleft()
                temp.append(curr.val)
                if curr.left:
                    queue.append(curr.left)
                if curr.right:
                    queue.append(curr.right)
            result.append(temp)
        return result


# Problem 2
# Course Schedule (https://leetcode.com/problems/course-schedule/)
#
# Time Complexity : O(V+E)
# Space Complexity : O(V+E)
# Did this code successfully run on Leetcode : Yes

class Solution(object):
    def canFinish(self, numCourses, prerequisites):
        if not prerequisites:
            return True

        indegrees = [0] * numCourses
        map = {}

        for i in prerequisites:
            indegrees[i[0]] += 1
            if i[1] not in map:
                map[i[1]] = []
            map[i[1]].append(i[0])

        queue = deque()
        for i in range(len(indegrees)):
            if indegrees[i] == 0:
                queue.append(i)

        if not queue:
            return False

        while queue:
            curr = queue.popleft()
            if curr in map:
                children = map[curr]
                if children:
                    for child in children:
                        indegrees[child] -= 1
                        if indegrees[child] == 0:
                            queue.append(child)

        for i in indegrees:
            if i != 0:
                return False
        return True


