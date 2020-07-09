package principal.inventario;

import principal.inventario.armas.Desarmar;
import principal.inventario.armas.Pistola;
import principal.inventario.consumibles.Consumible;

public class RegistroObjetos {

	public static Objeto getObjeto(final int idObjeto) {

		Objeto objeto = null;

		switch (idObjeto) {
		// 0-499: objeots consumibles
		case 0:
			objeto = new Consumible(idObjeto, "Medkit", "");
			break;
		case 1:
			objeto = new Consumible(idObjeto, "Balas", "");
			break;
		case 2:
			objeto = new Consumible(idObjeto, "Pill", "");
			break;
		case 3:
			objeto = new Consumible(idObjeto, "Super Medkit", "");
			break;
		case 4:
			objeto = new Consumible(idObjeto, "Super Balas", "");
			break;
		case 5:
			objeto = new Consumible(idObjeto, "Super Pill", "");
			break;

		// 500-599: armas
		case 500:
			objeto = new Pistola(idObjeto, "Handgun", "", 1, 3);
			break;
		case 501:
			objeto = new Pistola(idObjeto, "Escopeta", "", 2, 4);
			break;
		case 502:
			objeto = new Pistola(idObjeto, "Rifle", "", 3, 5);
			break;
		case 503:
			objeto = new Pistola(idObjeto, "Rifle Pesado", "", 4, 6);
			break;
		case 599:
			objeto = new Desarmar(idObjeto, "Desarmado", "", 0, 0);
		}

		return objeto;
	}
}
