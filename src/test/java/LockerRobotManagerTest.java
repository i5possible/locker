import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/7/5
 */

public class LockerRobotManagerTest {

    private Locker locker;
    private PrimaryLockerRobot primaryLockerRobot;
    private SuperLockerRobot superLockerRobot;
    private LockerRobotManager lockerRobotManager;

    @Before
    public void init() {
        locker = new Locker(1, Size.S);
        primaryLockerRobot = new PrimaryLockerRobot(new Locker(1, Size.M));
        superLockerRobot = new SuperLockerRobot(new Locker(1, Size.L));
        lockerRobotManager = new LockerRobotManager(locker, primaryLockerRobot, superLockerRobot);
    }

    @Test
    public void should_return_ticket_when_save_size_s_bag_given_robot_manager_has_available_capacity() {
        Bag bag = new Bag(Size.S);
        Ticket ticket = lockerRobotManager.save(bag);

        Bag returnedBag = locker.retrieve(ticket);
        assertEquals(bag, returnedBag);
    }

    @Test
    public void should_return_ticket_when_save_size_m_bag_given_robot_manager_has_available_capacity() {
        Bag bag = new Bag(Size.M);
        Ticket ticket = lockerRobotManager.save(bag);

        Bag returnedBag = primaryLockerRobot.retrieve(ticket);
        assertEquals(bag, returnedBag);
    }

    @Test
    public void should_return_ticket_when_save_size_l_bag_given_robot_manager_has_available_capacity() {
        Bag bag = new Bag(Size.L);
        Ticket ticket = lockerRobotManager.save(bag);

        Bag returnedBag = superLockerRobot.retrieve(ticket);
        assertEquals(bag, returnedBag);
    }

    @Test(expected = NoCapacityException.class)
    public void should_throw_exception_when_save_bag_given_robot_manager_has_no_available_capacity_for_specified_size_bag() {
        locker.save(new Bag(Size.S));
        lockerRobotManager.save(new Bag(Size.S));
    }

    @Test
    public void should_return_bag_when_retrieve_bag_given_valid_ticket() {
        Bag bag = new Bag(Size.L);
        Ticket ticket = lockerRobotManager.save(bag);

        Bag returnedBag = lockerRobotManager.retrieve(ticket);
        assertEquals(bag, returnedBag);
    }


    @Test(expected = InvalidTicketException.class)
    public void should_return_bag_when_retrieve_bag_given_invalid_ticket() {
        lockerRobotManager.retrieve(new Ticket());
    }

    @Test(expected = InvalidTicketException.class)
    public void should_throw_exception_when_retrieve_bag_twice_given_valid_ticket() {
        Bag bag = new Bag(Size.L);
        Ticket ticket = lockerRobotManager.save(bag);

        Bag returnedBag = lockerRobotManager.retrieve(ticket);
        assertEquals(bag, returnedBag);
        lockerRobotManager.retrieve(ticket);
    }
}
