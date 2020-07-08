package graficos;

public final class Sprite {
	private final int lado;

	private int x;
	private int y;

	public int[] pixeles;
	private HojaSprites hoja;

	// colección de sprites del personaje
	public static final Sprite FRENTE_0 = new Sprite(32, 0, 0, 0, HojaSprites.jugador_1);
	public static final Sprite FRENTE_1 = new Sprite(32, 0, 1, 0, HojaSprites.jugador_1);
	public static final Sprite FRENTE_2 = new Sprite(32, 0, 2, 0, HojaSprites.jugador_1);

	public static final Sprite ESPALDA_0 = new Sprite(32, 1, 0, 0, HojaSprites.jugador_1);
	public static final Sprite ESPALDA_1 = new Sprite(32, 1, 1, 0, HojaSprites.jugador_1);
	public static final Sprite ESPALDA_2 = new Sprite(32, 1, 2, 0, HojaSprites.jugador_1);

	public static final Sprite DERECHO_0 = new Sprite(32, 2, 0, 0, HojaSprites.jugador_1);
	public static final Sprite DERECHO_1 = new Sprite(32, 2, 1, 0, HojaSprites.jugador_1);
	public static final Sprite DERECHO_2 = new Sprite(32, 2, 2, 0, HojaSprites.jugador_1);

	public static final Sprite IZQUIERDA_0 = new Sprite(32, 3, 0, 0, HojaSprites.jugador_1);
	public static final Sprite IZQUIERDA_1 = new Sprite(32, 3, 1, 0, HojaSprites.jugador_1);
	public static final Sprite IZQUIERDA_2 = new Sprite(32, 3, 2, 0, HojaSprites.jugador_1);
	// fin de la colección

//	// colección de sprites del mapa subterraneo
	public static final Sprite VACIO = new Sprite(32, 0);

	public static final Sprite PARED_1 = new Sprite(32, 0, 3, 0, HojaSprites.desierto);
	public static final Sprite PARED_2 = new Sprite(32, 0, 3, 2, HojaSprites.desierto);

	public static final Sprite MINA_1 = new Sprite(32, 1, 3, 0, HojaSprites.desierto);
	public static final Sprite MINA_2 = new Sprite(32, 1, 3, 2, HojaSprites.desierto);
	public static final Sprite MINA_3 = new Sprite(32, 1, 3, 4, HojaSprites.desierto);

	public static final Sprite PRE_CAMBIO_MINA = new Sprite(32, 2, 3, 0, HojaSprites.desierto);
	public static final Sprite PRE_CAMBIO_MINA_2 = new Sprite(32, 2, 3, 3, HojaSprites.desierto);
	public static final Sprite PRE_CAMBIO_MINA_3 = new Sprite(32, 2, 3, 2, HojaSprites.desierto);

	public static final Sprite PARED_MINA_1 = new Sprite(32, 0, 4, 0, HojaSprites.desierto);
	public static final Sprite PARED_MINA_2 = new Sprite(32, 0, 4, 2, HojaSprites.desierto);

	public static final Sprite PARED_TOTAL = new Sprite(32, 0, 5, 0, HojaSprites.desierto);

	public static final Sprite CAMBIO_MINA_1 = new Sprite(32, 1, 4, 0, HojaSprites.desierto);
	public static final Sprite CAMBIO_MINA_2 = new Sprite(32, 1, 4, 3, HojaSprites.desierto);

	public static final Sprite CONEXION_1 = new Sprite(32, 2, 4, 0, HojaSprites.desierto);
	public static final Sprite CONEXION_2 = new Sprite(32, 2, 4, 2, HojaSprites.desierto);

	public static final Sprite CONEXION_MURO_1 = new Sprite(32, 1, 5, 0, HojaSprites.desierto);
	public static final Sprite CONEXION_MURO_2 = new Sprite(32, 1, 5, 2, HojaSprites.desierto);

	public static final Sprite FINAL_1 = new Sprite(32, 2, 5, 0, HojaSprites.desierto);
	public static final Sprite FINAL_2 = new Sprite(32, 2, 5, 2, HojaSprites.desierto);

