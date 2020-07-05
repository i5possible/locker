import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/7/5
 */

public class PrimaryLockerRobot {
    private final List<Locker> lockers = new ArrayList<>();

    public PrimaryLockerRobot(Locker... lockers) {
        this.lockers.addAll(Arrays.asList(lockers));
    }

    public Ticket save(Bag bag) {
        for (Locker locker : lockers) {
            if (locker.isAvailable()) {
                return locker.save(bag);
            }
        }
        throw new NoCapacityException();
    }
}
