package net.rb.tacitum.graphics;

/**
 * @author Richard Berqvist
 * @since In-Development 10.0
 * @category Graphics
 * **/
public class Font {
	private static SpriteSheet font = new SpriteSheet("/textures/font/font.png", 16);
	private static Sprite[] characters = Sprite.split(font);
	private static String charIndex = "ABCDEFGHIJKLM" + //
									  "NOPQRSTUVWXYZ" + //
									  "abcdefghijklm" + //
									  "nopqrstuvwxyz" + //
									  "0123456789.,'" + //
									  "'\"\":;?!@|%()"+ //
									  "-_+*&=#<>^[]{}"+ //
									  "�$�";
	
	public Font() {
		
	}
	
	public void render(int x, int y, String text, Screen screen) {
		render(x, y, 0, 0, text, screen);
	}
	
	public void render(int x, int y, int color, String text, Screen screen) {
		render(x, y, 0, color, text, screen);
	}
	
	public void render(int x, int y, int spacing, int color, String text, Screen screen) {
		int xOffset = 0;
		int line = 0;
		for (int i = 0; i < text.length(); i++) {
			xOffset += 16 + spacing;
			int yOffset = 0;
			char currentChar = text.charAt(i);
			if (currentChar == 'g' || currentChar == 'j' || currentChar == 'p' || currentChar == 'q' || currentChar == 'y'  || currentChar == ',') yOffset = 4;
			if (currentChar == '\n') {
				xOffset = 0;
				line++;
			}
			int index = charIndex.indexOf(currentChar);
			if (index == -1) continue;
			screen.renderTextCharacter(x + xOffset, y + line * 20 + yOffset, characters[index], color, false);
		}
	}
}