package chequewriting.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Validations {

  private static final Logger logger = LoggerFactory.getLogger(Validations.class);

  /*
  *   Return: returns only true if only if the arguments are valid
  *           else will throw an exception
  * */
  public static final boolean inputValidation(String amount, String currency)
      throws IllegalArgumentException, NullPointerException {
    logger.trace("Entering inputValidation()");

    boolean isValid = false;

    if (amount == null || currency == null) {
      throw new NullPointerException("Arguments cannot be null");
    }

    if (amount.trim().isEmpty() || currency.trim().isEmpty()) {
      throw new IllegalArgumentException("Arguments cannot be empty");
    }

    isValid = true;
    logger.debug("Amount = {}, currency = {}", amount, currency);
    logger.trace("Exiting inputValidation()...");

    return isValid;
  }

}
