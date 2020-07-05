import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/7/5
 */

public abstract class AbstractRobot implements Storeable{
    protected final List<Locker> lockers = new ArrayList<>();
    private Bag bag;

    @Override
    public Ticket save(Bag bag) {
        this.bag = bag;
        Optional<Locker> bestLocker = findBestLocker();
        if (bestLocker.isPresent()) {
            return bestLocker.get().save(bag);
        }
        throw new NoCapacityException();
    }

    @Override
    public Bag retrieve(Ticket ticket) {
        for (Locker locker : lockers) {
            if (locker.isValid(ticket)) {
                return locker.retrieve(ticket);
            }
        }
        throw new InvalidTicketException();
    }

    @Override
    public boolean isValid(Ticket ticket) {
        for (Locker locker : lockers) {
            if (locker.isValid(ticket)) {
                return locker.isValid(ticket);
            }
        }
        return false;
    }

    @Override
    public boolean canSave(Bag bag) {
        for (Locker locker : lockers) {
            if (locker.canSave(bag)) {
                return true;
            }
        }
        return false;
    }

    abstract Optional<Locker> findBestLocker();
}
