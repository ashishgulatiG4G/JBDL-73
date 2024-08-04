package com.example.springstarter;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Repository
@Slf4j
public class EmployeeDao {

//     localhost
//     app server -> 127.0.0.1 8080
//     db server  -> 127.0.0.1 3306

    //


    // DBServer -> [DB1, DB2, DB3]
    // DB1 -> T1, T2, T3
    // T1 -> R, C


    // Primary key -> field which is unique for each row

    //Create -> won't return anything
    // R -> return something
    // U -> return nothing
    // D -> return nothing


    private Connection connection = null;

    public EmployeeDao(@Value("${db.url}") String url,
                       @Value("${db.username}") String username,
                       @Value("${db.password}") String password) {

        log.info("Credentials: " + url + username + password);

        try {
            connection = DriverManager.getConnection(url, username, password);

        } catch (SQLException e) {
            log.error("Exception in creating the connection");
        }
        this.createEmployeeTable();
    }

    private void createEmployeeTable() {
        // create table employee(id int primary key, name varchar(30), age int)
        String sql = "create table if not exists employee(id int primary key, name varchar(30), age int)";

        try {
            Statement statement = this.connection.createStatement();
            statement.execute(sql);
        } catch (Exception e) {
            log.error("Couldn't create the table: {}", e.getMessage());
        }

        log.info("Table got created successfully");
    }

    //Create Employee -> won't return anything
    public void createEmployee(Employee employee) throws SQLException {
        // Write sql to insert employee in db

        // insert into employee(name, age, id) Values('JOHN', 30, 1)


        String sql = "insert into employee(name, age, id) Values('" + employee.getName() + "'," +
                employee.getAge() +  "," + employee.getId() +  ")";
        Statement statement = this.connection.createStatement();
        statement.execute(sql);
        log.info("Employee created");
    }

    public void createEmployeeDynamic(Employee employee) throws SQLException {
        String sql = "insert into employee(name, age, id) Values(?,?,?)";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);

        preparedStatement.setString(1, employee.getName());
        preparedStatement.setInt(2, employee.getAge());
        preparedStatement.setInt(3, employee.getId());

        preparedStatement.execute();
        log.info("Employee created Using dynamic");
    }

    // Getall
    public List<Employee> getEmployees() throws SQLException {
        // Select * from employee;

        String sql = "Select * from employee";
        Statement statement = this.connection.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        List<Employee> employees = new ArrayList<>();

        while(rs.next()) {
            employees.add(new Employee(rs.getString("name"),
                    rs.getInt("id"),
                    rs.getInt("age")
            ));
        }

        return employees;
    }

    public Employee getEmployeeById(Integer employeeId) throws SQLException {

        String sql = "Select * from employee where id = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setInt(1, employeeId);

        ResultSet rs = preparedStatement.executeQuery();
        if (rs.next()) {
            return new Employee(rs.getString("name"),
                    rs.getInt("id"),
                    rs.getInt("age")
            );
        }
        return null;
    }

    // TODO - getEmployeeByName


    public void updateEmployee(Employee employee) throws SQLException {
        // update employee set name = "ashish", age = 24 where id = 2;
        String sql = "update employee set name = ?, age = ? where id = ?";
        PreparedStatement preparedStatement = this.connection.prepareStatement(sql);
        preparedStatement.setString(1, employee.getName());
        preparedStatement.setInt(2, employee.getAge());
        preparedStatement.setInt(3, employee.getId());

        preparedStatement.executeUpdate();
    }


    //TODO - complete this
    public void deleteEmployee() {

    }












}

/*
    Dao -> Data access object, accesses the database directly
            It does ops related to DB

 */