package org.example;

public class ShapeDao {

    public boolean delete(Object o) throws Exception {
        if(!(o instanceof Shape))
            throw new Exception("Can't be deleted");


        // Delete operation on a DB
        System.out.println("Deleting from DB done");


        return true;
    }

}
