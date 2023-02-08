package week_05_optional_solid_timeComplexity.school_project_template.service;

import java.util.List;

public interface CRUDService<T>{

    T findById(int id);

    List<T> findAll();

    void save(T t);

    void update(T t);

    void deleteById(int id);

}
