package org.darcstarsolutions.examples.webjars

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

/**
 * Created by mharris on 4/18/16.
 */

@Component
class DatabaseLoader implements CommandLineRunner{

    private EmployeeRepository employeeRepository


    DatabaseLoader(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository
    }

    @Override
    void run(String... args) throws Exception {
        Employee employee = new Employee("Frodo", "Baggins", "ring bearer")
        employeeRepository.save(employee)
        println employee
    }
}
