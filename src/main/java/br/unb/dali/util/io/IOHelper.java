package br.unb.dali.util.io;

import java.math.BigDecimal;
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
	  
	  /**
	     * Round to certain number of decimals
	     * 
	     * @param d
	     * @param decimalPlace
	     * @return
	     */
	    public static float round(float d, int decimalPlace) {
	        BigDecimal bd = new BigDecimal(Float.toString(d));
	        bd = bd.setScale(decimalPlace, BigDecimal.ROUND_HALF_UP);
	        return bd.floatValue();
	    }
}
