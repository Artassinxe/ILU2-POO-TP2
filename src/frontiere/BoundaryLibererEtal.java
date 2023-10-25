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
		if(Boolean.FALSE.equals(vendeurReconnu)) {
			interaction.setLength(0);
			interaction.append("Mais vous n'êtes pas inscrit sur notre marché aujourd'hui !\n");
			System.out.println(interaction.toString());
		}else {
			String[] donnesEtal = controlLibererEtal.libererEtal(nomVendeur);
			int etalOccupe = Integer.parseInt(donnesEtal[0]);
			if(etalOccupe==1) {
				String produit = donnesEtal[2];
				int quantiteInitial = Integer.parseInt(donnesEtal[3]);
				int quantiteVendu = Integer.parseInt(donnesEtal[4]);
				interaction.setLength(0);
				interaction.append("Vous avez vendu "+quantiteVendu+" sur "+quantiteInitial+" "+produit+".\n");
				interaction.append("Au revoir "+nomVendeur+",passez une bonnes journée");
				System.out.println(interaction);
			}
		}
	}

}
