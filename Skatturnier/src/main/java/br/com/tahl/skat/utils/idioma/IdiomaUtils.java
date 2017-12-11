package br.com.tahl.skat.utils.idioma;

import java.util.Locale;
import java.util.ResourceBundle;

public class IdiomaUtils {
	
	public static Locale[] getLocaleAcceptLanguage(String acceptLanguage) {
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
	
	public static Locale getLocalePrincipalAcceptLanguage(String acceptLanguage) {
		Locale[] l = getLocaleAcceptLanguage(acceptLanguage);
		return l.length > 0 ? l[0] : null;
	}
	
	public static String getTraducao(String chave, String idioma) {
		Locale locale = new Locale(idioma);
		ResourceBundle rb = ResourceBundle.getBundle("br.com.tahl.skat.messages.messages", locale);
		
		return rb.getString(chave);
	}
}
