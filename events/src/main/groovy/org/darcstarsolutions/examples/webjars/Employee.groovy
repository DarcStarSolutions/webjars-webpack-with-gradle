package org.darcstarsolutions.examples.webjars

import com.fasterxml.jackson.annotation.JsonIgnore

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.Version

/**
 * Created by mharris on 4/18/16.
 */

@Entity
class Employee {

    private @Id @GeneratedValue Long id;
    String firstName;
    String lastName;
    String description;

    @Version
    @JsonIgnore
    Long version

    private Employee() {}

    public Employee(String firstName, String lastName, String description) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.description = description;
    }

    public Long getId(){
        return id
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("id=").append(id);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", lastName='").append(lastName).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
