package com.makingdevs.repositories

import com.makingdevs.model.Employee
import org.springframework.data.repository.CrudRepository
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

/**
 * Created by makingdevs on 11/25/16.
 */
interface EmployeeRepository extends CrudRepository<Employee, Integer> {

  Employee findByFirstNameAndLastName(String firstName, String lastName)

}