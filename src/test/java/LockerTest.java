import org.junit.Test;

import static org.junit.Assert.assertNotNull;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/7/5
 */

public class LockerTest {
    @Test
    public void should_save_size_s_bag_when_save_bag_given_locker_has_capacity() {
        Locker locker = new Locker(1);

        Ticket ticket = locker.save(new Bag(BagType.S));

        assertNotNull(ticket);
    }
}
