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
        //if both lists are empty
        if (l1 == null && l2 == null) {
            return null;
        }
        //if l1 si empty
        else if (l1 == null) {
            return l2;
        }
        //if l2 is empty
        else if (l2 == null) {
            return l1;
        }
        //
        else {
            //decide which one is the head
            ListNode head, pointer1, pointer2;

            if (l1.val <= l2.val) {
                head = l1;
                pointer1 = l1.next;
                pointer2 = l2;
            }
            else {
                head = l2;
                pointer1 = l1;
                pointer2 = l2.next;
            }

            boolean flag1 = pointer1 == null ? true : false;
            boolean flag2 = pointer2 == null ? true : false;

            while (!flag1 && !flag2) {
                ListNode next1 = pointer1.next;
                ListNode next2 = pointer2.next;

                if (pointer1.val <= pointer2.val) {
                    head.next = pointer1;
                    head = pointer1;
                }
                else {
                    head.next = pointer2;
                    head = pointer2;
                    
                }
            }

            return l1;
        }
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
