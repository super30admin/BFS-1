// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : -
// Any problem you faced while coding this : No


var levelOrder = function(root) {
    let res = [];
    let q = [];
    q.push(root);

    if(root == null) return res;
    while(q.length > 0){
        let size = q.length;
        let temp = [];
        for(let  i = 0; i < size; i++){
            let curr = q.shift();
            temp.push(curr.val);
            if(curr.left != null) q.push(curr.left);
            if(curr.right != null) q.push(curr.right);
        }
        res.push(temp)
    }
    return res;
};



// var levelOrder = function(root) {
//     let res = [];
//     if(root == null) return res;

//     dfs(root, 0);
//     return res;

//     function(root, level){
//         //base case

//         //logic
//         if(level == res.length){
//             res.push(new Array());
//         }
//         res.find(level).push(root.val);

//         dfs(root.left, level + 1)
//         dfs(root.right, level + 1)
//     }
// }