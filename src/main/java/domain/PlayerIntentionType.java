package domain;

import java.util.Arrays;

public enum PlayerIntentionType {
	YES("y"),
	NO("n");

	private static final String INVALID_INPUT_EXCEPTION_MESSAGE = "옳지 않은 입력입니다.";
	private final String value;

	PlayerIntentionType(String value) {
		this.value = value;
	}

	public static PlayerIntentionType of(String input) {
		return Arrays.stream(PlayerIntentionType.values())
				.filter(value -> value.getValue().equals(input))
				.findFirst()
				.orElseThrow(() -> new NullPointerException(INVALID_INPUT_EXCEPTION_MESSAGE));
	}

	public static boolean isYes(PlayerIntentionType value) {
		return YES.equals(value);
	}

	public String getValue() {
		return value;
	}
}