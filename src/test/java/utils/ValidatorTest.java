package utils;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@DisplayName("A test case for validator")
public class ValidatorTest {

    @Test
    @DisplayName("check for valid and non valid words.")
    public void checkOnlyContainAlphanumeric() {
        assertTrue(Validator.checkOnlyContainAlphanumeric("Rohit"));
        assertTrue(Validator.checkOnlyContainAlphanumeric("Rohit20"));

        assertFalse(Validator.checkOnlyContainAlphanumeric("Rohit20-"));
    }
}