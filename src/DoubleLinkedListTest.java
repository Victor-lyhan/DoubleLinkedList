import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DoubleLinkedListTest {

    private DoubleLinkedList<Integer> list;

    @BeforeEach
    void setUp() {
        list = new DoubleLinkedList<>();
    }

    // Test peek on an empty list
    @Test
    void testPeekEmpty() {
        Assertions.assertNull(list.peek(), "Peek on empty list should return null");
    }

    // Test peek on a list with elements
    @Test
    void testPeekNonEmpty() {
        list.offer(10);
        list.offer(20);
        list.offer(30);
        Assertions.assertEquals(10, list.peek(), "Peek should return the first element");
    }

    // Test poll on an empty list
    @Test
    void testPollEmpty() {
        Assertions.assertNull(list.poll(), "Poll on empty list should return null");
    }

    // Test poll on a list with elements
    @Test
    void testPollNonEmpty() {
        list.offer(10);
        list.offer(20);
        list.offer(30);
        Assertions.assertEquals(10, list.poll(), "Poll should return and remove the first element");
        Assertions.assertEquals(20, list.peek(), "After poll, peek should return the new first element");
    }

    // Test offer (inserting elements)
    @Test
    void testOffer() {
        list.offer(10);
        list.offer(20);
        list.offer(30);
        Assertions.assertEquals(10, list.peek(), "Offer should add elements to the list, starting with the first element");
        Assertions.assertEquals(3, list.size(), "List size should be 3 after offering three elements");
    }

    // Test offer and poll together
    @Test
    void testOfferAndPoll() {
        list.offer(10);
        list.offer(20);
        list.offer(30);
        Assertions.assertEquals(10, list.poll(), "Poll should return and remove the first element (10)");
        Assertions.assertEquals(20, list.poll(), "Next poll should return and remove the second element (20)");
        Assertions.assertEquals(30, list.poll(), "Final poll should return and remove the last element (30)");
        Assertions.assertNull(list.poll(), "After all elements are polled, poll should return null");
    }
}