	public static final Sprite MINA_PURA = new Sprite(32, 0, 6, 0, HojaSprites.desierto);
	public static final Sprite MINA_PURA_2 = new Sprite(32, 0, 6, 2, HojaSprites.desierto);

	public static final Sprite ENTRADA_1 = new Sprite(32, 1, 6, 0, HojaSprites.desierto);
	public static final Sprite ENTRADA_2 = new Sprite(32, 1, 6, 2, HojaSprites.desierto);

	public static final Sprite SALIDA_1 = new Sprite(32, 2, 6, 0, HojaSprites.desierto);
	public static final Sprite SALIDA_2 = new Sprite(32, 2, 6, 2, HojaSprites.desierto);

	public static final Sprite CONEXION_UNICA = new Sprite(32, 0, 7, 0, HojaSprites.desierto);
	public static final Sprite CONEXION_UNICA_2 = new Sprite(32, 0, 7, 2, HojaSprites.desierto);

	public static final Sprite BORDE_1 = new Sprite(32, 1, 7, 0, HojaSprites.desierto);
	public static final Sprite BORDE_2 = new Sprite(32, 1, 7, 2, HojaSprites.desierto);
	// fin de colección de mapa del subterráneo

	// colección de sprites del mapa 1
//	public static final Sprite VACIO = new Sprite(32, 0);
//	public static final Sprite ASFALTO = new Sprite(32, 0, 0, 0, HojaSprites.desierto);
//	public static final Sprite ARENA = new Sprite(32, 1, 0, 0, HojaSprites.desierto);
//	public static final Sprite BORDE_CAMINO = new Sprite(32, 2, 0, 0, HojaSprites.desierto);
//	public static final Sprite BORDE_CAMINO_2 = new Sprite(32, 2, 0, 2, HojaSprites.desierto);
//	public static final Sprite BORDE_CAMINO_HORIZONTAL_1 = new Sprite(32, 2, 0, 4, HojaSprites.desierto);
//	public static final Sprite BORDE_CAMINO_HORIZONTAL_2 = new Sprite(32, 2, 0, 5, HojaSprites.desierto);
//	public static final Sprite LINEA = new Sprite(32, 4, 0, 0, HojaSprites.desierto);
//	public static final Sprite LINEA_2 = new Sprite(32, 4, 0, 2, HojaSprites.desierto);
//	public static final Sprite LINEA_3 = new Sprite(32, 4, 0, 6, HojaSprites.desierto);
//	public static final Sprite LINEA_4 = new Sprite(32, 4, 0, 3, HojaSprites.desierto);
//	public static final Sprite PIEDRA = new Sprite(32, 5, 0, 0, HojaSprites.desierto);
//	public static final Sprite MURO = new Sprite(32, 6, 0, 0, HojaSprites.desierto);
//	public static final Sprite PUERTA_SUPERIOR_LATERAL = new Sprite(32, 7, 0, 0, HojaSprites.desierto);
//	public static final Sprite PUERTA_SUPERIOR_LATERAL_2 = new Sprite(32, 7, 0, 2, HojaSprites.desierto);
//	public static final Sprite PUERTA_SUPERIOR_CENTRAL = new Sprite(32, 8, 0, 0, HojaSprites.desierto);
//	public static final Sprite CENTRO_CAMINO = new Sprite(32, 3, 1, 0, HojaSprites.desierto);
//	public static final Sprite CENTRO_CAMINO_HORIZONTAL = new Sprite(32, 3, 1, 4, HojaSprites.desierto);
//	public static final Sprite ASFALTO_PIEDRA = new Sprite(32, 6, 1, 0, HojaSprites.desierto);
//	public static final Sprite ASFALTO_PIEDRA_2 = new Sprite(32, 6, 1, 2, HojaSprites.desierto);
//	public static final Sprite PUERTA_INFERIOR_LATERAL = new Sprite(32, 7, 1, 0, HojaSprites.desierto);
//	public static final Sprite PUERTA_INFERIOR_LATERAL_2 = new Sprite(32, 7, 1, 2, HojaSprites.desierto);
//	public static final Sprite PUERTA_CENTRAL = new Sprite(32, 8, 1, 0, HojaSprites.desierto);
//	public static final Sprite PUERTA_ASFALTO = new Sprite(32, 8, 2, 0, HojaSprites.desierto);
	// fin de la colección de sprite 1

