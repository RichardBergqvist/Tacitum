package net.rb.tacitum.graphics.ui;

import java.awt.Color;
import java.awt.Graphics;

import net.rb.tacitum.util.Vector2i;

/**
 * @author Richard Berqvist
 * @since In-Development 10.5
 * @category Graphics
 * **/
public class UIComponent {
	public Vector2i position, size;
	protected Vector2i offset;
	public Color color;
	protected UIPanel panel;
	
	protected boolean active = true;
	
	public UIComponent(Vector2i position) {
		this.position = position;
		this.offset = new Vector2i();
	}
	
	public UIComponent(Vector2i position, Vector2i size) {
		this.position = position;
		this.size = size;
		this.offset = new Vector2i();
	}
	
	void init(UIPanel panel) {
		this.panel = panel;
	}
	
	public UIComponent setColor(int color) {
		this.color = new Color(color);
		return this;
	}
	
	public void update() {}
	
	public void render(Graphics g) {}
	
	public Vector2i getAbsolutePosition() {
		return new Vector2i(position).add(offset);
	} 
	
	void setOffset(Vector2i offset) {
		this.offset = offset;
	}
}