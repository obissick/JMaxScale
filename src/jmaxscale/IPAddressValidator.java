/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jmaxscale;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author obissick
 */
public class IPAddressValidator {
    private Pattern pattern;
    private Matcher matcher;

    private static final String IPADDRESS_PATTERN =
		"^([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])\\." +
		"([01]?\\d\\d?|2[0-4]\\d|25[0-5])$";

    public IPAddressValidator(){
	  pattern = Pattern.compile(IPADDRESS_PATTERN);
    }

   /**
    * Validate ip address with regular expression
    * @param ip ip address for validation
    * @return true valid ip address, false invalid ip address
    */
    public boolean validate(final String ip){
	  matcher = pattern.matcher(ip);
	  return matcher.matches();
    }
}
