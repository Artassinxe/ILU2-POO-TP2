package controleur;

import villagegaulois.Village;
import villagegaulois.Etal;
import personnages.Gaulois;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public Boolean produitEstVendu(String produit) {
		return village.rechercherVendeursProduit(produit) != null;
	}
	
	public String[] getInfoVendeur(String produit) {
		Gaulois[] vendeurGaulois = village.rechercherVendeursProduit(produit);
		String[] vendeurMarche = new String[(vendeurGaulois.length)*2];
		int i = 0;
		for (Gaulois gaulois : vendeurGaulois) {
			Etal etal = village.rechercherEtal(gaulois);
			vendeurMarche[i] = gaulois.getNom();
			i++;
			int quantite = etal.getQuantite();
			vendeurMarche[i] = Integer.toString(quantite);
			i++;
		}
		return vendeurMarche;
	}
}
