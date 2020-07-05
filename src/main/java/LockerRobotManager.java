import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/7/5
 */

public class LockerRobotManager implements Storeable {
    private final List<Storeable> storeables = new ArrayList<>();

    public LockerRobotManager(Storeable... storeables) {
        this.storeables.addAll(Arrays.asList(storeables));
    }

    @Override
    public Ticket save(Bag bag) {
        for (Storeable storeable : storeables) {
            if (storeable.canSave(bag)) {
                return storeable.save(bag);
            }
        }
        return null;
    }

    @Override
    public Bag retrieve(Ticket ticket) {
        return null;
    }

    @Override
    public boolean isValid(Ticket ticket) {
        for (Storeable storeable : storeables) {
            if (storeable.isValid(ticket)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean canSave(Bag bag) {
        for (Storeable storeable : storeables) {
            if (storeable.canSave(bag)) {
                return true;
            }
        }
        return false;
    }
}
