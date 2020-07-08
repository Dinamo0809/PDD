package ente.criaturas;

import control.Teclado;
import graficos.Pantalla;
import graficos.Sprite;
import mapa.Mapa;

public class Jugador extends Criatura {

	private Teclado teclado;

	private int animacion;

	public Jugador(Mapa mapa, Teclado teclado, Sprite sprite) {
		this.mapa = mapa;
		this.teclado = teclado;
		this.sprite = sprite;
	}

	public Jugador(Mapa mapa, Teclado teclado, Sprite sprite, int posicionX, int posicionY) {
		this(mapa, teclado, sprite);
		this.x = posicionX;
		this.y = posicionY;
	}

	public void actualizar() {

		int desplazamientoX = 0;
		int desplazamientoY = 0;
		int velocidad = 1;

		if (animacion < 32767) {
			animacion++;
		} else {
			animacion = 0;
		}

		if (teclado.correr) {
			velocidad = 2;
		}

		if (teclado.arriba) {
			desplazamientoY -= velocidad;
		}
		if (teclado.abajo) {
			desplazamientoY += velocidad;
		}
		if (teclado.derecha) {
			desplazamientoX += velocidad;
		}
		if (teclado.izquierda) {
			desplazamientoX -= velocidad;
		}

		if (desplazamientoX != 0 || desplazamientoY != 0) {
			mover(desplazamientoX, desplazamientoY);
			enMovimiento = true;
		} else {
			enMovimiento = false;
		}

		int resto = animacion % 40;

		if (direccion == 'n') {
			sprite = Sprite.ESPALDA_0;
			if (enMovimiento) {
				if (enMovimiento) {
					if (enMovimiento) {
						if (animacion % 30 > 15) {
							sprite = Sprite.ESPALDA_1;
						} else {
							sprite = Sprite.ESPALDA_2;
						}
					}
				}
			}
		}
		if (direccion == 's') {
			sprite = Sprite.FRENTE_0;
			if (enMovimiento) {
				if (animacion % 30 > 15) {
					sprite = Sprite.FRENTE_1;
				} else {
					sprite = Sprite.FRENTE_2;
				}
			}
		}
		if (direccion == 'o') {
			sprite = Sprite.IZQUIERDA_0;
			if (enMovimiento) {
				if (resto > 10 && resto <= 20) {
					sprite = Sprite.IZQUIERDA_1;
				} else if (resto > 20 && resto <= 30) {
					sprite = Sprite.IZQUIERDA_0;
				} else if (resto > 30) {
					sprite = Sprite.IZQUIERDA_2;
				} else {
					sprite = Sprite.IZQUIERDA_0;
				}
			}
		}
		if (direccion == 'e') {
			sprite = Sprite.DERECHO_0;
			if (enMovimiento) {
				if (resto > 10 && resto <= 20) {
					sprite = Sprite.DERECHO_1;
				} else if (resto > 20 && resto <= 30) {
					sprite = Sprite.DERECHO_0;
				} else if (resto > 30) {
					sprite = Sprite.DERECHO_2;
				} else {
					sprite = Sprite.DERECHO_0;
				}
			}
		}
		mover(desplazamientoX, desplazamientoY);
	}

	public void mostrar(Pantalla pantalla) {
		pantalla.mostrarJugador(x, y, this);
	}
}
