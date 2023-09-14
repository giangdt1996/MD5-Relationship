package ra.service;

import java.util.List;

public interface IGenericService<T, K, V> {
    List<T> findAll();

    T findById(V id);

    T save(K k);

    T update(K k, V id);

    T delete(V id);
}
