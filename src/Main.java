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
        //if only l1 is empty
        else if (l1 == null) {
            return l2;
        }
        //if only l2 is empty
        else if (l2 == null) {
            return l1;
        }
        //if neither is empty
        else {
            ListNode head = new ListNode(-1), tail = head, pointer1 = l1, pointer2 = l2;
            boolean flag1 = false, flag2 = false;

            while (flag1 == false && flag2 == false) {
                //if values are the same, append both
                if (pointer1.val == pointer2.val) {
                    tail.next = pointer1;
                    tail = pointer1;
                    pointer1 = pointer1.next;
                    flag1 = pointer1 == null ? true : false;

                    tail.next = pointer2;
                    tail = pointer2;
                    pointer2 = pointer2.next;
                    flag2 = pointer2 == null ? true : false;
                }
                else if (pointer1.val < pointer2.val) {
                    tail.next = pointer1;
                    tail = pointer1;
                    pointer1 = pointer1.next;
                    flag1 = pointer1 == null ? true : false;
                }
                else {
                    tail.next = pointer2;
                    tail = pointer2;
                    pointer2 = pointer2.next;
                    flag2 = pointer2 == null ? true : false;
                }
            }

            if (flag1 == flag2) { //both are true
                return head.next;
            }
            else if (flag1) { //flag1 == true
                tail.next = pointer2;
                return head.next;
            }
            else {
                tail.next = pointer1;
                return head.next;
            }
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
