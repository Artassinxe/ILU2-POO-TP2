package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);
	private boolean nomVendeurConnu;
	private StringBuilder interaction = new StringBuilder();
	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		this.nomVendeurConnu = controlPrendreEtal.verifierIdentite(nomVendeur);
		if (!nomVendeurConnu) {
			interaction.append("Je suis désolée"+nomVendeur+"mais il faut être un habitant de notre village pour commercer ici.");
		}else {
			
			interaction.append("Bonjour "+nomVendeur+",je vais regarder si je peux vous trouver un étal.");
			boolean etatDisponible = controlPrendreEtal.resteEtals();
			if (!etatDisponible) {
				interaction.append("Désolée "+nomVendeur+" je n'ai plus d'étal qui ne soit pas déjà occupé.");
				System.out.print(interaction.toString());
			}else {
				this.installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		interaction = new StringBuilder();
		interaction.append("C'est parfait, il me reste un étal pour vous !\n");
		interaction.append("Il me faudrait quelques renseignements :\n");
		interaction.append("Quel produit souahitez-vous vendre ?\n");
		System.out.println(interaction);
		String produit = scan.next();
		interaction.append("Combien souhaitez-vous en vendre ?\n");
		int nbProduit = Clavier.entrerEntier(interaction.toString());
		int numeroEtal = controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numeroEtal != 1) {
			interaction.append("Le vendeur"+nomVendeur+"s'est installé à l'étal n°"+ numeroEtal+"\n");
			System.out.println(interaction.toString());
		}
	}
}

