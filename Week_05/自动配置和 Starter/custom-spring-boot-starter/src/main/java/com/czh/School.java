package com.czh;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
public class School implements ISchool {
    
    // Resource 
    @Autowired(required = true) //primary
    Klass class1;
    
    @Autowired
    Student student100;
    
    @Override
    public void ding(){
    
        System.out.println("Class1 have " + this.class1.getStudents().size() + " students and one is " + this.student100);
        
    }
    
}
