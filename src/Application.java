import entities.Produit;
import metier.Imetier;
import metier.impl.MetierProduitImpl;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {

        Imetier imetier=new MetierProduitImpl();

        int i=0;
        while (i==0){
            System.out.println("Donner un nombre entre 1 et 5");
            System.out.println("1. Afficher la liste des produits");
            System.out.println("2. Rechercher un produit par son id");
            System.out.println("3. Ajouter un nouveau produit dans la liste");
            System.out.println("4. Supprimer un produit par id");
            System.out.println("5. Quitter ce programme");

            Scanner sc = new Scanner(System.in);
            int n = sc.nextInt();

            switch(n){

                case 1:
                   List<Produit> produits= imetier.getAll();
                   produits.forEach(p->{
                       System.out.println(p.getMarque());
                       System.out.println(p.getPrix());
                   });
                    break;

                case 2:
                    System.out.println("Donner id du produit");
                    Scanner s = new Scanner(System.in);
                    long id = s.nextLong();
                   Produit produit= (Produit) imetier.findById(id);
                   if(produit!=null){
                       System.out.println(produit.getPrix());
                       System.out.println(produit.getMarque());
                   }
                   else{
                       System.out.println("Aucun produit trouve avec id donne");
                   }
                    break;

                case 3:
                    imetier.add(new Produit(1L,"Iphone 11","Apple",7000,"Description1",3));
                    break;

                case 4:
                    System.out.println("Donner id du produit a supprimer");
                    Scanner sp = new Scanner(System.in);
                    long idD = sp.nextLong();
                    imetier.delete(idD);
                    break;

                case 5:
                    System.out.println("Vous avez quitte le programme");
                    i=1;
                    break;

                default:
                    break;
            }
        }


    }
}