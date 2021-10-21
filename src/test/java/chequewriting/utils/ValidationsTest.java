package chequewriting.utils;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

class ValidationsTest {

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
        new Executable() {
          @Override
          public void execute() throws Throwable {
            Validations.inputValidation("", "");
          }
        });
  }

  @Test
  @DisplayName("Should throw IllegalArgumentException when supplied with null values")
  void inputValidationForNull() {
    assertThrows(NullPointerException.class,
        new Executable() {
          @Override
          public void execute() throws Throwable {
            Validations.inputValidation(null, null);
          }
        });
  }

  @Test
  @DisplayName("Should display proper exception message for null arguments")
  void inputValidationExceptionMessageNull() {
    NullPointerException nullPointerException = assertThrows(NullPointerException.class,
        new Executable() {
          @Override
          public void execute() throws Throwable {
            Validations.inputValidation(null, null);
          }
        });

    assertEquals(npeMessageNullArguments, nullPointerException.getMessage());

  }

  @Test
  @DisplayName("Should display proper exception message for empty arguments")
  void inputValidationExceptionMessageEmpty() {
    IllegalArgumentException illegalArgumentException = assertThrows(IllegalArgumentException.class,
        new Executable() {
          @Override
          public void execute() throws Throwable {
            Validations.inputValidation("", "");
          }
        });

    assertEquals(iaeMessageEmptyArguments, illegalArgumentException.getMessage());

  }
}