// Time Complexity : O(V+E); V is the vertices abd E id the edges
// Space Complexity : O(V+E); V is the vertices abd E id the edges
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Course Schedule (https://leetcode.com/problems/course-schedule/)
// Your code here along with comments explaining your approach

/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 */
var canFinish = function (numCourses, prerequisites) {
    if (numCourses === 0)
        return true;

    // Maintains the number of incomings for each course
    let indegree = new Array(numCourses);
    indegree.fill(0);
    // Maintains parent and child pairs
    let adjMap = new Map();
    prerequisites.forEach(preReq => {
        let outgoing = preReq[1];
        let incoming = preReq[0];
        // If incoming, inc the count
        indegree[incoming]++;
        if (!adjMap.has(outgoing)) {
            adjMap.set(outgoing, new Array());
        }
        let childs = adjMap.get(outgoing);
        adjMap.set(outgoing, [...childs, incoming]);
    })
    let q = [];
    let totalCount = 0;
    for (let i = 0; i < numCourses; i++) {
        if (indegree[i] === 0) {
            q.push(i);
            totalCount++;
        }
    }
    // BFS
    // Loop through the childs of each node.
    // If the incomings are 0, add it to queue
    while (q.length > 0) {
        let node = q.shift();
        let childs = adjMap.get(node);
        if (childs) {
            childs.forEach(child => {
                indegree[child]--;
                if (indegree[child] === 0) {
                    q.push(child);
                    totalCount++;
                }
            })
        }
    }
    // Ig total courses taken i.e added in the queue are same as numCourses, return true
    return totalCount === numCourses;
};