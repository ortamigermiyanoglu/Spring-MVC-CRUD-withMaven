package com.sumutella.departmentcrud.services;

import com.sumutella.departmentcrud.entities.Department;

import java.util.List;

/**
 * @author sumutella
 * @time 9:32 PM
 * @since 11/7/2019, Thu
 */
public interface DepartmentServiceInterface {
    Department getDepartment(Integer id);
    List<Department> getDepartments();
    void saveDepartment(Department department);
    void deleteDepartment(Integer id);
    List<Department> search(String hql);
    List<String> getDepartmentNames();
}
