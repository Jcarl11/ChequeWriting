package chequewriting.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Validations {

  private static final Logger logger = LoggerFactory.getLogger(Validations.class);

  public static final void inputValidation(String amount, String currency)
      throws IllegalArgumentException, NullPointerException {
    logger.trace("Entering inputValidation()");

    if (amount == null || currency == null) {
      throw new NullPointerException("Arguments cannot be null");
    }

    String amountTemp = amount.trim().toLowerCase();
    String currencyTemp = currency.trim().toLowerCase();

    if (amountTemp.isEmpty() || currencyTemp.isEmpty()) {
      throw new IllegalArgumentException("Arguments cannot be empty");
    }

    logger.debug("Amount = {}, currency = {}", amountTemp, currency);
    logger.trace("Exiting inputValidation()...");
  }

}
