'''
207 Course Schedule
https://leetcode.com/problems/course-schedule/description/

There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1. You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates that you must take course bi first if you want to take course ai.

For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.

Return true if you can finish all courses. Otherwise, return false.

Example 1:
Input: numCourses = 2, prerequisites = [[1,0]]
Output: true
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0. So it is possible.

Example 2:
Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
Output: false
Explanation: There are a total of 2 courses to take.
To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.

Constraints:
1 <= numCourses <= 2000
0 <= prerequisites.length <= 5000
prerequisites[i].length == 2
0 <= ai, bi < numCourses
All the pairs prerequisites[i] are unique.


Solution:
1. Topological sorting using BFS (Kahn's algorithm):

Step 1: Create a graph representation. Course is a node (totally numCourses nodes) and prerequisites[i]  (where i=1,..,E) is a directed edge from bi to ai, i.e. bi --> ai

Step 2: Determine the in-degree for each node based on the graph.
The in-degree of a node is the number of edges coming into it. In other words, determine the number of parents for each child node. In this scenario, it represents the number of prerequisites for a course.
Populate the in-degree values in an in-degree array, where the index of the array is the node id (or child id) and the value at the index is the number of parents of the node id.

Step 3: Create an adjacency list (hash map). For each node (parent), determine the children (outgoing edges). The parents represent the keys and the corresponding children represent the values of the adjacency list.

Step 4: Initiate a queue and add all nodes with an in-degree of 0 to it.
Note: Any node enqueued in the  queue must have an in-degree of 0. Otherwise, it cannot be enqueued. When it has an in-degree of 0, it means we have visited all its parents. In this scenario, it means all prereqs (parents) for that course (child) have been completed.

Step 5: This is the topological sorting step.
While the queue is not empty, process the nodes:
- Dequeue a node (= a course with no prerequisites). This is equivalent to visiting this node (parent)
- Retrieve the children of the parent (dequeued node) from the adjacency list.
- Now decrease the in-degree count by 1 of the retrieved children in the in-degree array because we visited the parent (by dequeing the node)
- If the in-degree count of a child is 0, then that child can be added to queue

Note: The topological sorted order is the sequence of nodes popped from the queue.

Step 6: Once the queue is empty, count the number of 0's in the in-degree array.
If that count is equal to the numCourses (total no. of courses), then return True. Else return False.

Time: O(V+E), Space: O(V+E) (adjacent list)
Note: In a fully connected graph, E = V-1. Hence, hash map size=O(V*E)=O(V^2) and time = O(VE)

https://youtu.be/AIdppB34TEQ?t=2149
https://www.youtube.com/watch?v=73sneFXuTEg
https://youtu.be/QqeR7xoVKbc?t=5343 (Discussion on TC/SC)


2. Topological sort using DFS:
- Initialize a visited tracking set and an empty tracking stack to store the final sequence.
- Loop through all vertices in the graph to ensure any disconnected components are processed. For each vertex in the loop, call the dfs(vertex)
- Recursively explore unvisited neighbors of the current vertex using standard Depth-First Search (DFS).
- Push to stack the current vertex only after all of its neighbors are completely processed.
- Reverse the stack (or pop elements one by one) to output the valid topological order.

Time: O(V+E), Space: O(V+E) (adjacent list + call stack)

https://www.youtube.com/watch?v=5lZ0iJMrUMk
https://youtu.be/9twcmtQj4DU?t=66 (Cycle detection)
'''
from collections import defaultdict, deque

def course_scheduling_bfs(N, prereqs):
    if not prereqs or N == 0:
        return True

    indegrees = [0]*N # index = child, value = num parents
    adj_list = defaultdict(list) # key = parent, values = children

    # in-degree and adjacency list of the graph
    for edge in prereqs: # O(E)
        child, parent = edge[0], edge[1]
        #if b is not None:
        indegrees[child] += 1
        adj_list[parent].append(child)

    # enqueue all independent courses (nodes with no parents)
    q = deque()
    for i in range(len(indegrees)):
        num_parents = indegrees[i]
        if num_parents == 0:
            q.append(i)

    # For each parent popped (visited), get the corresponding child/children from the hash map and decrease indegrees[child] (number of parents) count by 1 (since the visited parent was popped)
    result = []
    count = 0 # num of courses taken
    while q:
        curr = q.popleft()
        result.append(curr)
        count += 1
        for child in adj_list[curr]:
            indegrees[child] -= 1
            # if all prereqs met, add course
            if indegrees[child] == 0:
                q.append(child)

    return count == N, result

def course_scheduling_dfs(N, prereqs):
    def dfs(root, path):
        nonlocal cycle
        # Step 0: if already visited, stop proceeding further
        if visited[root]:
            return

        # Step 1 (Action): Mark root as visited and mark path as visited
        visited[root] = True
        path[root] = True # Action

        # Step 2 (Recursion): Call DFS on root's children
        for child in adj_list[root]:
            if not visited[child]:
                dfs(child, path)
            elif path[child] == True: # child in path again -> cycle
                cycle = True

        # Step 3 (Backtrack): Push root to the stack and backtrack path
        if not cycle:
            stack.append(root)
            path[root] = False # backtrack

    if not prereqs or N == 0:
        return True

    adj_list = defaultdict(list) # key = parent, values = children
    for e in prereqs:
        child, parent = e[0], e[1]
        adj_list[parent].append(child)

    visited = [False]*N
    path = [False]*N # path tracks the recursion stack
    stack = []
    cycle = False
    for node in range(N):
        if not visited[node]:
            dfs(node, path)

    # Reverse the elements in the stack (LIFO)
    # to get the course schedule
    schedule = []
    while stack:
        schedule.append(stack.pop())

    return N == len(schedule), schedule

def run_tests():
    tests = [ ([[2,0],[3,0],[1,2],[1,3],[4,2],[5,4],[5,3]],6,True),
              ([[1,0],[2,1],[3,2],[1,3]],4,False), # cyclic DAG!
              ([[1,0],[2,1],[3,2]],4,True),
              ([[1,0]],2,True),
              ([[0,1]],2,True),
              ([[1,0],[0,1]],2,False),
              ([[1,4],[2,4],[3,1],[3,2]],5,True), # strange test case: prereqs has 4 courses 1-4 but total courses = 5. This is because course 0 is a graph on its own with a single isolated node w/o any parent or a child. It's not in prereqs array. When we encounter this course, we add 1 to the number of courses completed since it doesn not have any parent.
    ]
    for test in tests:
        prereqs, num_courses, ans = test[0], test[1], test[2]
        print(f"\nTotal no. of courses = {num_courses}")
        print(f"Prereqs = {prereqs}")
        for method in ['bfs', 'dfs']:
            if method == 'bfs':
                flag, schedule = course_scheduling_bfs(num_courses, prereqs)
            elif method == 'dfs':
                flag, schedule = course_scheduling_dfs(num_courses, prereqs)
            print(f"Method {method}: Can finish all courses? {flag}, Schedule: {schedule}")
            passed = (ans == flag)
            assert passed == True, f"Test case failed"
            print(f"Pass: {passed}")

run_tests()
