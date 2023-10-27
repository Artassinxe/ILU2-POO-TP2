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
		// Vérification du produit sur le marché
		if(Boolean.FALSE.equals(controlAcheterProduit.produitEstVendu(produit))) {
			interaction.setLength(0);
			interaction.append("Désolé, personne ne vend ce produit au marché.\n");
			System.out.println(interaction.toString());
		}else {
			interaction.setLength(0);
			interaction.append(nomAcheteur+". Chez quel commerçant souhaitez vous acheter des "+produit+" ?\n");
			System.out.println(interaction.toString());
			String[] infoVendeur = controlAcheterProduit.getInfoVendeur(produit);
			interaction.setLength(0);
			for(int i=0;i<infoVendeur.length;i+=2) {
				interaction.append(i+" - "+infoVendeur[i]+" qui vend "+infoVendeur[i+1]+" "+produit+"\n");
			}
			int choix = Clavier.entrerEntier(interaction.toString());
			interaction.setLength(0);
			interaction.append(nomAcheteur+" se déplace vers le commerçant "+infoVendeur[choix]+".\n");
			interaction.append("Combien de "+produit+" souhaitez vous lui acheter ?\n");
			System.out.println(interaction.toString());
			int nombreItem = Clavier.entrerEntier(interaction.toString());
			effectuerAchat(infoVendeur[choix],nombreItem);
			
		}
	}
	private void effectuerAchat(String vendeur, int nombreItem) {
		String[] infovente = controlAcheterProduit.acheter(vendeur, nombreItem);
	}
}
