package com.sumutella.departmentcrud.services;

import com.sumutella.departmentcrud.entities.Department;
import com.sumutella.departmentcrud.repositories.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author sumutella
 * @time 11:38 AM
 * @since 11/2/2019, Sat
 */
@Service
public class DepartmentService implements DepartmentServiceInterface {

    @Autowired
    private Dao departmentDAO;

    @Transactional
    @Override
    public Department getDepartment(Integer id){
        return departmentDAO.get(id);
    }

    @Transactional
    @Override
    public List<Department> getDepartments(){
        return departmentDAO.getAll();
    }

    @Transactional
    @Override
    public void saveDepartment(Department department){
        departmentDAO.save(department);
    }

    @Transactional
    @Override
    public void deleteDepartment(Integer id){
        departmentDAO.delete(id);
    }

    @Transactional
    @Override
    public List<Department> search(String hql){
        return departmentDAO.search(hql);
    }

    @Transactional
    @Override
    public List<String> getDepartmentNames() {
        return departmentDAO.getDepartmentNames();
    }
}
