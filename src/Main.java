public class Main {
    public static void main(String[] args) {
        ListNode a = new ListNode(2);
        ListNode b = new ListNode(4);
        ListNode c = new ListNode(3);

        a.next = b;
        b.next = c;
        c.next = null;

        System.out.println(listToInt(a));
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
