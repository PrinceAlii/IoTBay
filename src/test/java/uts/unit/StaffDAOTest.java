package uts.unit;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import uts.isd.model.dao.StaffDAO;

import static org.junit.jupiter.api.Assertions.*;

public class StaffDAOTest {
    private StaffDAO staff;

    @BeforeEach
    public void setUp() {
        // Initialize a Staff object before each test
        staff = new StaffDAO("John", "Doe", "john.doe@example.com");
    }

    @Test
    public void testGetFullName() {
        // Test the getFullName method
        assertEquals("John Doe", staff.getFullName());
    }

    @Test
    public void testGetEmail() {
        // Test the getEmail method
        assertEquals("john.doe@example.com", staff.getEmail());
    }

}
