package pl.muklejski.chessgame.model.config;

public class Player1Config extends AbstractPlayerConfig {

	public Player1Config() {
		super(Character::toUpperCase, moveSign -> moveSign == -1);
	}
}
