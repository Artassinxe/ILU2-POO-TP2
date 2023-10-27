package controleur;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import villagegaulois.Village;
class ControlPrendreEtalTest {
	private Village village;
	private Chef abraracourcix;
	
	@BeforeEach
	public void initialiserSituation() {
		village = new Village("le village des irréductibles", 10, 2);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		ControlEmmenager controlEmmenager = new ControlEmmenager(village);
		controlEmmenager.ajouterGaulois("Bonemine", 10);
		controlEmmenager.ajouterDuide("Panoramix", 10, 1, 5);
	}
	
	@Test
	void testControlPrendreEtal() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal  = new ControlPrendreEtal(controlVerifierIdentite,village);
	}

	@Test
	void testResteEtals() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal  = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertTrue(controlPrendreEtal.resteEtals());
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 6);
		controlPrendreEtal.prendreEtal("Panoramix", "Potions", 4);
		assertFalse(controlPrendreEtal.resteEtals());
	}

	@Test
	void testPrendreEtal() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal  = new ControlPrendreEtal(controlVerifierIdentite,village);
		controlPrendreEtal.prendreEtal("Bonemine", "fleurs", 6);
	}

	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite controlVerifierIdentite = new ControlVerifierIdentite(village);
		ControlPrendreEtal controlPrendreEtal  = new ControlPrendreEtal(controlVerifierIdentite,village);
		assertFalse(controlPrendreEtal.verifierIdentite("Hugue"));
		assertTrue(controlPrendreEtal.verifierIdentite("Panoramix"));
	}

}
