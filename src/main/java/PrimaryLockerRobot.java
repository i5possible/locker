import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/7/5
 */

public class PrimaryLockerRobot extends AbstractRobot {
    public PrimaryLockerRobot(Locker... lockers) {
        this.lockers.addAll(Arrays.asList(lockers));
    }

    @Override
    Optional<Locker> findBestLocker() {
        return lockers.stream()
                .filter(Locker::isAvailable)
                .findFirst();
    }
}
