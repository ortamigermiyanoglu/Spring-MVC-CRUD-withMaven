package com.sumutella.departmentcrud.repositories;

import com.sumutella.departmentcrud.entities.Department;

import java.util.List;

/**
 * @author sumutella
 * @time 11:37 AM
 * @since 11/2/2019, Sat
 */
public interface Dao {

    Department get(Integer id);
    List<Department> getAll();
    void save(Department department);
    void delete(Integer id);
    List<Department> search(String hql);
    List<String> getDepartmentNames();
}