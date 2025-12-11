# BFS-1
# Problem 1
Binary Tree Level Order Traversal (https://leetcode.com/problems/binary-tree-level-order-traversal/)
* BFS solution - add the root element in the queue first. Assign the size of queue & list for every level.
* pop the element, add to the list & add children to the queue.
* T- O(n) all nodes to be iterated, S - O(n) width of the tree.

# Problem 2
Course Schedule (https://leetcode.com/problems/course-schedule/)
* DS1 - in degree array will keep all inwards arrow count, DS2 - HashMap(indep, list of dep), DS3 - Queue that will store V with indegrees[]==0
* In the Q, look for dependents in map, reduce indegree by 1, Queue that will store V with indegrees[]==0
* if count=numCourses means we can finish all courses.

