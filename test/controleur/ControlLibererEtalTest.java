package controleur;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;

class ControlLibererEtalTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal  = new ControlPrendreEtal(controlVerifierIdentite,village);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 6);
		controlPrendreEtal.prendreEtal("Panoramix", "Potions", 4);
	}
	
	@Test
	void testControlLibererEtal() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
	
	}

	@Test
	void testIsVendeur() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertTrue(controlLibererEtal.isVendeur("Bonemine"));
		assertFalse(controlLibererEtal.isVendeur("Hugue"));
		
	}

	@Test
	void testLibererEtal() {
		ControlTrouverEtalVendeur controlTrouverEtalVendeur = new ControlTrouverEtalVendeur(village);
		ControlLibererEtal controlLibererEtal = new ControlLibererEtal(controlTrouverEtalVendeur);
		assertTrue(controlLibererEtal.libererEtal("Bonemine")!=null);
		String[] tab = new String[5];
		tab[0] = "True";
		tab[1] = "Bonemine";
		tab[2] = "fleurs";
		tab[3] = "6";
		tab[4] = "0";
		String[] tabFunction = controlLibererEtal.libererEtal("Bonemine");
		for(int i=0;i<5;i++) {
			assertEquals(tabFunction[i],tab[i]);
		}
	
	}
}
