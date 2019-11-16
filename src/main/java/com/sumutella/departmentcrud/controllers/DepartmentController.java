package com.sumutella.departmentcrud.controllers;

import com.sumutella.departmentcrud.entities.Department;
import com.sumutella.departmentcrud.services.DepartmentServiceInterface;
import com.sumutella.departmentcrud.services.HelperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;


/**
 * @author sumutella
 * @time 9:40 AM
 * @since 11/2/2019, Sat
 */

@RequestMapping("/department")
@Controller
public class
DepartmentController {
    @Autowired
    private DepartmentServiceInterface departmentService;
    @Autowired
    private HelperService helperService;

    private static boolean callerUpdateForm = false;


    @RequestMapping("/list-departments")
    public String test(Model model){
        callerUpdateForm = false;

        model.addAttribute("departments", departmentService.getDepartments());
        model.addAttribute("managersMap", helperService.getManagersMap());
        model.addAttribute("locationsMap", helperService.getLocationsMap());
        model.addAttribute("departmentsMap", helperService.getDepartmentsMap());
        return "list-departments";
    }

    @RequestMapping("/add-department")
    public String addDepartment(Model model){
        callerUpdateForm = false;



        Department department = new Department();

        model.addAttribute("department", department);
        model.addAttribute("eligibleToManageMap", helperService.getEligibleManagersMap());
        model.addAttribute("locationsMap",  helperService.getLocationsMap());

        return "form-departments";
    }

    @PostMapping("/save-department")
    public String saveStudent (@Valid @ModelAttribute("department") Department department,
                               BindingResult bindingResult, Model model) {

        List<String> departmentNames = departmentService.getDepartmentNames();


        if (!callerUpdateForm){
            for (String deptName : departmentNames){
                if (department.getDepartmentName().equalsIgnoreCase(deptName)){
                    bindingResult.rejectValue("departmentName", "departmentName.UniqueConstraintViolation", "Department names must be unique");
                    model.addAttribute("department", department);
                    model.addAttribute("eligibleToManageMap", helperService.getEligibleManagersMap());
                    model.addAttribute("locationsMap",  helperService.getLocationsMap());
                    return "form-departments";
                }
            }
        }



        if (bindingResult.hasErrors()){
            model.addAttribute("department", department);
            model.addAttribute("eligibleToManageMap", helperService.getEligibleManagersMap());
            model.addAttribute("locationsMap",  helperService.getLocationsMap());
            return "form-departments";
        }

        departmentService.saveDepartment(department);
        return "redirect:/department/list-departments";
    }



    @GetMapping("/update-department/{id}")
    public String updateDepartment(@PathVariable Integer id, Model model) {
        callerUpdateForm = true;

        Department department = departmentService.getDepartment(id);
        HashMap<Integer, String> eligibleToManageMap = helperService.getEligibleManagersMap();
        if (department.getManagerId() !=null){
            eligibleToManageMap.put(department.getManagerId(), helperService.getManagersMap().get(department.getManagerId()));
        }

        model.addAttribute("managerIDCB", department.getManagerId() );
        model.addAttribute("locationIDCB", department.getLocationId());

        model.addAttribute("department", department);
        model.addAttribute("eligibleToManageMap", eligibleToManageMap);
        model.addAttribute("locationsMap", helperService.getLocationsMap());
        return "form-departments";
    }



    @GetMapping("/delete-department/{id}")
    public String deleteDepartment(@PathVariable Integer id, Model model) {
        callerUpdateForm = false;
        departmentService.deleteDepartment(id);
        return "redirect:/department/list-departments";
    }

    @RequestMapping("/search-department")
    public String searchDepartment(@RequestParam(name = "deptName", required = false) String deptName,
                                   @RequestParam(name = "manager-options", required = false) int managerId,
                                   @RequestParam(name = "location-options", required = false) int locationId, Model model){
        callerUpdateForm = false;

        String hql = "FROM Department WHERE 1=1 ";

        if (deptName!=null && !deptName.isEmpty()){
            hql += " and lower(departmentName) like  " + "'%" + deptName.toLowerCase() + "%'";
        }
        if (managerId != 0){
            hql += " and managerId = " + managerId;
        }
        if (locationId != 0){
            hql += " and locationId = " + locationId;
        }

        model.addAttribute("managersMap", helperService.getManagersMap());
        model.addAttribute("locationsMap", helperService.getLocationsMap());
        model.addAttribute("departmentsMap", helperService.getDepartmentsMap());
        List<Department> departments = departmentService.search(hql);
        model.addAttribute("departments", departments );

        System.out.println(hql);

        return "list-departments";
    };
}
