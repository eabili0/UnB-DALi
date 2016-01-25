package br.unb.dali.util.io;

import java.math.BigInteger;
import java.security.SecureRandom;

/**
 * This class provides a method repository to help deal with IO
 *  
 * @author abiliooliveira
 */
public class IOHelper {
	  private static SecureRandom random = new SecureRandom();
	  
	  /**
	   * @return a secure random string
	   */
	  public static String getRandomString() {
	    return new BigInteger(130, random).toString(32);
	  }
}
