package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;
	private StringBuilder interaction = new StringBuilder();

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		Boolean vendeurReconnu = controlLibererEtal.isVendeur(nomVendeur);
		if(!vendeurReconnu) {
			interaction.append("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !");
			System.out.println(interaction.toString());
		}else {
			String[] donnesEtal = controlLibererEtal.libererEtal(nomVendeur);
			int etalOccupe = Integer.parseInt(donnesEtal[0]);
			if(etalOccupe==1) {
				int produit = Integer.parseInt(donnesEtal[2]);
				int quantiteInitial = Integer.parseInt(donnesEtal[3]);
				int quantiteVendu = Integer.parseInt(donnesEtal[4]);
				interaction.append("Vous avez vendu "+quantiteVendu+" sur "+quantiteInitial+" "+produit+".");
				interaction.append("Au revoir "+nomVendeur+",passez une bonnes journée");
				System.out.println(interaction);
			}
		}
	}

}
