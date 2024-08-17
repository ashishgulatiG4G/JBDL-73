package com.example.Class_13_JPA_Hibernate.dao;

import com.example.Class_13_JPA_Hibernate.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// T = any class (model) on which you are performing db operations
// ID = datatype of primary key (must have)

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {

    @Query("Select e FROM Employee e WHERE e.age > :age AND e.city = :city")
    List<Employee> findEmployeeGreaterThanAgeAndCity(@Param("age") Integer age, @Param("city") String city);

    @Query(value = "SELECT * FROM employee WHERE age > :age AND city = :city", nativeQuery = true)
    List<Employee> findEmployeeGreaterThanAgeAndCityNative(@Param("age") Integer age, @Param("city") String city);

}




/*
 Repository -> CrudRepo -> PagingAndSorting
                          /             |             \
                        JPARepo         MongoRepo    Cassandra
                      SQL, PostGreSQL
                        RelationalDBs

         -> Why one 1 JPA repo for all the relational DBs but non-relational have separate repo's?
        Because non-relational DBs have diff structures like
                key-value -> Redis, cassandra
                Document -> Mongo
                Column -> HBase, Dynamo
                Graph -> GraphQL

        But every relational DB have tables, rows and columns


        Because for ex-> Mongo might have document.findBy(), others might not


*/


/*

    @Query -> To execute custom queries
    1. Native Query -> Writing queries keeping sql table in mind
    2. JPQL -> Keep java objects in mind

 */