

/*
*
* Versão do Java usada no HackerRank: JAVA 8
*
* O método a seguir deve ser copiado e sobreposto no teste do HackerRank!
*
* link: https://www.hackerrank.com/challenges/detect-whether-a-linked-list-contains-a-cycle/problem
* */
static boolean hasCycle(SinglyLinkedListNode head) {
    if (head == null || head.next == null) {
        return false;
    }
    SinglyLinkedListNode fast = head.next;
    SinglyLinkedListNode slow = head;
    while (fast != null && fast.next != null && fast != slow) {
        fast = fast.next.next;
        slow = slow.next;
    }
    if (fast == slow) {
        return true;
    }
    return false;

}