package com.chequewriting.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

class ValidationsTest {

  private static final Logger logger = LoggerFactory.getLogger(ValidationsTest.class);
  private static String npeMessageNullArguments;
  private static String iaeMessageEmptyArguments;

  @BeforeAll
  static void beforeAll() {
    npeMessageNullArguments = "Arguments cannot be null";
    iaeMessageEmptyArguments = "Arguments cannot be empty";
  }

  @BeforeEach
  void setUp() {
  }

  @Test
  @DisplayName("Should throw IllegalArgumentException when supplied with empty string")
  void inputValidationForEmptyString() {
    assertThrows(IllegalArgumentException.class,
        () -> Validations.inputValidation("", ""));
  }

  @Test
  @DisplayName("Should throw IllegalArgumentException when supplied with null values")
  void inputValidationForNull() {
    assertThrows(NullPointerException.class,
        () -> Validations.inputValidation(null, null));
  }

  @Test
  @DisplayName("Should display proper exception message for null arguments")
  void inputValidationExceptionMessageNull() {
    NullPointerException nullPointerException = assertThrows(NullPointerException.class,
        () -> Validations.inputValidation(null, null));

    assertEquals(npeMessageNullArguments, nullPointerException.getMessage());

  }

  @Test
  @DisplayName("Should display proper exception message for empty arguments")
  void inputValidationExceptionMessageEmpty() {
    IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
        () -> Validations.inputValidation("", ""));

    assertEquals(iaeMessageEmptyArguments, illegalArgumentException.getMessage());

  }

  @Test
  @DisplayName("Test if supplied with correct arguments")
  void inputValidationPositiveScenario() {
    boolean result = Validations.inputValidation("1234.56","USD");
    assertEquals(true, result);
  }
}