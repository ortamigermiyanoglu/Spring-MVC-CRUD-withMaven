package com.sumutella.departmentcrud.services;

import com.sumutella.departmentcrud.entities.ApplicationLog;
import com.sumutella.departmentcrud.repositories.ApplicationLogInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author sumutella
 * @time 10:22 PM
 * @since 11/7/2019, Thu
 */
@Service
public class ApplicationLogService implements ApplicationLogServiceInterface {
    @Autowired
    private ApplicationLogInterface applicationLogImpl;

    @Override
    @Transactional
    public void save(ApplicationLog applicationLog) {
        applicationLogImpl.save(applicationLog);
    }
}
