public class Solution {
    /**
     * The definition for the linked list. DO NOT modify this class.
     */
    public static class ListNode {
        int value;
        ListNode next;
        ListNode(int value) {
            this.value = value;
        }
    }
    
    private int getValue(ListNode l1) {
    	 
        return l1 == null ? Integer.MAX_VALUE : l1.value;
      }
    /**
     * Merges to sorted lists.
     */
    public ListNode merge(ListNode l1, ListNode l2) {
        ListNode solution = new ListNode(0);
        ListNode first = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);    
        ListNode mergelist = solution;
        int value = 0;
		ListNode newNode = new ListNode(value);
        while((l1 != null) == (l2 != null )) {
        	if((l1 == null)|| (l2 == null )) {
                return ((l1 == null ? l2 : l1));
            }
            if((l1.value) <= (l2.value )) {
            	if(l1 == null) return l2;
                if(l2 == null) return l1;
                mergelist.next = l1;
                l1 = l1.next;
            }
            else {
            	mergelist.next = l2;
                l2 = l2.next;
            }
            mergelist = mergelist.next;
            if ((l1 == null) && (l2 == null)) {
                return null;
            }
        }
        mergelist.next = ((l1 == null) ?l2 : l1);
        return solution.next;
    }


    private ListNode getInit(ListNode l2, ListNode solution) {
		// TODO Auto-generated method stub
		return null;
	}
	/**
     * Make use of the merge() method in Assignment 1 to implement the merge 
     * sort algorithm.
     * 
     * DO NOT change the method header.
     */
    public ListNode mergeSort(ListNode node, int size) {
        if (size == 1) {
          return node;
        } 
        int middlesection = size / 2;
        ListNode leftside = node;
        leftside = node;
        middlesection = size /2;
        for (int interger = 0; interger < middlesection - 1; interger++) {
          node = node.next;
          //mergeSort(right, mid + size % 2);
        }
        ListNode rightside = node.next;
        node.next = null;
        ListNode mergedRightList = mergeSort(rightside, middlesection + size % 2);
        //mergeSort(right, mid + size % 2);
        ListNode mergedLeftList = mergeSort(leftside, middlesection);
        //mergeSort(left, mid);
        return merge(mergedLeftList, mergedRightList);
      }
     


    public static void main(String[] args) {
        ListNode node1 = new ListNode(4);
        ListNode node2 = new ListNode(4);
        ListNode node3 = new ListNode(8);
        ListNode node4 = new ListNode(2);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        Solution solution = new Solution();
        ListNode result = solution.mergeSort(node1, 5);
        // The output should be 2, 4, 4, 5, 8,
        while (null != result) {
            System.out.print(result.value + ", ");
            result = result.next;
        }
    }
}
