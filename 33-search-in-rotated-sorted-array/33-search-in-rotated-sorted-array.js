/**
 * @param {number[]} nums
 * @param {number} target
 * @return {number}
 */
var search = function(nums, target) {
    let left = 0;
    let right = nums.length-1;
    
    // console.log('left is ', left);
    // console.log('right is ', right);
    
    while(left <= right) {
        let mid = Math.floor((left+right)/2)
        // console.log('mid is ', mid)
        if(target === nums[mid]) {
            return mid
        }
        //left sorted portion
        if(nums[left] <= nums[mid]) {
            if(nums[left] > target || target > nums[mid]) {
                left = mid + 1
            } else {
                right = mid -1
            }
        }
        //right sored portion
        else {
            if(target > nums[right] || target < nums[mid]) {
                right = mid -1
            } else {
                left = mid + 1
            }
        }
        // console.log('============================')
        // console.log('left is ', left);
        // console.log('right is ', right);
    }
    return -1
    
};