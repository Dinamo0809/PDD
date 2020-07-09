package principal.inventario.armas;

import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.Random;

import principal.Constantes;
import principal.entes.Jugador;
import principal.inventario.Objeto;
import principal.sprites.HojaSprites;
import principal.sprites.Sprites;

public abstract class Arma extends Objeto {

	public static HojaSprites hojaArmas = new HojaSprites(Constantes.RUTA_OBJETOS_ARMAS, Constantes.LADO_SPRITE, false);

	protected int atqMinimo;
	protected int atqMaximo;

	public Arma(int id, String nombre, String descripcion, int atqMinimo, int atqMaximo) {
		super(id, nombre, descripcion);

		this.atqMinimo = atqMinimo;
		this.atqMaximo = atqMaximo;
	}

	public Arma(int id, String nombre, String descripcion, int cantidad, int atqMinimo, int atqMaximo) {
		super(id, nombre, descripcion, cantidad);

		this.atqMinimo = atqMinimo;
		this.atqMaximo = atqMaximo;
	}

	public abstract ArrayList<Rectangle> getAlcance(final Jugador jugador);

	public Sprites getSprites() {
		return hojaArmas.getSprite(id - 500);
	}

	protected int getAtqPromedio(final int atqMinimo, final int atqMaximo) {
		Random r = new Random();

		return r.nextInt(atqMaximo - atqMinimo) + atqMinimo;
	}

}
