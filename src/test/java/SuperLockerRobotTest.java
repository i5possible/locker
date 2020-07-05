import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/7/5
 */

public class SuperLockerRobotTest {
    @Test
    public void should_save_to_second_locker_when_save_bag_given_second_locker_has_large_available_capacity_ratio() {
        Locker firstLocker = new Locker(2, Size.L);
        firstLocker.save(new Bag(Size.L));
        Locker secondLocker = new Locker(2, Size.L);
        SuperLockerRobot superLockerRobot = new SuperLockerRobot(firstLocker, secondLocker);

        Bag bag = new Bag(Size.L);
        Ticket ticket = superLockerRobot.save(bag);

        Bag returnedBag = secondLocker.retrieve(ticket);
        assertEquals(bag, returnedBag);
    }
}
