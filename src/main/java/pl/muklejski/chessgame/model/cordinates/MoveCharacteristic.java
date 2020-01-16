package pl.muklejski.chessgame.model.cordinates;

import lombok.Builder;
import lombok.Getter;
import pl.muklejski.chessgame.model.constants.MoveDirection;

@Builder
@Getter
public class MoveCharacteristic {

	private MoveDirection moveDirection;
	private int length;
	private boolean occupiedToField;
	private boolean occupiedFieldsBetween;
	private boolean forwardMove;
}
