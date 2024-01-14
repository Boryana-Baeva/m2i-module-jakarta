package com.demo.bibliotheque.metier;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Collectors;

public class GestionnaireLivres {
    private static GestionnaireLivres gestionnaireLivres;
    private ArrayList<Livre> livres = new ArrayList<>();

    private GestionnaireLivres() {
        livres.add(new Livre("The Great Gatsby", "F. Scott Fitzgerald", 9780333791035L));
        livres.add(new Livre("Les Misérables", "Victor Hugo", 9780453009669L));
        livres.add(new Livre("Harry Potter And Ahe Philosopher's Stone" , "J.K.Rowling", 9780545582889L));
        livres.add(new Livre("Notre-Dame de Paris" , "Victor Hugo", 9780789414915L));
        livres.add(new Livre("To Kill a Mockingbird", "Harper Lee", 9780061120084L));
        livres.add(new Livre("1984", "George Orwell", 9780452284234L));
        livres.add(new Livre("Pride and Prejudice", "Jane Austen", 9780199535569L));
        livres.add(new Livre("The Catcher in the Rye", "J.D. Salinger", 9780316769480L));
        livres.add(new Livre("The Hobbit", "J.R.R. Tolkien", 9780618002214L));
        livres.add(new Livre("One Hundred Years of Solitude", "Gabriel Garcia Marquez", 9780061120084L));
        livres.add(new Livre("Brave New World", "Aldous Huxley", 9780061120084L));
        livres.add(new Livre("The Lord of the Rings", "J.R.R. Tolkien", 9780618002214L));
        livres.add(new Livre("The Chronicles of Narnia", "C.S. Lewis", 9780061120084L));
        livres.add(new Livre("The Shining", "Stephen King", 9780385121675L));
    }

    public static GestionnaireLivres getGestionnaireLivres() {
        if(gestionnaireLivres == null) {
            gestionnaireLivres = new GestionnaireLivres();
        }
        return gestionnaireLivres;
    }

    public ArrayList<Livre> getLivres() {
        return livres;
    }

    public ArrayList<Livre> searchLivres(String search) {
        ArrayList<Livre> res = new ArrayList<>();

        for(Livre livre : livres) {
            if(livre.getAuteur().toLowerCase().contains(search.toLowerCase())
                    || livre.getTitre().toLowerCase().contains(search.toLowerCase())) {
                res.add(livre);
            }
        }
        return res;
    }

    public boolean addLivre(Livre livre) {
        boolean isSuccessful = true;
        for (Livre l : livres) {
            if (l.getIsbn() == livre.getIsbn()) {
                isSuccessful = false;
            }
        }
        if(isSuccessful) {
            livres.add(livre);
        }
        return isSuccessful;
    }

    public Livre getLivreByIsbn(long isbn) {
        Livre livre = null;

        for (Livre l : livres) {
            if(l.getIsbn() == isbn) {
                livre = l;
            }
        }

        return livre;
    }

    public void updateLivre(Livre livre) {
        for(Livre l : livres) {
            if(l.getIsbn() == livre.getIsbn()) {
                l.setTitre(livre.getTitre());
                l.setAuteur(livre.getAuteur());
                l.setIsbn(livre.getIsbn());
                break;
            }
        }
    }

}
