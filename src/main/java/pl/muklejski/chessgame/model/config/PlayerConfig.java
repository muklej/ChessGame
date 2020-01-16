package pl.muklejski.chessgame.model.config;


public interface PlayerConfig {

	char getNameChanger(char name);
	boolean isForwardSign(int moveSign);
}
