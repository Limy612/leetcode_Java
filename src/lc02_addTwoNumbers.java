class Solution {

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode h1 = l1, h2 = l2, curr = dummyHead;
        int flag = 0;

        while (h1 != null || h2 != null) {
            int x = (h1 == null ? 0 : h1.val);
            int y = (h2 == null ? 0 : h2.val);
            int sum = x + y + flag;
            flag = sum / 10;

            curr.next = new ListNode(sum % 10);
            curr = curr.next;

            if (h1 != null) h1 = h1.next;
            if (h2 != null) h2 = h2.next;
        }
        if (flag == 1) curr.next = new ListNode(1);

        return dummyHead.next;
    }

    public  static void main(String[] args) {
        ListNode l1 = new ListNode(5);
        //l1.next = new ListNode(4);l1.next.next = new ListNode(3);
        ListNode l2 = new ListNode(5);
        ListNode listNode = addTwoNumbers(l1, l2);


        while (listNode != null) {
            System.out.print(listNode.val);
            listNode = listNode.next;
        }
    }
}

 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
  }

