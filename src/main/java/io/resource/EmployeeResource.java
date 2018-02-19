package io.resource;

import io.core.Employee;
import io.dao.EmployeeDAO;
import io.dropwizard.hibernate.UnitOfWork;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/employee")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class EmployeeResource {

    EmployeeDAO employeeDAO;

    public EmployeeResource(EmployeeDAO employeeDAO) {
        this.employeeDAO = employeeDAO;
    }

    @GET
    @UnitOfWork
    public List<Employee> getAll(){
        return employeeDAO.getAll();
    }

    @GET
    @Path("/{id}")
    @UnitOfWork
    public Employee get(@PathParam("id") Integer id){
        return employeeDAO.findById(id);
    }

    @POST
    @UnitOfWork
    public Employee add(@Valid Employee employee1) {
        System.out.println(employee1);
        Employee newEmployee = employeeDAO.insert(employee1);
        return newEmployee;
    }

    @PUT
    @Path("/{id}")
    @UnitOfWork
    public Employee update(@PathParam("id") Integer id, @Valid Employee employee) {
        employee = employee.setId(id);
        employeeDAO.update(employee);

        return employee;
    }

    @DELETE
    @Path("/{id}")
    @UnitOfWork
    public void delete(@PathParam("id") Integer id) {
        employeeDAO.delete(employeeDAO.findById(id));
    }
}