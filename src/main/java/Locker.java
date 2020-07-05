import java.util.HashMap;
import java.util.Map;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/7/5
 */

public class Locker implements Storeable {
    private final int totalCapacity;
    private final Map<Ticket, Bag> ticketBagMap = new HashMap<>();
    private final Size acceptableSize;

    public Locker(int totalCapacity, Size acceptableSize) {
        this.totalCapacity = totalCapacity;
        this.acceptableSize = acceptableSize;
    }

    @Override
    public Ticket save(Bag bag) {
        if (!canSave(bag)) {
            throw new WrongTicketTypeException();
        }
        if (getAvailableCapacity() > 0) {
            Ticket ticket = new Ticket();
            ticketBagMap.put(ticket, bag);
            return ticket;
        }
        throw new NoCapacityException();
    }

    public boolean isAvailable() {
        return getAvailableCapacity() > 0;
    }

    private int getAvailableCapacity() {
        return totalCapacity - ticketBagMap.size();
    }

    @Override
    public Bag retrieve(Ticket ticket) {
        if (isValid(ticket)) {
            Bag bag = ticketBagMap.get(ticket);
            ticketBagMap.remove(ticket);
            return bag;
        }
        throw new InvalidTicketException();
    }

    @Override
    public boolean isValid(Ticket ticket) {
        return ticketBagMap.containsKey(ticket);
    }

    @Override
    public boolean canSave(Bag bag) {
        return bag.getSize() == acceptableSize;
    }

    public double getAvailableCapacityRatio() {
        return getAvailableCapacity() * 1.0 / totalCapacity;
    }
}
