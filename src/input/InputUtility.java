package input;

import javafx.scene.input.KeyCode;

public class InputUtility {

	private static boolean left = false;
	private static boolean right = false;
	private static boolean up = false;
	private static boolean down = false;

	public static void setKeyPressed(KeyCode keycode) {
		// should make it key trigger !!
		switch (keycode) {
		case W: {
			// System.out.println("W KEY PRESSED");
			if (!down) {
				up = true;
				right = false;
				left = false;
			}
			break;
		}
		case A: {
			// System.out.println("A KEY PRESSED");
			if (!right) {
				left = true;
				up = false;
				down = false;
			}
			break;
		}
		case S: {
			// System.out.println("S KEY PRESSED");
			if (!up) {
				down = true;
				right = false;
				left = false;
			}
			break;
		}
		case D: {
			// System.out.println("D KEY PRESSED");
			if (!left) {
				right = true;
				up = false;
				down = false;
			}
			break;
		}
		default: {
			// might wanna throw exception here
			// System.out.println("OTHER KEY PRESSED");
			break;
		}
		}
	}
	
	public static void reset() {
		down = false;
		up = false;
		right = false;
		left = false;
	}

	public static boolean isLeft() {
		return left;
	}

	public static boolean isRight() {
		return right;
	}

	public static boolean isUp() {
		return up;
	}

	public static boolean isDown() {
		return down;
	}

}
