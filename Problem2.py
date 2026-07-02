# Problem 2: Course Schedule (https://leetcode.com/problems/course-schedule/)
# Time Complexity: O(V + E), V = numCourses, E = number of prerequisite pairs
# We visit every course once and look at every prerequisite edge once
# Building the graph = O(E), scanning all courses = O(V), BFS loop = O(V + E)

# Space Complexity: O(V + E)
# indegrees array = O(V), graph dictionary stores all edges = O(E)
# queue holds at most all courses at once = O(V)

# Approach:
# We model courses as nodes and prerequisites as directed edges in a graph.
# A course can only be "taken" when all its prerequisites are done (indegree = 0).
# We use BFS: start with all courses that need nothing,"take" them one by one, and unlock courses that were waiting on them.
# If we successfully take all courses, no cycle exists, return True.
# If we get stuck before taking all courses, a cycle exists, return False.

class Solution:
    def canFinish(self, numCourses: int, prerequisites: List[List[int]]) -> bool:

        # indegrees[i] = how many prerequisites course i still needs before it can be taken
        # start everyone at 0, we will increment as we read the prerequisite pairs
        indegrees = [0] * numCourses

        # graph[i] = list of courses that get "unlocked" (one step closer) once course i is finished
        graph = {}

        # read every prerequisite pair and build our two structures
        for pr in prerequisites:
            # pr[0] is the course we want to take, pr[1] is the course we must finish first
            # so pr[0] gains one more prerequisite it needs
            indegrees[pr[0]] += 1

            # and finishing pr[1] will help unlock pr[0], so add pr[0] to pr[1]'s unlock list
            if pr[1] not in graph:
                graph[pr[1]] = []           # first time seeing pr[1] as a key, create its list
            graph[pr[1]].append(pr[0])      # pr[1] unlocks pr[0] when finished

        count = 0       # count = how many courses we have successfully "taken" so far

        # queue holds all courses that are currently ready to be taken (indegree = 0)
        # we use deque because removing from the front (popleft) is O(1), unlike a regular list
        queue = deque()

        # scan all courses, any course that needs zero prerequisites can be taken right now
        for i in range(numCourses):
            if indegrees[i] == 0:
                queue.append(i)     # this course is ready immediately, add to queue
                count += 1          # we are counting it as taken

        # if the queue is empty here, every single course needs at least one prerequisite
        # that means everyone is waiting on someone else, a cycle must exist from the start
        if not queue:
            return False

        # if every course already had indegree 0 (no prerequisites at all), we are trivially done
        if count == numCourses:
            return True

        # BFS: keep taking courses from the queue and unlocking their dependents
        while queue:
            current = queue.popleft()           # take the next available course

            # find all courses that were waiting on 'current' to be finished
            dependencies = graph.get(current)   # returns None if current unlocks nothing

            if dependencies:
                for dep in dependencies:
                    indegrees[dep] -= 1         # current is done, so dep needs one fewer prerequisite now

                    if indegrees[dep] == 0:     # dep has no more prerequisites left, it's ready!
                        queue.append(dep)       # add dep to the queue so we take it next
                        count += 1              # count it as taken

                        if count == numCourses: # we've taken every course, no cycle, we are done
                            return True

        # queue ran out but we didn't take all courses
        # some courses were stuck waiting forever (their indegree never reached 0)
        # that means those courses are part of a cycle, impossible to finish
        return False