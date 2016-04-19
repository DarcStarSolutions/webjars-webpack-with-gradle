package org.darcstarsolutions.examples.webjars

import org.springframework.data.repository.CrudRepository

/**
 * Created by mharris on 4/18/16.
 */
interface EmployeeRepository extends CrudRepository<Employee, Long>{

}