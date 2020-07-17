package kaohe.Demo;

public class SortList {
    public ListNode partition(ListNode head, int x) {
    if(head==null)
        return null;
    ListNode L=new ListNode(-1);
    L.next=head;
    ListNode q=head;
    head=head.next;
    while(head!=null){
        if(head.val<x){
            q.next=head.next;
            head.next=L.next;
            L.next=head;
            head=q.next;
        }else{
            q=q.next;
            head=head.next;
        }
    }
    return L.next;
}
}
class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
}
