/**
 * Definition for singly-linked list.
 * function ListNode(val, next) {
 *     this.val = (val===undefined ? 0 : val)
 *     this.next = (next===undefined ? null : next)
 * }
 */
/**
 * @param {ListNode} list1
 * @param {ListNode} list2
 * @return {ListNode}
 */
var mergeTwoLists = function(list1, list2) {
    /**
    point is sorted list 
    
    **/
    const listNode = new ListNode(-Infinity);
    let prev = listNode;
    
    while(list1 && list2) {
        if(list1.val <= list2.val) {
            prev.next = list1;
            prev = list1
            list1 = list1.next
            console.log("====list1====")
            console.log(JSON.stringify(prev)); //{"val":1,"next":{"val":2,"next":{"val":4,"next":null}}}
            console.log(JSON.stringify(list1)); //{"val":2,"next":{"val":4,"next":null}}
        } else {
            prev.next= list2
            prev = list2
            list2 = list2.next
        }
    }
    console.log("====prev====")
    console.log(JSON.stringify(prev)); //{"val":4,"next":null}
    console.log("====list1====")
    console.log(JSON.stringify(list1)); //null
    console.log("====list2====")
    console.log(JSON.stringify(list2)); //{"val":4,"next":null}
    if(!list1) {
        prev.next = list2
    }
    if(!list2) {
        prev.next = list1
    }
    
    console.log("====Final prev====")
    console.log(JSON.stringify(prev)); //{"val":4,"next":{"val":4,"next":null}}
    console.log("====Final listNode====")
    console.log(JSON.stringify(listNode));  //{"val":null,"next":{"val":1,"next":{"val":1,"next":{"val":2,"next":{"val":3,"next":{"val":4,"next":{"val":4,"next":null}}}}}}}
    console.log(listNode);  //[-Infinity,1,1,2,3,4,4]
    return listNode.next;
};