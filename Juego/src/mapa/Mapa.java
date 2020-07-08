package mapa;

import graficos.Pantalla;
import mapa.tiles.Tiles;

public abstract class Mapa {
	protected int ancho;
	protected int alto;

	protected int[] tiles;
	protected Tiles[] tilesLog;

	public Mapa(int ancho, int alto) {
		this.ancho = ancho;
		this.alto = alto;

		tiles = new int[ancho * alto];
		generarMapa();
	}

	public Mapa(String ruta) {
		cargarMapa(ruta);
		generarMapa();
	}

	protected void generarMapa() {
	}

	protected void cargarMapa(String ruta) {
	}

	public void actualizar() {
	}

	public void mostrar(final int compensacionX, final int compensacionY, final Pantalla pantalla) {

		pantalla.esstableceDiferencia(compensacionX, compensacionY);

		int o = compensacionX >> 5;
		int ea = (compensacionX + pantalla.getAncho() + Tiles.LADO) >> 5;
		int n = compensacionY >> 5;
		int s = (compensacionY + pantalla.getAlto() + Tiles.LADO) >> 5;

		for (int y = n; y < s; y++) {
			for (int x = o; x < ea; x++) {
				if (x < 0 || y < 0 || x >= ancho || y >= alto) {
					Tiles.VACIO.mostrar(x, y, pantalla);
				} else {
					tilesLog[x + y * ancho].mostrar(x, y, pantalla);
				}
			}
		}
	}

	public Tiles getTilesLog(int posicion) {
		return tilesLog[posicion];
	}

	public Tiles getTiles(final int x, final int y) {
		if (x < 0 || y < 0 || x >= ancho || y >= alto) {
			return Tiles.VACIO;
		}
		switch (tiles[x + y * ancho]) {
		case 0:
			return Tiles.CONEXION_1;
		case 1:
			return Tiles.CONEXION_2;
		case 2:
			return Tiles.CONEXION_MURO_1;
		case 3:
			return Tiles.CONEXION_MURO_2;
		case 4:
			return Tiles.CONEXION_UNICA;
		case 5:
			return Tiles.CONEXION_UNICA_2;
		case 6:
			return Tiles.ENTRADA_1;
		case 7:
			return Tiles.ENTRADA_2;
		case 8:
			return Tiles.FINAL_1;
		case 9:
			return Tiles.FINAL_2;
		case 10:
			return Tiles.MINA_1;
		case 11:
			return Tiles.MINA_2;
		case 12:
			return Tiles.MINA_3;
		case 13:
			return Tiles.MINA_PURA;
		case 14:
			return Tiles.PARED_1;
		case 15:
			return Tiles.PARED_2;
		case 16:
			return Tiles.PARED_MINA_1;
		case 17:
			return Tiles.PARED_MINA_2;
		case 18:
			return Tiles.PARED_TOTAL;
		case 19:
			return Tiles.PRE_CAMBIO_MINA;
		case 20:
			return Tiles.PRE_CAMBIO_MINA_2;
		case 21:
			return Tiles.SALIDA_1;
		case 22:
			return Tiles.SALIDA_2;
		case 23:
			return Tiles.PRE_CAMBIO_MINA_3;
		default:
			return Tiles.VACIO;
//		case 0:
//			return Tiles.ASFALTO;
//		case 1:
//			return Tiles.ARENA;
//		case 2:
//			return Tiles.BORDE_CAMINO;
//		case 3:
//			return Tiles.CENTRO_CAMINO;
//		case 4:
//			return Tiles.LINEA;
//		case 5:
//			return Tiles.MURO;
//		case 6:
//			return Tiles.PIEDRA;
//		case 7:
//			return Tiles.PUERTA_ASFALTO;
//		case 8:
//			return Tiles.PUERTA_CENTRAL;
//		case 9:
//			return Tiles.PUERTA_INFERIOR_LATERAL;
//		case 10:
//			return Tiles.PUERTA_SUPERIOR_CENTRAL;
//		case 11:
//			return Tiles.PUERTA_INFERIOR_LATERAL;
//		case 12:
//			return Tiles.ASFALTO_PIEDRA;
//		default:
//			return Tiles.VACIO;
		}
	}

	public int getAncho() {
		return ancho;

	}
}