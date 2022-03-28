// Time Complexity : O(V+E) where V is no. of vertices (numCourses) and E is no. of edges
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 */
var canFinish = function(numCourses, prerequisites) {
    let indegrees = new Array(numCourses).fill(0);
    let hash = new Map();
    
    // Creating Hash Map to store direction and creating an array of indegrees
    for(const prerequisite of prerequisites) {
        indegrees[prerequisite[0]]++;
        if(hash.has(prerequisite[1])) {
            hash.get(prerequisite[1]).push(prerequisite[0]);
        } else {
            hash.set(prerequisite[1],[prerequisite[0]]);
        }
    }
    
    // Adding prerequisite courses into a queue by checking values in indegrees array
    let q = [];
    let count = 0;
    for(let i = 0; i < numCourses; i++) {
        if(indegrees[i] === 0) {
            q.push(i);
            count++;
        }
    }
    
    if(q.length === 0) return false;
    
    // Removing pre-requisite course from queue and reducing 
    while(q.length) {
        let curr = q.shift();
        let children = hash.get(curr);
        if(children === undefined) continue;
        for(const child of children) {
            indegrees[child]--; //reduce indegrees count by 1
            if(indegrees[child] === 0) {
                q.push(child);
                count++;
            }
        }
    }
    if(count<numCourses) return false;
    return true;
};