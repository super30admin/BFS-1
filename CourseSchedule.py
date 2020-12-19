    #approach: BFS
    # How do we know this is a graph problem. When we draw dependencies of one course to another, it seems that the problem is graph problem.

    # Maintain a queue. It will always contain the courses that are independent.

    # Maitain in-degree array. To know which course is independent. We will first take an independent course into queue, pop it and reduce the indegree of the courses whose prerequisite was the popped course. 

    # Maintain a hashmap to check for the prerequistes of the required courses in O(1) time complexity

    # Time complexity: O(n); n = no of courses
    # Space complexity: O(n); n = no of courses

    from collections import defaultdict
    class Solution:
        def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

            if numCourses== 0:
                return True


            inDegree = [0] * numCourses
            hmap = defaultdict(list)

            # Construct in-degree array and hashmap
            for i in range(len(prerequisites)):
                inDegree[prerequisites[i][0]] += 1

                hmap[prerequisites[i][1]].append(prerequisites[i][0])

            # Initialize and generate the queue
            q = []
            for i in range(numCourses):
                if inDegree[i] == 0:
                    q.append(i)

            # Loop until the queue is empty
            while len(q) != 0:
                curr = q.pop(0)
                children = hmap[curr]

                if children != None:

                    # Decrease the indegree of every children
                    for child in children:
                        inDegree[child] -= 1
                        if inDegree[child] == 0:
                            q.append(child)

            print(inDegree)
            for i in range(numCourses):
                if inDegree[i] > 0:
                    return False

            return True

