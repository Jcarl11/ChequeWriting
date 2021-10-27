package chequewriting.main;

import chequewriting.utils.Validations;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ChequeWriting {

  private static final Logger logger = LoggerFactory.getLogger(ChequeWriting.class);

  /*
   * Sample input:
   * amount = 20,340.15
   * currency = AUD
   * */
  public static void parse(String amount, String currency) {
    boolean result = Validations.inputValidation("20,340.15","AUD");

  }

  private static List<String> translateToWords(String amount) {
    logger.trace("in translateToWords()...");
    String tempVariable = null;
    List<String> wordsStorage = new ArrayList<>();
    for (char character : amount.trim().toLowerCase().toCharArray()) {
      tempVariable += character;
      if(character == ',') {

      }
    }

    return null;
  }

}
