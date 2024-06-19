package com.example.demo;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.openapitools.api.EmployeesApi;
import org.openapitools.model.Employee;
import org.openapitools.model.FilterEmployees200Response;
import org.openapitools.model.FilterEmployeesRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
public class EmployeeApiController implements EmployeesApi {

    private final ObjectMapper objectMapper;

    public EmployeeApiController(ObjectMapper objectMapper) {
        this.objectMapper = objectMapper;
    }

    @Override
    public ResponseEntity<FilterEmployees200Response> filterEmployees(@Valid FilterEmployeesRequest filterEmployeesRequest) {
        List<Employee> employees = filterEmployeesRequest.getEmployees();
        boolean includeSalary = "includeSalary".equals(filterEmployeesRequest.getSecret());

        List<Employee> filteredEmployees = new ArrayList<>();
        for (Employee employee : employees) {
            if (!includeSalary) {
                employee.setSalary(null); // Remove or mask salary if secret is not provided
            }
            filteredEmployees.add(employee);
        }

        FilterEmployees200Response response = new FilterEmployees200Response();
        response.setEmployees(filteredEmployees);

        return ResponseEntity.ok(response);
    }
}