import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/7/5
 */

public class SuperLockerRobot extends AbstractRobot{
    public SuperLockerRobot(Locker... lockers) {
        this.lockers.addAll(Arrays.asList(lockers));
    }

    Optional<Locker> findBestLocker() {
        return lockers.stream().max(Comparator.comparing(Locker::getAvailableCapacityRatio));
    }
}
