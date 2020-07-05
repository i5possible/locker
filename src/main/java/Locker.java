import java.util.HashMap;
import java.util.Map;

/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/7/5
 */

public class Locker {
    private int totalCapacity;
    private Map<Bag, Ticket> bagTicketMap = new HashMap<>();

    public Locker(int totalCapacity) {
        this.totalCapacity = totalCapacity;
    }

    public Ticket save(Bag bag) {
        if (getAvailableCapacity() > 0) {
            Ticket ticket = new Ticket();
            bagTicketMap.put(bag, ticket);
            return ticket;
        }
        throw new NoCapacityException();
    }

    private int getAvailableCapacity() {
        return totalCapacity - bagTicketMap.size();
    }
}
