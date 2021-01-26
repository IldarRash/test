public class SolutionA{
    public static void solution(Node<String> head) {

        Node<String> curr = head;
        while (curr != null) {
            System.out.println(curr.value);
            curr = curr.next;
        }
    }
}