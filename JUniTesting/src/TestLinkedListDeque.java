import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Deque;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.*;

public class TestLinkedListDeque {
    private Deque< Integer> list;

    @BeforeEach
    public void setup() {
        list = new LinkedList<>();
    }

    @Test
    public void testOfferNormalForOneSizeCheck() {
        assertTrue(list.isEmpty());//check if list is empty first
        assertTrue(list.offerFirst( 1));//return must return true
        assertEquals(1, list.size());
    }

    @Test
    public void testOfferNormalForOneElementCheck() {
        assertTrue(list.isEmpty());//check if list is empty first
        assertTrue(list.offerFirst( 1));//return must return true
        assertEquals(1, list.peekFirst());
    }

    // new tests cases here

    @Test
    public void testOfferLastWhenListIsEmpty() {
        assertTrue(list.isEmpty());
        assertTrue(list.offerLast(10));
        assertEquals(1, list.size());
    }

    @Test
    public void testOfferLastWhenListHasOneElement() {
        assertTrue(list.isEmpty());
        assertTrue(list.offerLast(10));
        assertEquals(10, list.peekFirst());
        assertEquals(10, list.peekLast());
        assertEquals(1, list.size());
    }

    @Test
    public void testOfferLastWhenListHasTwoElement() {
        assertTrue(list.isEmpty());
        assertTrue(list.offerLast(10));
        assertTrue(list.offerLast(12));
        assertEquals(10, list.peekFirst());
        assertEquals(12, list.peekLast());
        assertEquals(2, list.size());
    }

    @Test
    public void testPollFirstWhenListIsEmpty() {
        assertTrue(list.isEmpty());
        assertNull(list.pollFirst());
        assertEquals(0, list.size());
    }

    @Test
    public void testPollFirstWhenListHasOneElement() {
        assertTrue(list.isEmpty());
        assertTrue(list.offerLast(10));
        assertEquals(10, list.pollFirst());
        assertEquals(0, list.size());
    }

    @Test
    public void testPollFirstWhenListHasTwoElement() {
        assertTrue(list.isEmpty());
        assertTrue(list.offerLast(8));
        assertTrue(list.offerLast(2));
        assertEquals(8, list.pollFirst());
        assertEquals(1, list.size());
    }

    @Test
    public void testPeekFirstWhenListIsEmpty() {
        assertTrue(list.isEmpty());
        assertNull(list.peekFirst());
        assertEquals(0, list.size());
    }

    @Test
    public void testPeekFirstWhenListHasOneElement() {
        assertTrue(list.isEmpty());
        assertTrue(list.offerLast(8));
        assertEquals(8, list.peekFirst());
        assertEquals(1, list.size());
    }

    @Test
    public void testPeekFirstWhenListHasTwoElement() {
        assertTrue(list.isEmpty());
        assertTrue(list.offerLast(19));
        assertTrue(list.offerLast(8));
        assertEquals(19, list.peekFirst());
        assertEquals(2, list.size());
    }

    @Test
    public void testSizeWhenListIsEmpty() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    public void testSizeWhenListHasOneElement() {
        assertTrue(list.offerLast(8));
        assertFalse(list.isEmpty());
        assertEquals(1, list.size());
    }

    @Test
    public void testSizeWhenListHasTwoElement() {
        assertTrue(list.offerLast(8));
        assertTrue(list.offerLast(8));
        assertFalse(list.isEmpty());
        assertEquals(2, list.size());
    }

    @Test
    public void testIsEmptyWhenListIsEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsEmptyWhenListHasOneElement() {
        assertTrue(list.offerLast(8));
        assertFalse(list.isEmpty());
    }

    @Test
    public void testIsEmptyWhenListHasTwoElement() {
        assertTrue(list.offerLast(8));
        assertTrue(list.offerLast(8));
        assertFalse(list.isEmpty());
    }

    @Test
    public void testClearWhenListIsEmpty() {
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testClearWhenListHasOneElement() {
        assertTrue(list.offerLast(8));
        assertEquals(1, list.size());
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    public void testClearWhenListHasTwoElement() {
        assertTrue(list.offerLast(8));
        assertTrue(list.offerLast(8));
        assertEquals(2, list.size());
        list.clear();
        assertTrue(list.isEmpty());
    }
}
