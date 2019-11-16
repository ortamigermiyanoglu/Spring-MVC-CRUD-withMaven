package com.sumutella.departmentcrud.repositories;

import com.sumutella.departmentcrud.entities.ApplicationLog;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 * @author sumutella
 * @time 10:19 PM
 * @since 11/7/2019, Thu
 */
@Repository
public class ApplicationLogImpl implements ApplicationLogInterface {
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(ApplicationLog applicationLog) {
        sessionFactory.getCurrentSession().save(applicationLog);
    }
}
