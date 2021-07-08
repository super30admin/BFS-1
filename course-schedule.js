// Time Complexity : O(V + E)
// Space Complexity : O(V + E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : Lots of variable names, so it took a while just to get it to work.
// Other than that, no problem.

/**
 * @param {number} numCourses
 * @param {number[][]} prerequisites
 * @return {boolean}
 */
var canFinish = function(numCourses, prerequisites) {
    if (numCourses == null || numCourses == 0) return true;
    if (prerequisites == null || prerequisites.length == 0) return true;
    
    let degrees = new Array(numCourses).fill(0),
        map = new Map,
        queue = [];
    for (let i = 0; i < prerequisites.length; i++) {
        degrees[prerequisites[i][0]]++;
        if (!map.has(prerequisites[i][1])) {
            map.set(prerequisites[i][1], []);
        }
        map.get(prerequisites[i][1]).push(prerequisites[i][0]);
    }
    for (let i = 0; i < degrees.length; i++) {
        if (degrees[i] == 0) queue.push(i);
    }
    if (queue.length == 0) return false;
    while (queue.length > 0) {
        let course = queue.shift();
        let children = map.get(course);
        if (children) {
            for (const child of children) {
                degrees[child]--;
                if (degrees[child] == 0) {
                    queue.push(child);
                }
            }
        }
    }
    for (let i = 0; i < degrees.length; i++) {
        if (degrees[i] > 0) return false;
    }
    return true;
};
