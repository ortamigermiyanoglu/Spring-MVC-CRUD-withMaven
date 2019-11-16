package com.sumutella.departmentcrud.repositories;

import com.sumutella.departmentcrud.entities.Department;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author sumutella
 * @time 11:38 AM
 * @since 11/2/2019, Sat
 */
@Repository
public class DepartmentDAOImpl implements Dao {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public Department get(Integer id) {
        Query query =  sessionFactory.getCurrentSession().createQuery("from Department Where id =: departmentId");
        query.setParameter("departmentId", id);
        Department department = (Department) query.getSingleResult();
        return department;
    }

    @Override
    public List<Department> getAll() {
        List<Department> departments =  sessionFactory.getCurrentSession().createQuery("From Department").getResultList();
        return departments;
    }

    @Override
    public void save(Department department) {
        sessionFactory.getCurrentSession().saveOrUpdate(department);
    }

    @Override
    public void delete(Integer id) {
        Query query = sessionFactory.getCurrentSession().createQuery("DELETE FROM Department WHERE id = : departmentId");
        query.setParameter("departmentId", id);
        query.executeUpdate();
    }

    @Override
    public List<Department> search(String hql) {
        return sessionFactory.getCurrentSession().createQuery(hql).getResultList();
    }

    @Override
    public List<String> getDepartmentNames() {

        return sessionFactory.getCurrentSession().createQuery("select departmentName from Department").getResultList();
    }

}
