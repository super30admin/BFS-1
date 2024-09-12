#https://leetcode.com/problems/course-schedule/
#// Time Complexity : O(V+E) on the order of vertices and edges
#// Space Complexity : O(V+E) we store these nodes, vertices in an adjlist
#// Did this code successfully run on Leetcode : yes
#// Any problem you faced while coding this :
#
# conceptual.  also so many moving parts to keep correctly working
#
#// Your code here along with comments explaining your approach
#
# create a list of incoming edges
# create an adjacency list for each vertex
# initialize a queue with all vertices with no incoming edges
# (return false if you cannot find a starting vertex)
#
# for each element in the queue
#    pop it off the queue
#    update incoming edges -=1 for each node in the adjacency list
#    push all adjacent nodes from the adjacency list
#
# go through incoming edges list, if any values != 0 return false else true

canFinish = (numCourses, prerequisites) ->
  incomingEdges = Array(numCourses).fill(0)

  adjList = new Map()

  # iterate and populate number of incoming edges for every element
  prerequisites.map ([first, second]) ->
    incomingEdges[first] += 1

    if !adjList.has(second)
      adjList.set(second, [])

    adjList.set(second, [adjList.get(second)..., first])

  queue = []

  # find the starting point and add them to the queue
  for edge, i in incomingEdges
    if edge is 0
      queue.unshift(i)

  if queue.length is 0 # No starting point available
    return false

  while queue.length isnt 0
    front = queue.shift()

    if !adjList.has(front) then continue

    adjList.get(front).forEach (vertex) ->
      incomingEdges[vertex] -= 1
      if incomingEdges[vertex] is 0
        queue.push(vertex)

  for edge in incomingEdges
    if edge != 0
      return false

  return true

canFinish(2, [[1, 0]])
