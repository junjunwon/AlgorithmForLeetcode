/**
 * @param {number[]} nums
 * @return {number[]}
 */
var productExceptSelf = function(nums) {
    let prefix = 1
    const result = Array.from({length : nums.length},() => 1)
    
    for (let i = 0; i < nums.length; i++) {
        result[i] = prefix;
        prefix *= nums[i]
    }
    let suffix = 1
    for(let i = 0; i < nums.length; i++) {
        result[nums.length-1-i] *= suffix;
        suffix *= nums[nums.length-1-i]
    }
    return result
    
    
};