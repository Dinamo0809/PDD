package mapa;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import mapa.tiles.Tiles;

public class MapaCargado extends Mapa {

	private int[] pixeles;

	public MapaCargado(String ruta) {
		super(ruta);
	}

	protected void cargarMapa(String ruta) {
		try {
			BufferedImage imagen = ImageIO.read(MapaCargado.class.getResource(ruta));

			ancho = imagen.getWidth();
			alto = imagen.getHeight();

			tilesLog = new Tiles[ancho * alto];
			pixeles = new int[ancho * alto];

			imagen.getRGB(0, 0, ancho, alto, pixeles, 0, ancho);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	protected void generarMapa() {
		for (int i = 0; i < pixeles.length; i++) {
			switch (pixeles[i]) {
			case 0xff985d31:
				tilesLog[i] = Tiles.PARED_1;
				continue;
			case 0xffcc6d27:
				tilesLog[i] = Tiles.PARED_2;
				continue;
			case 0xff681509:
				tilesLog[i] = Tiles.MINA_1;
				continue;
			case 0xff4b1007:
				tilesLog[i] = Tiles.MINA_2;
				continue;
			case 0xff775b0c:
				tilesLog[i] = Tiles.MINA_3;
				continue;
			case 0xffabb723:
				tilesLog[i] = Tiles.PRE_CAMBIO_MINA;
				continue;
			case 0xff780c2a:
				tilesLog[i] = Tiles.PRE_CAMBIO_MINA_2;
				continue;
			case 0xff7ba76a:
				tilesLog[i] = Tiles.PRE_CAMBIO_MINA_3;
				continue;
			case 0xff355c3a:
				tilesLog[i] = Tiles.PARED_MINA_1;
				continue;
			case 0xff654b89:
				tilesLog[i] = Tiles.PARED_MINA_2;
				continue;
			case 0xff4e321e:
				tilesLog[i] = Tiles.PARED_TOTAL;
				continue;
			case 0xff2b3378:
				tilesLog[i] = Tiles.CAMBIO_MINA_1;
				continue;
			case 0xffa2a7d1:
				tilesLog[i] = Tiles.CAMBIO_MINA_2;
				continue;
			case 0xff0018ff:
				tilesLog[i] = Tiles.CONEXION_1;
				continue;
			case 0xff474f99:
				tilesLog[i] = Tiles.CONEXION_2;
				continue;
			case 0xff5b63ad:
				tilesLog[i] = Tiles.CONEXION_MURO_1;
				continue;
			case 0xff727acc:
				tilesLog[i] = Tiles.CONEXION_MURO_2;
				continue;
			case 0xffff5685:
				tilesLog[i] = Tiles.FINAL_1;
				continue;
			case 0xff6f7183:
				tilesLog[i] = Tiles.FINAL_2;
				continue;
			case 0xff1b215c:
				tilesLog[i] = Tiles.MINA_PURA;
				continue;
			case 0xff383a4f:
				tilesLog[i] = Tiles.MINA_PURA_2;
				continue;
			case 0xff00ff36:
				tilesLog[i] = Tiles.ENTRADA_1;
				continue;
			case 0xff229a3b:
				tilesLog[i] = Tiles.ENTRADA_2;
				continue;
			case 0xff85400d:
				tilesLog[i] = Tiles.SALIDA_1;
				continue;
			case 0xffaa4902:
				tilesLog[i] = Tiles.SALIDA_2;
				continue;
			case 0xffff4d00:
				tilesLog[i] = Tiles.CONEXION_UNICA;
				continue;
			case 0xffb03907:
				tilesLog[i] = Tiles.CONEXION_UNICA_2;
				continue;
			case 0xffcf2f18:
				tilesLog[i] = Tiles.BORDE_1;
				continue;
			case 0xffa1594f:
				tilesLog[i] = Tiles.BORDE_2;
				continue;
			default:
				tilesLog[i] = Tiles.VACIO;
//			case 0xff444444:
//				tilesLog[i] = Tiles.ASFALTO;
//				continue;
//			case 0xffffdf94:
//				tilesLog[i] = Tiles.ARENA;
//				continue;
//			case 0xffcacaca:
//				tilesLog[i] = Tiles.BORDE_CAMINO;
//				continue;
//			case 0xff898989:
//				tilesLog[i] = Tiles.CENTRO_CAMINO;
//				continue;
//			case 0xff242322:
//				tilesLog[i] = Tiles.LINEA;
//				continue;
//			case 0xffcecece:
//				tilesLog[i] = Tiles.PIEDRA;
//				continue;
//			case 0xff393427:
//				tilesLog[i] = Tiles.MURO;
//				continue;
//			case 0xff0c00ff:
//				tilesLog[i] = Tiles.ASFALTO_PIEDRA;
//				continue;
//			case 0xff5c443a:
//				tilesLog[i] = Tiles.PUERTA_SUPERIOR_LATERAL;
//				continue;
//			case 0xff272016:
//				tilesLog[i] = Tiles.PUERTA_INFERIOR_LATERAL;
//				continue;
//			case 0xffff0000:
//				tilesLog[i] = Tiles.PUERTA_SUPERIOR_CENTRAL;
//				continue;
//			case 0xff191919:
//				tilesLog[i] = Tiles.PUERTA_ASFALTO;
//				continue;
//			case 0xff000006:
//				tilesLog[i] = Tiles.PUERTA_CENTRAL;
//				continue;
//			case 0xff521111:
//				tilesLog[i] = Tiles.PUERTA_SUPERIOR_LATERAL_2;
//				continue;
//			case 0xff745f27:
//				tilesLog[i] = Tiles.ASFALTO_PIEDRA_2;
//				continue;
//			case 0xff230606:
//				tilesLog[i] = Tiles.PUERTA_INFERIOR_LATERAL_2;
//				continue;
//			case 0xffbf7f34:
//				tilesLog[i] = Tiles.BORDE_CAMINO_2;
//				continue;
//			case 0xff744b4b:
//				tilesLog[i] = Tiles.CENTRO_CAMINO_HORIZONTAL;
//				continue;
//			case 0xff8c7355:
//				tilesLog[i] = Tiles.BORDE_CAMINO_HORIZONTAL_1;
//				continue;
//			case 0xffaf7e45:
//				tilesLog[i] = Tiles.BORDE_CAMINO_HORIZONTAL_2;
//				continue;
//			case 0xffa46b27:
//				tilesLog[i] = Tiles.LINEA_2;
//				continue;
//			case 0xffff8b00:
//				tilesLog[i] = Tiles.LINEA_3;
//				continue;
//			case 0xff422400:
//				tilesLog[i] = Tiles.LINEA_4;
//				continue;
//
//			default:
//				tilesLog[i] = Tiles.VACIO;
			}
		}
	}
}
