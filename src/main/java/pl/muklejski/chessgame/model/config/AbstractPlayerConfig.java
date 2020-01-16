package pl.muklejski.chessgame.model.config;

import java.util.function.Function;
import java.util.function.IntPredicate;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class AbstractPlayerConfig implements PlayerConfig {

	private final Function<Character, Character> nameChanger;
	private final IntPredicate forwardDirection;

	@Override
	public char getNameChanger(char name) {
		return this.nameChanger.apply(name);
	}

	@Override
	public boolean isForwardSign(int moveSign) {
		return this.forwardDirection.test(moveSign);
	}
}
