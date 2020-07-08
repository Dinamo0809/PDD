package graficos;

import ente.criaturas.Jugador;
import mapa.tiles.Tiles;

public final class Pantalla {

	private final int ancho;
	private final int alto;

	private int diferenciaX;
	private int diferenciaY;

	public final int[] pixeles;

	public Pantalla(final int ancho, final int alto) {
		this.ancho = ancho;
		this.alto = alto;

		pixeles = new int[ancho * alto];
	}

	public void mostrarTiles(int compensacionX, int compensacionY, Tiles tiles) {
		compensacionX -= diferenciaX;
		compensacionY -= diferenciaY;

		for (int y = 0; y < tiles.sprite.getLado(); y++) {
			int posicionY = y + compensacionY;
			for (int x = 0; x < tiles.sprite.getLado(); x++) {
				int posicionX = x + compensacionX;
				if (posicionX < -tiles.sprite.getLado() || posicionX >= ancho || posicionY < 0 || posicionY >= alto) {
					break;
				}
				if (posicionX < 0) {
					posicionX = 0;
				}
				pixeles[posicionX + posicionY * ancho] = tiles.sprite.pixeles[x + y * tiles.sprite.getLado()];
			}
		}
	}

	public void mostrarJugador(int compensacionX, int compensacionY, Jugador jugador) {
		compensacionX -= diferenciaX;
		compensacionY -= diferenciaY;

		for (int y = 0; y < jugador.getSprite().getLado(); y++) {
			int posicionY = y + compensacionY;
			for (int x = 0; x < jugador.getSprite().getLado(); x++) {
				int posicionX = x + compensacionX;
				if (posicionX < -jugador.getSprite().getLado() || posicionX >= ancho || posicionY < 0
						|| posicionY >= alto) {
					break;
				}
				if (posicionX < 0) {
					posicionX = 0;
				}
				int colorPixelJugador = jugador.getSprite().pixeles[x + y * jugador.getSprite().getLado()];
				if (colorPixelJugador != 0xffff00ff) {
					pixeles[posicionX + posicionY * ancho] = colorPixelJugador;
				}
			}
		}
	}

	public void esstableceDiferencia(final int diferenciaX, final int diferenciaY) {
		this.diferenciaX = diferenciaX;
		this.diferenciaY = diferenciaY;
	}

	public int getAncho() {
		return ancho;
	}

	public int getAlto() {
		return alto;
	}
}