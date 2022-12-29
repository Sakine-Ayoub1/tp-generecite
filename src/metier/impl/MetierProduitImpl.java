package metier.impl;

import entities.Produit;
import metier.Imetier;

import java.util.ArrayList;
import java.util.List;

public class MetierProduitImpl implements Imetier<Produit> {

    private List<Produit> produits=new ArrayList<>();

    @Override
    public void add(Produit o) {
        produits.add(o);
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }

    @Override
    public Produit findById(long id) {
        for(Produit p : produits){
            if(p.getId()==id) return p;
        }
        return null;
    }

    @Override
    public void delete(long id) {
       for(int i=0;i<produits.size();i++){
           if(produits.get(i).getId()==id) produits.remove(i);
       }
    }
}
