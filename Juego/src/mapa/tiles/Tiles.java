package mapa.tiles;

import graficos.Pantalla;
import graficos.Sprite;

public class Tiles {
	public int x;
	public int y;

	public Sprite sprite;
	private boolean solido;

	public static final int LADO = 32;

	// colección de tiles del subterraneo
	public static final Tiles VACIO = new Tiles(Sprite.VACIO, true);

	public static final Tiles PARED_1 = new Tiles(Sprite.PARED_1, true);
	public static final Tiles PARED_2 = new Tiles(Sprite.PARED_2, true);

	public static final Tiles MINA_1 = new Tiles(Sprite.MINA_1);
	public static final Tiles MINA_2 = new Tiles(Sprite.MINA_2);
	public static final Tiles MINA_3 = new Tiles(Sprite.MINA_3);

	public static final Tiles PRE_CAMBIO_MINA = new Tiles(Sprite.PRE_CAMBIO_MINA);
	public static final Tiles PRE_CAMBIO_MINA_2 = new Tiles(Sprite.PRE_CAMBIO_MINA_2);
	public static final Tiles PRE_CAMBIO_MINA_3 = new Tiles(Sprite.PRE_CAMBIO_MINA_3);

	public static final Tiles PARED_MINA_1 = new Tiles(Sprite.PARED_MINA_1);
	public static final Tiles PARED_MINA_2 = new Tiles(Sprite.PARED_MINA_2);

	public static final Tiles PARED_TOTAL = new Tiles(Sprite.PARED_TOTAL);

	public static final Tiles CAMBIO_MINA_1 = new Tiles(Sprite.CAMBIO_MINA_1);
	public static final Tiles CAMBIO_MINA_2 = new Tiles(Sprite.CAMBIO_MINA_2);

	public static final Tiles CONEXION_1 = new Tiles(Sprite.CONEXION_1);
	public static final Tiles CONEXION_2 = new Tiles(Sprite.CONEXION_2);

	public static final Tiles CONEXION_MURO_1 = new Tiles(Sprite.CONEXION_MURO_1);
	public static final Tiles CONEXION_MURO_2 = new Tiles(Sprite.CONEXION_MURO_2);

	public static final Tiles FINAL_1 = new Tiles(Sprite.FINAL_1);
	public static final Tiles FINAL_2 = new Tiles(Sprite.FINAL_2);

	public static final Tiles MINA_PURA = new Tiles(Sprite.MINA_PURA);
	public static final Tiles MINA_PURA_2 = new Tiles(Sprite.MINA_PURA_2);

	public static final Tiles ENTRADA_1 = new Tiles(Sprite.ENTRADA_1);
	public static final Tiles ENTRADA_2 = new Tiles(Sprite.ENTRADA_2);

	public static final Tiles SALIDA_1 = new Tiles(Sprite.SALIDA_1, true);
	public static final Tiles SALIDA_2 = new Tiles(Sprite.SALIDA_2, true);

	public static final Tiles CONEXION_UNICA = new Tiles(Sprite.CONEXION_UNICA);
	public static final Tiles CONEXION_UNICA_2 = new Tiles(Sprite.CONEXION_UNICA_2);

	public static final Tiles BORDE_1 = new Tiles(Sprite.BORDE_1);
	public static final Tiles BORDE_2 = new Tiles(Sprite.BORDE_2);
	// fin de colección tiles del subterraneo
	// colección de tiles
//	public static final Tiles VACIO = new Tiles(Sprite.VACIO);
//	public static final Tiles ASFALTO = new Tiles(Sprite.ASFALTO);
//	public static final Tiles ARENA = new Tiles(Sprite.ARENA);
//	public static final Tiles BORDE_CAMINO = new Tiles(Sprite.BORDE_CAMINO);
//	public static final Tiles BORDE_CAMINO_2 = new Tiles(Sprite.BORDE_CAMINO_2);
//	public static final Tiles BORDE_CAMINO_HORIZONTAL_1 = new Tiles(Sprite.BORDE_CAMINO_HORIZONTAL_1);
//	public static final Tiles BORDE_CAMINO_HORIZONTAL_2 = new Tiles(Sprite.BORDE_CAMINO_HORIZONTAL_2);
//	public static final Tiles LINEA = new Tiles(Sprite.LINEA);
//	public static final Tiles LINEA_2 = new Tiles(Sprite.LINEA_2);
//	public static final Tiles LINEA_3 = new Tiles(Sprite.LINEA_3);
//	public static final Tiles LINEA_4 = new Tiles(Sprite.LINEA_4);
//	public static final Tiles PIEDRA = new Tiles(Sprite.PIEDRA);
//	public static final Tiles MURO = new Tiles(Sprite.MURO);
//	public static final Tiles PUERTA_SUPERIOR_LATERAL = new Tiles(Sprite.PUERTA_SUPERIOR_LATERAL);
//	public static final Tiles PUERTA_SUPERIOR_CENTRAL = new Tiles(Sprite.PUERTA_SUPERIOR_CENTRAL);
//	public static final Tiles PUERTA_SUPERIOR_LATERAL_2 = new Tiles(Sprite.PUERTA_SUPERIOR_LATERAL_2);
//	public static final Tiles CENTRO_CAMINO = new Tiles(Sprite.CENTRO_CAMINO);
//	public static final Tiles CENTRO_CAMINO_HORIZONTAL = new Tiles(Sprite.CENTRO_CAMINO_HORIZONTAL);
//	public static final Tiles ASFALTO_PIEDRA = new Tiles(Sprite.ASFALTO_PIEDRA);
//	public static final Tiles ASFALTO_PIEDRA_2 = new Tiles(Sprite.ASFALTO_PIEDRA_2);
//	public static final Tiles PUERTA_INFERIOR_LATERAL = new Tiles(Sprite.PUERTA_INFERIOR_LATERAL);
//	public static final Tiles PUERTA_INFERIOR_LATERAL_2 = new Tiles(Sprite.PUERTA_INFERIOR_LATERAL_2);
//	public static final Tiles PUERTA_CENTRAL = new Tiles(Sprite.PUERTA_CENTRAL);
//	public static final Tiles PUERTA_ASFALTO = new Tiles(Sprite.PUERTA_ASFALTO);
	// fin de colección de tiles

	public Tiles(Sprite sprite) {
		this.sprite = sprite;
		solido = false;
	}

	public Tiles(Sprite sprite, boolean solido) {
		this.sprite = sprite;
		this.solido = solido;
	}

	public void mostrar(int x, int y, Pantalla pantalla) {
		pantalla.mostrarTiles(x << 5, y << 5, this);
	}

	public boolean esSolido() {
		return solido;
	}
}
