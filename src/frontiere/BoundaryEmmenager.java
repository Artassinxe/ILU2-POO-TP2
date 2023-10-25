package frontiere;

import controleur.ControlEmmenager;

public class BoundaryEmmenager {
	private ControlEmmenager controlEmmenager;
	private int effetPotionMin;
	private int effetPotionMax;
	private int forceDruide;
	private int force;

	public BoundaryEmmenager(ControlEmmenager controlEmmenager) {
		this.controlEmmenager = controlEmmenager;
	}

	public void emmenager(String nomVisiteur) {
		if (controlEmmenager.isHabitant(nomVisiteur)) {
			System.out.println(
					"Mais vous êtes déjà un habitant du village !");
		} else {
			StringBuilder question = new StringBuilder();
			question.append("Êtes-vous :\n");
			question.append("1 - un druide.\n");
			question.append("2 - un gaulois.\n");
			int choixUtilisateur = -1;
			do {
				choixUtilisateur = Clavier.entrerEntier(question.toString());
				switch (choixUtilisateur) {
				case 1:
					emmenagerDruide(nomVisiteur);
					break;

				case 2:
					emmenagerVillageois(nomVisiteur);
					break;
				default:
					System.out
							.println("Vous devez choisir le chiffre 1 ou 2 !");
					break;
				}
			} while (choixUtilisateur != 1 && choixUtilisateur != 2);
		}
	}

	private void emmenagerDruide(String nomVisiteur) {
		StringBuilder question = new StringBuilder();
		question.append("Bienvenue druide "+nomVisiteur+". Quelle est votre force ?");
		forceDruide = Clavier.entrerEntier(question.toString());
		
		do {
			question.setLength(0);
			question.append("Quelle est la force de potion la plus faible que vous produisez ?");
			effetPotionMin = Clavier.entrerEntier(question.toString());
			question.setLength(0);
			question.append("Quelle est la force de potion la plus forte que vous produisez ?");
			effetPotionMax = Clavier.entrerEntier(question.toString());
			if (effetPotionMin > effetPotionMax) {
				System.out.println("Attention Druide, vous vous êtes trompé entre le minimum et le maximum.\n");
			}
		}while(effetPotionMax < effetPotionMin);
		
		this.controlEmmenager.ajouterDuide(nomVisiteur,forceDruide,effetPotionMin,effetPotionMax);
	}
	
	private void emmenagerVillageois(String nomVisiteur) {
		StringBuilder interaction = new StringBuilder();
		interaction.append("Bienvenue villageois "+nomVisiteur+" !\n");
		interaction.append("Quelle est votre force ?\n");
		force = Clavier.entrerEntier(interaction.toString());
		this.controlEmmenager.ajouterGaulois(nomVisiteur, force);
	}
}
