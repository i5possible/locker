import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/7/5
 */

public class LockerTest {
    @Test
    public void should_save_size_s_bag_when_save_bag_given_locker_has_capacity() {
        Locker locker = new Locker(1, Size.S);

        Ticket ticket = locker.save(new Bag(Size.S));

        assertNotNull(ticket);
    }

    @Test(expected = NoCapacityException.class)
    public void should_throw_exception_when_save_bag_given_locker_is_full() {
        Locker locker = new Locker(1, Size.S);

        locker.save(new Bag(Size.S));
        locker.save(new Bag(Size.S));
    }

    @Test(expected = WrongTicketTypeException.class)
    public void should_throw_exception_when_save_bag_given_bag_size_is_not_s() {
        Locker locker = new Locker(1, Size.S);

        locker.save(new Bag(Size.M));
    }
    
    @Test
    public void should_return_bag_when_retrieve_bag_given_valid_ticket() {
        Locker locker = new Locker(1, Size.S);

        Bag bag = new Bag(Size.S);
        Ticket ticket = locker.save(bag);

        Bag returnedBag = locker.retrieve(ticket);

        assertEquals(bag, returnedBag);
    }

    @Test(expected = InvalidTicketException.class)
    public void should_throw_exception_when_retrieve_bag_using_invalid_ticket() {
        Locker locker = new Locker(1, Size.S);

        locker.retrieve(new Ticket());
    }

    @Test(expected = InvalidTicketException.class)
    public void should_throw_exception_when_retrieve_bag_twice_using_same_valid_ticket() {
        Locker locker = new Locker(1, Size.S);

        Ticket ticket = locker.save(new Bag(Size.S));

        locker.retrieve(ticket);
        locker.retrieve(ticket);
    }
}
