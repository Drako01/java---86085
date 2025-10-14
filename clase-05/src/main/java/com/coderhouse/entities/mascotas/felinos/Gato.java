package com.coderhouse.entities.mascotas.felinos;

import com.coderhouse.entities.mascotas.Mascota;

public class Gato extends Mascota {

	@Override
	public void comer() {
		System.out.println(super.getNombre() + " esta comiendo alimento Balanceado especial para Gatos.");
	}
}
