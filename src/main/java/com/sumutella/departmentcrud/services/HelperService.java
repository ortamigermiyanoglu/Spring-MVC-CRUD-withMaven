package com.sumutella.departmentcrud.services;

import com.sumutella.departmentcrud.repositories.HelperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;

/**
 * @author sumutella
 * @time 11:48 AM
 * @since 11/2/2019, Sat
 */
@Service
public class HelperService {
    @Autowired
    private HelperRepository helperRepository;

    @Transactional
    public HashMap<Integer, String> getLocationsMap() {
        return helperRepository.getLocationsMap();
    }

    @Transactional
    public HashMap<Integer, String> getManagersMap() {
        return helperRepository.getManagersMap();
    }

    @Transactional
    public HashMap<Integer, String> getEligibleManagersMap() {
        return helperRepository.getEligibleManagersMap();
    }

    @Transactional
    public HashMap<Integer, String> getDepartmentsMap() {
        return helperRepository.getDepartmentsMap();
    }



}
