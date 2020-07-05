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

    @Test(expected = NoCapacityException.class)
    public void should_throw_exception_when_save_bag_given_robot_manages_two_full_locker() {
        Locker firstLocker = new Locker(1, Size.M);
        firstLocker.save(new Bag(Size.M));
        Locker secondLocker = new Locker(1, Size.M);
        secondLocker.save(new Bag(Size.M));

        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(firstLocker, secondLocker);

        primaryLockerRobot.save(new Bag(Size.M));
    }

    @Test
    public void should_save_to_second_locker_when_save_bag_given_first_locker_is_full_and_second_is_not() {

        Locker firstLocker = new Locker(1, Size.M);
        firstLocker.save(new Bag(Size.M));
        Locker secondLocker = new Locker(1, Size.M);

        PrimaryLockerRobot primaryLockerRobot = new PrimaryLockerRobot(firstLocker, secondLocker);

        Bag bag = new Bag(Size.M);
        Ticket ticket = primaryLockerRobot.save(bag);

        Bag returnedBag = secondLocker.retrieve(ticket);
        assertEquals(bag, returnedBag);
    }
}
