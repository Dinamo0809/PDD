package principal.inventario.armas;

import java.awt.Rectangle;
import java.util.ArrayList;

import principal.entes.Jugador;

public class Desarmar extends Arma {

	public Desarmar(int id, String nombre, String descripcion, int atqMinimo, int atqMaximo) {
		super(id, nombre, descripcion, atqMinimo, atqMaximo);
	}

	public Desarmar(int id, String nombre, String descripcion, int cantidad, int atqMinimo, int atqMaximo) {
		super(id, nombre, descripcion, cantidad, atqMinimo, atqMaximo);
	}

	public ArrayList<Rectangle> getAlcance(Jugador jugador) {
		return null;
	}

}
