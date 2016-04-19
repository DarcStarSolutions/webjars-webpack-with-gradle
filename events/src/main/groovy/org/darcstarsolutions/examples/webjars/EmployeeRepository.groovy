package org.darcstarsolutions.examples.webjars

import org.springframework.data.repository.PagingAndSortingRepository
/**
 * Created by mharris on 4/18/16.
 */
interface EmployeeRepository extends PagingAndSortingRepository<Employee, Long>{

}