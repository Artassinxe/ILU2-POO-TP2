package frontiere;

import controleur.ControlAfficherMarche;

public class BoundaryAfficherMarche {
	private ControlAfficherMarche controlAfficherMarche;
	StringBuilder interaction = new StringBuilder();

	public BoundaryAfficherMarche(ControlAfficherMarche controlAfficherMarche) {
		this.controlAfficherMarche = controlAfficherMarche;
	}

	public void afficherMarche(String nomAcheteur) {
		String[] infosMarche = controlAfficherMarche.donnerInfosMarche();
		if(infosMarche.length == 0) {
			interaction.append("Le marché est vide, revenez plus tard.");
		}else {
			interaction.append(nomAcheteur+", vous trouverez au marché :\n");
			while(i)
		}
	}
}
