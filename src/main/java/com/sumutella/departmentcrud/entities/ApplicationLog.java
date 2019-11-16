package com.sumutella.departmentcrud.entities;

import javax.persistence.*;

/**
 * @author sumutella
 * @time 10:12 PM
 * @since 11/7/2019, Thu
 */
@Entity
@Table(name = "APPLICATION_LOG")
public class ApplicationLog {

    @Id
    @SequenceGenerator(name = "seqApplicationLog", sequenceName = "APPLICATIONLOG_SEC", allocationSize = 1)
    @GeneratedValue(generator = "seqApplicationLog", strategy = GenerationType.SEQUENCE)
    private Integer id;

    @Column(name = "METHOD_NAME")
    private String methodName;

    @Column(name = "PARAMETERS")
    private String parameters;

    @Column(name = "RETURN_OBJECT")
    private String returnObject;

    @Column(name = "DURATION")
    private String duration;

    public ApplicationLog() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    public String getParameters() {
        return parameters;
    }

    public void setParameters(String parameters) {
        this.parameters = parameters;
    }

    public String getReturnObject() {
        return returnObject;
    }

    public void setReturnObject(String returnObject) {
        this.returnObject = returnObject;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }
}
