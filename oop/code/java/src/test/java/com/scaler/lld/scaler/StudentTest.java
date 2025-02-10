package com.scaler.lld.scaler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class StudentTest {

    @Test
    public void testDefaultCtor() {
        Student student = new Student();

        assertNotNull("If the ctor is called, then object must be returned",
                student);
        assertNull("If default ctor is used, name should be null", student.getName());
        assertEquals("If default ctor is used, status should be active", StudentStatus.ACTIVE, student.getStatus());
    }

    @Test
    public void testParametrisedCtor() {
        Student student = new Student("John Doe", "john@doe.in", "Batch 1", 100);

        assertNotNull("If the ctor is called, then object must be returned",
                student);
        assertEquals("If name ctor is passed to ctor, name should be set in instance", "John Doe", student.getName());
        assertEquals("If status is not passed to ctor, status should be active", StudentStatus.ACTIVE,
                student.getStatus());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testParametrisedCtorWithInvalidPsp() {
        new Student("John Doe", "john@doe.in", "Batch 1", 101);
    }

    @Test
    public void testParentFields() {
        Student student = new Student("John Doe", "john@doe.in", "Batch 1", 100);
        assertEquals("If name ctor is passed to ctor, name should be set in instance", "John Doe", student.getName());
        
        String newEmail = "john@doe.com";
        student.changeEmail(newEmail);
        assertEquals("If email is changed, then email should be updated", newEmail, student.getEmail());
    }

}

// Coverage - % of code your test cases cover - 80%
// pytest > junit
