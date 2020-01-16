package pl.muklejski.chessgame.model.config;

public class Player2Config extends AbstractPlayerConfig {

	public Player2Config() {
		super(Character::toLowerCase, moveSign -> moveSign == 1);
	}
}
