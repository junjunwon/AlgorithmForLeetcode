/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number[]}
 */
const twoSum = (nums, target) => {
    let storage = {};
    
    for(let [index, num] of nums.entries()) {
        if(storage[num] !== undefined) {
            return [storage[num], index];
        }
        storage[target-num] = index 
    }
}
// var twoSum = function(nums, target) {
    // for (let i = 0; i<nums.length; i++) {
    //     for(let j = i+1; j<nums.length; j++) {
    //         if(nums[i]+nums[j] === target) {
    //             return [i,j];
    //         }
    //     }
    // }
// };