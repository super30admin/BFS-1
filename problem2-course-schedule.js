//https://leetcode.com/problems/course-schedule/
//// Time Complexity :
//// Space Complexity :
//// Did this code successfully run on Leetcode : yes
//// Any problem you faced while coding this :

//// Your code here along with comments explaining your approach
var canFinish;

canFinish = function(numCourses, prerequisites) {
  var edge, first, front, hashMap, i, incomingEdges, j, k, l, len, len1, len2, len3, m, queue, ref, second;
  incomingEdges = Array(numCourses).fill(0);
  hashMap = new Map();
// iterate and populate number of incoming edges for every element
  for (j = 0, len = prerequisites.length; j < len; j++) {
    edge = prerequisites[j];
    first = edge[0];
    second = edge[1];
    incomingEdges[first] += 1;
    if (!hashMap.has(second)) {
      hashMap.set(second, []);
    }
    hashMap.set(second, [...hashMap.get(second), first]);
  }
  queue = [];
// find the starting point and add them to the queue
  for (i = k = 0, len1 = incomingEdges.length; k < len1; i = ++k) {
    edge = incomingEdges[i];
    if (edge === 0) {
      queue.unshift(edge);
    }
  }
  if (queue.length === 0) { // No starting point available
    return false;
  }
  while (queue.length !== 0) {
    front = queue[0];
    if (hashMap.has(front)) {
      ref = hashMap.get(front);
      for (i = l = 0, len2 = ref.length; l < len2; i = ++l) {
        edge = ref[i];
        edge -= 1;
        if (edge === 0) {
          queue.shift();
        }
      }
    }
  }
  for (m = 0, len3 = incomingEdges.length; m < len3; m++) {
    edge = incomingEdges[m];
    if (edge !== 0) {
      return false;
    }
  }
  return true;
};

canFinish(2, [[1, 0]]);

//# sourceMappingURL=problem2-course-schedule.js.map
