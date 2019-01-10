package com.okayo.app;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.okayo.config.Config;
import com.okayo.model.Designation;
import com.okayo.model.Prestation;
import com.okayo.service.PrestationService;

public class App 
{
    public static void main( String[] args )
    {
    	    	
		AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext(Config.class);	
	
    	PrestationService descriptionService = (PrestationService)appContext.getBean("prestationService");
    	
    	Prestation prestation = new Prestation("Okayo - Description 0", "", 100, 19.6, 1, 0);
    	Prestation prestation2 = new Prestation("Okayo - Description 1", "", 100, 19.6, -1, 0);
    	Prestation prestation3 = new Prestation("Description 2", "", -100, 19.6, 1, 0);
    	Prestation prestation4 = new Prestation("Okayo - Description 3", "", 100, 19.6, 1, 50);
    	Prestation prestation5 = new Prestation("Okayo - Description 4", "", 100, 19.6, 1, 0);
    	Prestation prestation6 = new Prestation("Okayo - Description (offered line)", "", 100, 19.6, 1, 100);
    	/** reference HA001 créée au hasard **/
    	Designation designation = new Designation(prestation, "HA001"); 
    	Designation designation2 = new Designation(prestation2, "HA001");
    	Designation designation3 = new Designation(prestation3, "HA001"); 
    	Designation designation4 = new Designation(prestation4, "HA001");
    	Designation designation5 = new Designation(prestation5, "HA001"); 
    	Designation designation6 = new Designation(prestation6, "HA001");
    	
    	/** facture avec 6 prestations **/
    	List<Designation> facture = new ArrayList<Designation>();
    	facture.add(designation);
    	facture.add(designation2);
    	facture.add(designation3);
    	facture.add(designation4);
    	facture.add(designation5);
    	facture.add(designation6);
    	
    	/** ajouter **/    	    	    	
    	descriptionService.creerFacture(facture);
    	
    	/** chercher **/
    	//Designation designation3 = descriptionService.rechercherPrestation(designation.getId());
    	List<Designation> facture2 = descriptionService.rechercherFacture(designation.getRefFacture());
    	
    	System.out.println("\n------> Facture : "+facture2+"\n");
    	
    	/** maj nouveau descriptif **/
    	designation2.getPrestation().setNouveauTitre("Okayo nouveau titre - Description bis");
    	descriptionService.majPrestation(designation2);
    	
    	List<Designation> facture3 = descriptionService.rechercherFacture(designation.getRefFacture());
    	System.out.println("\n ----> Facture modifié(au niveau du titre) : "+ facture3 +"\n");

    	/** prix total TTC de la facture **/
    	descriptionService.TotalTTC(designation.getRefFacture(), /*tva*/ prestation.getTva());
    	System.out.println("\n--------------> Total TTC : " + descriptionService.TotalTTC(designation.getRefFacture(), /*tva*/ prestation.getTva()) + " <----------------\n");
    	
    	/** changer la tva d'une facture**/
    	//descriptionService.changeTVA(designation.getRefFacture(), 20);
    	
    	/** supprimer **/
    	//supprimer une prestation
    	//descriptionService.supprimerPrestation(designation3);
    	//supprimer une facture
    	//descriptionService.supprimerFacture(designation.getRefFacture());
    	    	
    	System.out.println("\nFin");
    }
}
