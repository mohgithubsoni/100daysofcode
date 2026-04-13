class Solution:
    def deleteDuplicates(self, head: Optional[ListNode]) -> Optional[ListNode]:
        if not head or not head.next:
            return head
        
        dummy = ListNode(-1)  # Dummy node to handle edge cases
        prev = dummy
        prev.next = head
        curr = head
        
        while curr and curr.next:
            if curr.val == curr.next.val:
                # Skip all duplicates
                while curr.next and curr.val == curr.next.val:
                    curr = curr.next
                prev.next = curr.next  # Skip duplicates
            else:
                prev = prev.next  # Move prev forward if no duplicates
            curr = curr.next  # Move curr forward
        
        return dummy.next