package com.scaler.lld.scaler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

public class StudentTest {
    
    @Test
    public void testStudentInstance() {
        Student student = new Student("name", "email", 10, "address", "batchName", 10, StudentStatus.ACTIVE);
        assertNotNull("If ctor is called, the instance should be created", student);
        assertEquals("If name is passed to ctor, the instance should have the same name", "name", student.getName());
    }

    @Test
    public void testPauseCourse() {
        Student student = new Student("name", "email", 10, "address", "batchName", 10, StudentStatus.ACTIVE);
        student.pauseCourse();
        assertEquals("If pauseBatch is called, the status should be PAUSED", StudentStatus.PAUSED, student.getStatus());
    }

    @Test
    public void testChangeEmail() {
        Student student = new Student("name", "email", 10, "address", "batchName", 10, StudentStatus.ACTIVE);
        student.changeEmail("newEmail");
        assertEquals("If changeEmail is called, the email should be changed", "newEmail", student.getEmail());
    }

}
