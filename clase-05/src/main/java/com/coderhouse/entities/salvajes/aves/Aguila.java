package com.coderhouse.entities.salvajes.aves;

import com.coderhouse.entities.salvajes.Salvaje;

public class Aguila extends Salvaje {

	@Override
	public void comer() {
		System.out.println(super.getEspecie() + " esta comiendo a otro Animal");
	}
}
