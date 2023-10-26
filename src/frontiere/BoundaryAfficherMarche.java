package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;
	StringBuilder interaction = new StringBuilder();

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		interaction.setLength(0);
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if(infosMarche.length == 0) {
			interaction.append("Le marché est vide, revenez plus tard.");
			System.out.println(interaction.toString());
		}else {
			interaction.append(nomAcheteur+", vous trouverez au marché :\n");
			System.out.println(interaction.toString());
			interaction.setLength(0);
			int i = 0;
			while (i<infosMarche.length) {
				String vendeur = infosMarche[i];
				interaction.append("- "+vendeur+" qui vend ");
				i++;
				String quantite = infosMarche[i];
				interaction.append(quantite);
				i++;
				String produit = infosMarche[i];
				interaction.append(" "+produit+"\n");
				System.out.println(interaction.toString());
				interaction.setLength(0);
				i++;
			}
		}
	}
}
