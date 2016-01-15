package br.unb.dali.util.io;

import java.math.BigInteger;
import java.security.SecureRandom;

public class Misc {
	  private static SecureRandom random = new SecureRandom();

	  public static String getRandomString() {
	    return new BigInteger(130, random).toString(32);
	  }
}
