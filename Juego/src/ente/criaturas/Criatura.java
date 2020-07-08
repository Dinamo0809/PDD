package ente.criaturas;

import ente.Ente;
import graficos.Sprite;

public abstract class Criatura extends Ente {
	protected Sprite sprite;
	protected char direccion = 'n';
	protected boolean enMovimiento = false;

	public void actualizar() {
	}

	public void mostrar() {
	}

	public void mover(int desplazamientoX, int desplazamientoY) {
		if (desplazamientoX > 0) {
			direccion = 'e';
		}
		if (desplazamientoX < 0) {
			direccion = 'o';
		}
		if (desplazamientoY < 0) {
			direccion = 'n';
		}
		if (desplazamientoY > 0) {
			direccion = 's';
		}

		if (!estaEliminado()) {
			if (!enColision(desplazamientoX, 0)) {
				modificarPosicionX(desplazamientoX);
			}
			if (!enColision(0, desplazamientoY)) {
				modificarPosicionY(desplazamientoY);
			}
		}
	}

	private boolean enColision(int desplazamientoX, int desplazamientoY) {

		boolean colision = false;

		int posicionX = x + desplazamientoX;
		int posicionY = y + desplazamientoY;

		int margenIzquierdo = -10;
		int margenDerecho = 18;
		int margenSuperior = -10;
		int margenInferior = 31;

		int bordeIzquierdo = (posicionX + margenDerecho) / sprite.getLado();
		int bordeDerecho = (posicionX + margenDerecho + margenIzquierdo) / sprite.getLado();
		int bordeSuperior = (posicionY + margenInferior) / sprite.getLado();
		int bordeInferior = (posicionY + margenInferior + margenSuperior) / sprite.getLado();

		if (mapa.getTilesLog(bordeIzquierdo + bordeSuperior * mapa.getAncho()).esSolido()) {
			colision = true;
		}

		if (mapa.getTilesLog(bordeIzquierdo + bordeInferior * mapa.getAncho()).esSolido()) {
			colision = true;
		}

		if (mapa.getTilesLog(bordeDerecho + bordeSuperior * mapa.getAncho()).esSolido()) {
			colision = true;
		}

		if (mapa.getTilesLog(bordeDerecho + bordeInferior * mapa.getAncho()).esSolido()) {
			colision = true;
		}

		return colision;
	}

	public Sprite getSprite() {
		return sprite;
	}
}