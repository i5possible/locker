import java.util.HashMap;
import java.util.Map;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/7/5
 */

public class Locker {
    private final int totalCapacity;
    private final Map<Ticket, Bag> ticketBagMap = new HashMap<>();

    public Locker(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public Ticket save(Bag bag) {
        if (bag.getSize() != Size.S) {
            throw new WrongTicketTypeException();
        }
        if (getAvailableCapacity() > 0) {
            Ticket ticket = new Ticket();
            ticketBagMap.put(ticket, bag);
            return ticket;
        }
        throw new NoCapacityException();
    }

    private int getAvailableCapacity() {
        return totalCapacity - ticketBagMap.size();
    }

    public Bag retrieve(Ticket ticket) {
        if (ticketBagMap.containsKey(ticket)) {
            Bag bag = ticketBagMap.get(ticket);
            ticketBagMap.remove(ticket);
            return bag;
        }
        throw new InvalidTicketException();
    }
}
