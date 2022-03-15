import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

public class WaiterTest {
    private ICook cook = null;
    private ICustomer customer = null;

    @BeforeEach
    public void setUp() throws Exception {
        // mock the cook and customer interfaces
        this.cook = mock(ICook.class);
        this.customer = mock(ICustomer.class);
    }

    @Test
    public void testSetOrderFromCustomerToWaiterThenCook() throws Exception {
        String order = "Java Rice";

        // setup customer places an order
        when(this.customer.PlaceOrder()).thenReturn(order);

        // create waiter
        Waiter waiter = new Waiter();

        // waiter receives the order
        waiter.SetOrder(this.customer.PlaceOrder());
        // waiter passes order to the cook
        this.cook.SetOrder(waiter.GetOrder());

        // throws an exception for another call because waiter does not have the order at this point
        Exception exception = assertThrows(Exception.class, waiter::GetOrder);
        assertEquals("No Order To Pass Exception", exception.getMessage());
    }

    @Test
    public void testGetOrderFromCookToWaiterThenCustomer() throws Exception {
        String order = "Java Rice";

        // setup customer receives the order
        when(this.customer.ReceiveOrder(order)).thenReturn(true);

        // setup cook returns an order
        when(this.cook.GetOrder()).thenReturn(order);

        // create the waiter
        Waiter waiter = new Waiter();

        // waiter grabs the order from cook
        waiter.SetOrder(this.cook.GetOrder());

        // get the cooked order from the waiter
        String cookedOrder = waiter.GetOrder();

        // give the cooked order to customer
        boolean isCorrectOrder = this.customer.ReceiveOrder(cookedOrder);
        // verify if correct order
        assertTrue(isCorrectOrder);

        // throws an exception for another call because waiter does not have the order at this point
        // the order was already given to customer
        Exception exception = assertThrows(Exception.class, waiter::GetOrder);
        assertEquals("No Order To Pass Exception", exception.getMessage());
    }
}
