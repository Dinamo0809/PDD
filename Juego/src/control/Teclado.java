package control;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public final class Teclado implements KeyListener {

	private final static int keynum = 120;
	private final boolean[] teclas = new boolean[keynum];

	public boolean arriba;
	public boolean abajo;
	public boolean izquierda;
	public boolean derecha;
	public boolean sinbordes;
	public boolean salir;
	public boolean correr;

	public void actualizar() {
		arriba = teclas[KeyEvent.VK_W];
		abajo = teclas[KeyEvent.VK_S];
		izquierda = teclas[KeyEvent.VK_A];
		derecha = teclas[KeyEvent.VK_D];
		salir = teclas[KeyEvent.VK_F4];
		correr = teclas[KeyEvent.VK_SHIFT];
	}

	public void keyPressed(KeyEvent e) {
		teclas[e.getKeyCode()] = true;
	}

	public void keyReleased(KeyEvent e) {
		teclas[e.getKeyCode()] = false;
	}

	public void keyTyped(KeyEvent arg0) {
	}

}
