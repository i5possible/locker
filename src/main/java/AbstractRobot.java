import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/7/5
 */

public abstract class AbstractRobot {
    protected final List<Locker> lockers = new ArrayList<>();

    public Ticket save(Bag bag) {
        Optional<Locker> bestLocker = findBestLocker();
        if (bestLocker.isPresent()) {
            return bestLocker.get().save(bag);
        }
        throw new NoCapacityException();
    }

    public Bag retrieve(Ticket ticket) {
        for (Locker locker : lockers) {
            if (locker.isValid(ticket)) {
                return locker.retrieve(ticket);
            }
        }
        throw new InvalidTicketException();
    }

    abstract Optional<Locker> findBestLocker();
}
