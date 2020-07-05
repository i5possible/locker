import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/7/5
 */

public class PrimaryLockerRobotTest {

    @Test
    public void should_save_size_m_bag_to_first_locker_when_save_bag_given_robot_manages_two_locker_with_available_capacity() {
        Locker firstLocker = new Locker(1, Size.M);

        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(firstLocker, new Locker(1, Size.M));

        Bag bag = new Bag(Size.M);
        Ticket ticket = primaryLockerRobot.save(bag);

        Bag returnedBag = firstLocker.retrieve(ticket);
        assertEquals(bag, returnedBag);
    }
}
