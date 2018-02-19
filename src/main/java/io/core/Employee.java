package io.core;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @Column(name = "ID", nullable = false)
    @NotNull
    @JsonProperty
    private Integer id;

    @Column(name = "NAME", length = 100, nullable = false)
    @NotNull
    @JsonProperty
    private String name;

    @Column(name = "ROLE", length = 25)
    @JsonProperty
    private String role;

    public Employee setId(Integer id) {
        this.id = id;
        return this;
    }

    public Integer getId() {
        return id;
    }

    public Employee setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    }

    public Employee setRole(String role) {
        this.role = role;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Employee employee = (Employee) o;

        if (id != null ? !id.equals(employee.id) : employee.id != null) return false;
        if (name != null ? !name.equals(employee.name) : employee.name != null) return false;
        if (role != null ? !role.equals(employee.role) : employee.role != null) return false;
        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' + ", role ='" + role +"'" +
                '}';
    }

}
