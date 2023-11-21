package regionancash.gob.pe.almacenbah.service;

import java.util.List;

public interface ICRUD<T, ID> {

    T create(T t) throws Exception;

    List<T> readAll() throws Exception;

    T readById(ID id) throws Exception;

    T update(T t) throws Exception;

    void delete(ID id) throws Exception;

}
