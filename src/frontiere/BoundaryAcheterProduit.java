package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;
	private StringBuilder interaction = new StringBuilder();

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		interaction.setLength(0);
		interaction.append("Quel produit voulez-vous acheter ?\r\n");
		System.out.println(interaction.toString());
		String produit = scan.next();
		if(!controlAcheterProduit.VerifierProduit(produit)) {
			interaction.setLength(0);
			interaction.append("Désolé, personne ne vend ce produit au marché.\n");
			System.out.println(interaction.toString());
		}

	}
}
