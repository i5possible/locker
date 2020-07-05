/**
 * @author lianghongbuaa@gmail.com
 * @date 2020/7/5
 */

public interface Storeable {
    Ticket save(Bag bag);
    Bag retrieve(Ticket ticket);
    boolean isValid(Ticket ticket);
    boolean canSave (Bag bag);
}
