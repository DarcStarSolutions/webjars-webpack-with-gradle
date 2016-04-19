package org.darcstarsolutions.examples.webjars

import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

/**
 * Created by mharris on 4/18/16.
 */

@Component
class DatabaseLoader implements CommandLineRunner{

    private EmployeeRepository repository


    DatabaseLoader(EmployeeRepository repository) {
        this.repository = repository
    }

    @Override
    void run(String... args) throws Exception {
        repository.save(new Employee("Frodo", "Baggins", "ring bearer"));
        repository.save(new Employee("Bilbo", "Baggins", "burglar"));
        repository.save(new Employee("Gandalf", "the Grey", "wizard"));
        repository.save(new Employee("Samwise", "Gamgee", "gardener"));
        repository.save(new Employee("Meriadoc", "Brandybuck", "pony rider"));
        repository.save(new Employee("Peregrin", "Took", "pipe smoker"));
    }
}