	public Sprite(final int lado, final int columna, final int fila, final int version, final HojaSprites hoja) {
		this.lado = lado;

		pixeles = new int[lado * lado];

		this.x = columna * lado;
		this.y = fila * lado;
		this.hoja = hoja;

		cargarSprite(version);

	}

	public Sprite(final int lado, final int color) {
		this.lado = lado;
		pixeles = new int[lado * lado];

		for (int i = 0; i < pixeles.length; i++) {
			pixeles[i] = color;
		}
	}

	public int getLado() {
		return lado;
	}

	private void cargarSprite(int version) {
		if (version == 0) {
			cargaNormal();
		} else {
			cargaManipulada(version);
		}
	}

	private void cargaNormal() {
		for (int y = 0; y < lado; y++) {
			for (int x = 0; x < lado; x++) {
				pixeles[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.getAncho()];
			}
		}
	}

	private void cargaManipulada(int version) {
		int[] pixelesTemporales = iniciarPixelesTemporales();

		switch (version) {
		case 1:
			invertirXY(pixelesTemporales);
			break;
		case 2:
			invertirX(pixelesTemporales);
			break;
		case 3:
			invertirY(pixelesTemporales);
			break;
		case 4:
			left90(pixelesTemporales);
			break;
		case 5:
			right90(pixelesTemporales);
			break;
		case 6:
			rotarY90Left(pixelesTemporales);
			break;
		case 7:
			rotarY90Right(pixelesTemporales);
			break;
		default:
			cargaNormal();
		}
	}

	private int[] iniciarPixelesTemporales() {
		int[] pixelesTemporales = new int[lado * lado];
		for (int y = 0; y < lado; y++) {
			for (int x = 0; x < lado; x++) {
				pixelesTemporales[x + y * lado] = hoja.pixeles[(x + this.x) + (y + this.y) * hoja.getAncho()];
			}
		}
		return pixelesTemporales;
	}

//1	
	private void invertirXY(int[] pixelesTemporales) {
		for (int i = 0; i < pixeles.length; i++) {
			pixeles[i] = pixelesTemporales[pixelesTemporales.length - 1 - i];
		}
	}

//2	
	private void invertirX(int[] pixelesTemporales) {
		int i = 0;
		for (int y = 0; y < lado; y++) {
			for (int x = lado - 1; x > -1; x--) {
				pixeles[i] = pixelesTemporales[x + y * lado];
				i++;
			}
		}
	}

//3
	private void invertirY(int[] pixelesTemporales) {
		int i = 0;
		for (int y = lado - 1; y > -1; y--) {
			for (int x = 0; x < lado; x++) {
				pixeles[i] = pixelesTemporales[x + y * lado];
				i++;
			}
		}
	}

//4
	private void left90(int[] pixelesTemporales) {
		int i = 0;
		for (int x = lado - 1; x > -1; x--) {
			for (int y = 0; y < lado; y++) {
				pixeles[i] = pixelesTemporales[x + y * lado];
				i++;
			}
		}
	}

//5	
	private void right90(int[] pixelesTemporales) {
		int i = 0;
		for (int x = 0; x < lado; x++) {
			for (int y = lado - 1; y > -1; y--) {
				pixeles[i] = pixelesTemporales[x + y * lado];
				i++;
			}
		}
	}

//6
	private void rotarY90Left(int[] pixelesTemporales) {
		int i = 0;
		for (int x = 0; x < lado; x++) {
			for (int y = 0; y < lado; y++) {
				pixeles[i] = pixelesTemporales[x + y * lado];
				i++;
			}
		}
	}

//7	
	private void rotarY90Right(int[] pixelesTemporales) {
		int i = 0;
		for (int x = lado - 1; x > -1; x--) {
			for (int y = lado - 1; y > -1; y--) {
				pixeles[i] = pixelesTemporales[x + y * lado];
				i++;
			}
		}
	}
}