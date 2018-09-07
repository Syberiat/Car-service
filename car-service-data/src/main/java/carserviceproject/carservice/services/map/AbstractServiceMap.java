package carserviceproject.carservice.services.map;

import carserviceproject.carservice.models.BasicEntity;

import java.util.*;

public class AbstractServiceMap<Id extends Long,T extends BasicEntity> {

    private Map<Long,T> map = new HashMap<>();

    Set<T> findAll(){
        return new HashSet<>(map.values());
    }

    T findById (Id id){
        return map.get(id);
    }

    void deleteById (Id id){
        map.remove(id);
    }

    T save ( T object){
        if (object != null){
            if (object.getId() == null){
                object.setId(getNextId());
            }
            map.put(object.getId(), object);
        }
        return object;
    }

    void delete (T object){
        map.entrySet().removeIf(a -> a.getValue().equals(object));
    }

    private Long getNextId(){
        Long nextId = null;
        try {
            nextId = Collections.max(map.keySet()) + 1;
        } catch (RuntimeException e){
            nextId = 1L;
        }
        return nextId;
    }
}
