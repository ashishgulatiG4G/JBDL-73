package com.example.Class_13_JPA_Hibernate.dao;

import com.example.Class_13_JPA_Hibernate.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// T = any class (model) on which you are performing db operations
// ID = datatype of primary key (must have)

@Repository
public interface EmployeeDao extends JpaRepository<Employee, Integer> {




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