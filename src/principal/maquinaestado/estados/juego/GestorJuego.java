package principal.maquinaestado.estados.juego;

import java.awt.Graphics;

import principal.ElementosPrincipales;
import principal.herramientas.DatosDebug;
import principal.interfaz_usuario.MenuInferior;
import principal.mapas.Mapa;
import principal.maquinaestado.EstadoJuego;

public class GestorJuego implements EstadoJuego {
	MenuInferior menuInferior;

	public GestorJuego() {
		menuInferior = new MenuInferior();
	}

	private void recargarJuego() {
		final String ruta = "/mapas/" + ElementosPrincipales.mapa.getNextMap();
		ElementosPrincipales.mapa = new Mapa(ruta);
		ElementosPrincipales.jugador.establecerPosicionX(ElementosPrincipales.mapa.getPosicionInicial().x);
		ElementosPrincipales.jugador.establecerPosicionY(ElementosPrincipales.mapa.getPosicionInicial().y);
	}

	public void actualizar() {
		if (ElementosPrincipales.jugador.get_LIMITE_ARRIBA().intersects(ElementosPrincipales.mapa.getZonaSalida())) {
			recargarJuego();
		}
		ElementosPrincipales.jugador.actualizar();
		ElementosPrincipales.mapa.actualizar();
	}

	public void dibujar(Graphics g) {
		ElementosPrincipales.mapa.dibujar(g);
		ElementosPrincipales.jugador.dibujar(g);
		menuInferior.dibujar(g);

		DatosDebug.enviarDato("X = " + ElementosPrincipales.jugador.getPosicionXInt());
		DatosDebug.enviarDato("Y = " + ElementosPrincipales.jugador.getPosicionYInt());
		DatosDebug.enviarDato("Siguiente mapa: " + ElementosPrincipales.mapa.getNextMap());
		DatosDebug.enviarDato("Salida X: " + ElementosPrincipales.mapa.getExitPoint().getX() + " Y = "
				+ ElementosPrincipales.mapa.getExitPoint().getY());
	}
}
