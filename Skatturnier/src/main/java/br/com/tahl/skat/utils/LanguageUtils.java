package br.com.tahl.skat.utils;

import java.util.Locale;

public class LanguageUtils {
	
	public static Locale[] getLocaleFromAcceptLanguage(String acceptLanguage) {
		String[] languages = acceptLanguage.split(",");
		int len = languages.length;
		Locale[] locales = new Locale[len];
		
		for (int l = 0; l < len; l++) {
			String[] arr = languages[l].trim().replace("-", "_").split(";");
			
			if (arr.length > 0) {
				//Parse the locale
				Locale locale = null;
				String[] lan = arr[0].split("_");
				switch(lan.length) {
					case 2: locale = new Locale(lan[0], lan[1]); break;
					case 3: locale = new Locale(lan[0], lan[1], lan[2]); break;
					default: locale = new Locale(lan[0]); break;
				}
				locales[l] = locale;
			}
		}
		return locales;
	}
	
	public static Locale getMainLocaleFromAcceptLanguage(String acceptLanguage) {
		Locale[] l = getLocaleFromAcceptLanguage(acceptLanguage);
		
		return l.length > 0 ? l[0] : null;
	}
	
}
