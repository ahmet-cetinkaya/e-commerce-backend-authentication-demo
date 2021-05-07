package core.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validation {
	public static void validateEmail(final String email) throws Exception {
		final String regex = "^(.+)@(.+)$";
		final Pattern pattern = Pattern.compile(regex);
		final Matcher matcher = pattern.matcher(email);
		if (!matcher.find())
			throw new Exception("Invalid e-mail address.");
	}

	public static void validateFieldsEmpty(final String... fields) throws Exception {
		for (final String field : fields)
			if (field.isEmpty())
				throw new Exception("Fill in the required fields.");
	}

}
