package com.scaler.lld.scaler;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import org.junit.Test;

public class StudentTest {

    @Test
    public void testStudentInstance() {
        Student student = new Student();

        assertNotNull("If the ctor is called, then object must be returned",
                student);
        assertNull("If default ctor is used, name should be null", student.getName());
        assertEquals("If default ctor is used, status should be active", StudentStatus.ACTIVE, student.getStatus());
    }

}

// Coverage - % of code your test cases cover - 80%
// pytest > junit
