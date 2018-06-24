package Websockets.Shared.interfaces;




import java.util.List;


public interface IRepository <T> {
    void add(T item);

    void update(T item);

    void remove(T item);

    List<T> getAll();

    T getSingle(long id);

}
