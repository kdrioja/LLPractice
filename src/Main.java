public class Main {
    public static void main(String[] args) {
        // l1
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(4);

        a.next = b;
        b.next = c;
        c.next = null;

        // l2
        ListNode d = new ListNode(1);
        ListNode e = new ListNode(3);
        ListNode f = new ListNode(4);

        d.next = e;
        e.next = f;
        f.next = null;

        /**
         * Testing addTwoNumbers
         *
        System.out.println(listToInt(a));
        System.out.println(listToInt(d));
        System.out.println(listToInt(addTwoNumbers(a, d)));
         */
    }

    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        return null;
    }


    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum = listToInt(l1) + listToInt(l2);
        String sumStr = Integer.toString(sum);

        //at minimum sumStr has a length of 1
        ListNode head = new ListNode(Character.getNumericValue(sumStr.charAt(sumStr.length() - 1)));

        //if there are more digits
        ListNode currentNode = head;

        for (int i = sumStr.length() - 2; i >= 0; i--) {
            ListNode newNode = new ListNode(Character.getNumericValue(sumStr.charAt(i)));
            currentNode.next = newNode;
            currentNode = newNode;
        }

        return head;
    }

    public static int listToInt(ListNode list) {
        //given two non-empty linked lists representing two non-negative integers
        //digits are stored in reverse order and each of their nodes contain a single digit

        StringBuilder str = new StringBuilder();
        ListNode currentNode = list;
        if (currentNode != null) {
            str.append(currentNode.val);
            currentNode = currentNode.next;
        }

        while (currentNode != null) {
            str.insert(0, currentNode.val);
            currentNode = currentNode.next;
        }

        return Integer.valueOf(str.toString());
    }
}
