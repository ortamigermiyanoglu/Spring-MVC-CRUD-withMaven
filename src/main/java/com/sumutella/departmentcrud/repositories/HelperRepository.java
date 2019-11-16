package com.sumutella.departmentcrud.repositories;

import com.sumutella.departmentcrud.entities.Department;
import com.sumutella.departmentcrud.entities.Location;
import com.sumutella.departmentcrud.entities.Manager;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

/**
 * @author sumutella
 * @time 11:48 AM
 * @since 11/2/2019, Sat
 */
@Repository
public class HelperRepository {
    @Autowired
    private SessionFactory sessionFactory;


    public HashMap<Integer,String> getLocationsMap(){
        List<Location> locations = sessionFactory.getCurrentSession().createQuery("SELECT L FROM Location L").getResultList();
        HashMap<Integer, String> locationHM = new HashMap<>();
        for(Location location : locations){
            locationHM.put(location.getId(),location.getCity());
        }
        return locationHM;
    }

    public HashMap<Integer,String> getEligibleManagersMap(){
        List<Manager> managers = sessionFactory.getCurrentSession().
                createQuery("SELECT M FROM Manager M where  M.id not in " +
                        " (select  D.managerId from  Department D Where D.managerId is not null) ").getResultList();
        HashMap<Integer, String > managerHM = new HashMap<>();
        for(Manager manager : managers){
            managerHM.put(manager.getId(), manager.getFirstName() +" " + manager.getLastName());
        }

        return managerHM;
    }

    public HashMap<Integer, String> getManagersMap(){
        String hql = "SELECT M FROM Manager M, Department D where D.managerId = M.id";
        List<Manager> managers = sessionFactory.getCurrentSession().
                createQuery(hql).getResultList();

        HashMap<Integer, String> managerHM = new HashMap<>();
        for (Manager manager : managers){
            managerHM.put( manager.getId(),manager.getFirstName() + " " + manager.getLastName());
        }
        return managerHM;
    }

    public HashMap<Integer, String> getDepartmentsMap(){
        List<Department> departments = sessionFactory.getCurrentSession().createQuery("FROM Department").getResultList();
        HashMap<Integer, String> departmentHM = new HashMap<>();
        for (Department department : departments){
            departmentHM.put(department.getId(), department.getDepartmentName());
        }
        return departmentHM;
    }

}
