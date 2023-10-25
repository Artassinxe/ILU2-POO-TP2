package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);
	StringBuilder interaction = new StringBuilder();
	private boolean nomVendeurConnu;
	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		interaction.setLength(0);
		this.nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnu) {
			interaction.append("Je suis désolée "+nomVendeur+" mais il faut être un habitant de notre village pour commercer ici.");
			System.out.println(interaction.toString());
		}else {
			interaction.append("Bonjour "+nomVendeur+",je vais regarder si je peux vous trouver un étal.");
			System.out.println(interaction.toString());
			if (!controlPrendreEtal.resteEtals()) {
				interaction.setLength(0);
				interaction.append("Désolée "+nomVendeur+" je n'ai plus d'étal qui ne soit pas déjà occupé.");
				System.out.print(interaction.toString());
			}else {
				this.installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		interaction.setLength(0);
		interaction.append("C'est parfait, il me reste un étal pour vous !\n");
		interaction.append("Il me faudrait quelques renseignements :\n");
		interaction.append("Quel produit souhaitez-vous vendre ?\n");
		System.out.println(interaction);
		String produit = scan.next();
		interaction.setLength(0);
		interaction.append("Combien souhaitez-vous en vendre ?\n");
		int nbProduit = Clavier.entrerEntier(interaction.toString());
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal != -1) {
			interaction.setLength(0);
			interaction.append("Le vendeur "+nomVendeur+" s'est installé à l'étal n°"+ numeroEtal+"\n");
			System.out.println(interaction.toString());
		}
	}
}

