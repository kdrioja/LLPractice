public class Main {
    public static void main(String[] args) {
        /**Testing removeDuplicates
        // l1
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        // l2
        ListNode d = new ListNode(3);
        ListNode e = new ListNode(4);
        ListNode f = new ListNode(4);
        ListNode g = new ListNode(5);
        a.next = b;
        b.next = c;
        c.next = d;
        d.next = e;
        e.next = f;
        f.next = g;
        //g.next = null;

        printList(a);
        printList(removeDuplicates(a));
        */

        /**
         * Testing addTwoNumbers
         *
        System.out.println(listToInt(a));
        System.out.println(listToInt(d));
        System.out.println(listToInt(addTwoNumbers(a, d)));
         */

        ListNode a = new ListNode(1);
        a.next = new ListNode(2);
        a.next.next = new ListNode(3);
        //a.next.next.next = new ListNode(4);

        printList(a);
        printList(swapNodesInPairs(a));
    }

    public static ListNode swapNodesInPairs(ListNode head) {
        if (head == null) { //empty list
            return null;
        } else if (head.next == null) { //only 1 element
            return head;
        } //1->2->3->4
        else {//2 elements or more, so we will at least make 1 switch
            ListNode first = head, //first element              1
                    second = head.next, //second element       2
                    next = second.next, //second.next          3
                    prev = null, //                            null
                    result = second; //                        2

            while (first != null && second != null) {//first = 1, second = 2;;;first = 3, second = 4
                if (prev != null) {//prev is null;;;prev = 1
                    prev.next = second; //2->1->4
                }

                second.next = first; //2->1 ;;; 2->1->4->3
                first.next = next; //2->1->3 ;;; 2->1->4
                prev = first; //prev = 1
                first = next; //first = 3

                if (first != null) {//first is not null
                    second = first.next; //second = 4
                    next = (second == null) ? null : second.next; //next = null
                }
            }
            return result;
        }
    }



    public static void printList(ListNode head) {
        if (head == null) {
            System.out.println("null");
        }
        else {
            while (head != null) {
                System.out.print(head.val + "->");
                head = head.next;
            }
            System.out.print("/");
        }
        System.out.println();
    }

    /**
     Week 4: Remove Duplicates (Challenge Problem)
     Given a linked list, delete all nodes that have duplicate
     numbers, leaving only distinct numbers from the original
     list. Can you do it without taking up extra memory?

     Will the numbers all be positive?
     Will they be sorted?
     Will they all be ints?
     Should a null list return null?

     1->1->5->5->6->6 ==> return null
     3->6->9->9->12 ==> return 3->6->12

     could use a HashSet to add the ints and check if we have
     encountered it before

     def use a dummy head to connect the unique nodes

     1. if list is null, return null
     2. create a dummy node and a tail pointer to the end of dummy
     3. keep an int variable named lastInt which keeps the last value seen
     4. if the next node is not equal to the value then update lastInt
        else remove the previous node [KEEP A REFERENCE TO THE LAST NODE],
        and current node


     //WAIT YOU SOLVED REVERSE THE LIST NOT REMOVE DUPLICATES
     3. Iterate through the notes
        store prev node, current node, and next node
        - prev is initially null
        - current node is the head
        - get the value of head.next and store in next
        - set current.next to prev
        - set prev to current
        - set current to next node
        - continue;
     4. return dummyHead.next
     */

    public static ListNode removeDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }

        ListNode dummyHead = new ListNode(0);
        ListNode tail = dummyHead;
        ListNode slow = head, fast = head.next;
        int lastValue = Integer.MIN_VALUE;

        while (slow != null) {
            if (fast != null) {

                if (slow.val != fast.val && slow.val != lastValue) {
                    //append to tail bc it is unique
                    tail.next = slow;
                    tail = slow;
                }

                //update last value seen
                lastValue = slow.val;
                //advance slow and fast
                slow = fast;
                fast = fast.next;

            }
            else { //fast was equal to null, so slow is last node
                if (slow.val != lastValue) { //value is unique
                    tail.next = slow;
                    tail = slow;
                }
                //advance slow to null
                slow = fast;
            }
        }

        return dummyHead.next;
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

    //there is a more elegant solution than this

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