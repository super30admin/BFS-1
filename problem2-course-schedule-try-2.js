//https://leetcode.com/problems/course-schedule/
//// Time Complexity : O(V+E) on the order of vertices and edges
//// Space Complexity : O(V+E) we store these nodes, vertices in an adjlist
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :

// conceptual.  also so many moving parts to keep correctly working

//// Your code here along with comments explaining your approach

// create a list of incoming edges
// create an adjacency list for each vertex
// initialize a queue with all vertices with no incoming edges
// (return false if you cannot find a starting vertex)

// for each element in the queue
//    pop it off the queue
//    update incoming edges -=1 for each node in the adjacency list
//    push all adjacent nodes from the adjacency list

// go through incoming edges list, if any values != 0 return false else true
var canFinish;

canFinish = function(numCourses, prerequisites) {
  var adjList, edge, front, i, incomingEdges, j, k, len, len1, queue;
  incomingEdges = Array(numCourses).fill(0);
  adjList = new Map();
  // iterate and populate number of incoming edges for every element
  prerequisites.map(function([first, second]) {
    incomingEdges[first] += 1;
    if (!adjList.has(second)) {
      adjList.set(second, []);
    }
    return adjList.set(second, [...adjList.get(second), first]);
  });
  queue = [];
// find the starting point and add them to the queue
  for (i = j = 0, len = incomingEdges.length; j < len; i = ++j) {
    edge = incomingEdges[i];
    if (edge === 0) {
      queue.unshift(i);
    }
  }
  if (queue.length === 0) { // No starting point available
    return false;
  }
  while (queue.length !== 0) {
    front = queue.shift();
    if (!adjList.has(front)) {
      continue;
    }
    adjList.get(front).forEach(function(vertex) {
      incomingEdges[vertex] -= 1;
      if (incomingEdges[vertex] === 0) {
        return queue.push(vertex);
      }
    });
  }
  for (k = 0, len1 = incomingEdges.length; k < len1; k++) {
    edge = incomingEdges[k];
    if (edge !== 0) {
      return false;
    }
  }
  return true;
};

canFinish(2, [[1, 0]]);

//# sourceMappingURL=problem2-course-schedule-try-2.js.map
