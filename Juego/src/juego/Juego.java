package juego;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import control.Teclado;
import ente.criaturas.Jugador;
import graficos.Pantalla;
import graficos.Sprite;
import mapa.Mapa;
import mapa.MapaCargado;

public class Juego extends Canvas implements Runnable {

	private static final long serialVersionUID = 1L;

	private static final int ANCHO = 800;
	private static final int ALTO = 600;

	private static volatile boolean Funcionando = false;

	private static final String NOMBRE = "Post D Day";

	private static int aps = 0;
	private static int fps = 0;

	private static JFrame ventana;
	private static Thread thread;
	private static Teclado teclado;
	private static Pantalla pantalla;
	private static Mapa mapa;
	private static Jugador jugador;

	private static BufferedImage imagen = new BufferedImage(ANCHO, ALTO, BufferedImage.TYPE_INT_RGB);
	private static int[] píxeles = ((DataBufferInt) imagen.getRaster().getDataBuffer()).getData();
	private static final ImageIcon icono = new ImageIcon(Juego.class.getResource("/icono/Ícono.png"));

	private Juego() {
		setPreferredSize(new Dimension(ANCHO, ALTO));

		pantalla = new Pantalla(ANCHO, ALTO);

		// mapa = new MapaGenerado(128, 128);
		teclado = new Teclado();
		addKeyListener(teclado);
		mapa = new MapaCargado("/mapas/minimapa2.png");
		jugador = new Jugador(mapa, teclado, Sprite.FRENTE_0, 190, 410);

		ventana = new JFrame(NOMBRE);
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setResizable(false);
		ventana.setLayout(new BorderLayout());
		ventana.add(this, BorderLayout.CENTER);
		ventana.pack();
		ventana.setLocationRelativeTo(null);
		ventana.setVisible(true);
		ventana.setIconImage(icono.getImage());
	}

	public static void main(String[] args) {
		Juego juego = new Juego();
		juego.iniciar();
	}

	private synchronized void iniciar() {
		Funcionando = true;

		thread = new Thread(this, "Gráficos");
		thread.start();
	}

	private synchronized void detener() {
		Funcionando = false;

		try {
			thread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	private void actualizar() {
		teclado.actualizar();
		jugador.actualizar();

		if (teclado.salir) {
			System.exit(0);
		}
		aps++;
	}

	private void mostrar() {
		BufferStrategy estrategia = getBufferStrategy();

		if (estrategia == null) {
			createBufferStrategy(3);
			return;
		}

		mapa.mostrar(jugador.getposicionX() - pantalla.getAncho() / 2 + jugador.getSprite().getLado() / 2,
				jugador.getposicionY() - pantalla.getAlto() / 2 + jugador.getSprite().getLado() / 2, pantalla);
		jugador.mostrar(pantalla);

		System.arraycopy(pantalla.pixeles, 0, píxeles, 0, píxeles.length);

		Graphics g = estrategia.getDrawGraphics();

		g.drawImage(imagen, 0, 0, getWidth(), getHeight(), null);
		g.setColor(Color.red);
		g.drawString("X: " + jugador.getposicionX(), 10, 20);
		g.drawString("Y: " + jugador.getposicionY(), 10, 35);
		g.dispose();

		estrategia.show();

		fps++;

	}

	public void run() {
		final int NS_POR_SEGUNDO = 1000000000;
		final byte APS_OBJETIVO = 60;
		final double NS_POR_ACTUALIZACION = NS_POR_SEGUNDO / APS_OBJETIVO;

		long referenciaActualizacion = System.nanoTime();
		long referenciaCounter = System.nanoTime();

		double tiempoTranscurrido;
		double delta = 0;

		requestFocus();

		while (Funcionando) {
			final long inicioBucle = System.nanoTime();

			tiempoTranscurrido = inicioBucle - referenciaActualizacion;
			referenciaActualizacion = inicioBucle;

			delta += tiempoTranscurrido / NS_POR_ACTUALIZACION;

			while (delta >= 1) {
				actualizar();
				delta--;

			}

			mostrar();

			if (System.nanoTime() - referenciaCounter > NS_POR_SEGUNDO) {
				ventana.setTitle(NOMBRE + " || APS: " + aps + " || FPS" + fps);
				aps = 0;
				fps = 0;
				referenciaCounter = System.nanoTime();

			}
		}
	}
}