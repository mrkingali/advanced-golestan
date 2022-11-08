package ir.ac.kntu;

import java.util.ArrayList;

public class Luanch extends Food{
    protected ArrayList<String> noshidani=new ArrayList<>();
    protected ArrayList<String> gazaAsli=new ArrayList<>();
    protected  ArrayList<String> salad=new ArrayList<>();

    public Luanch(Place place, double price) {
        super(place, price);
        noshidani.add("noshabe");
        noshidani.add("dogh");
        gazaAsli.add("kabab");
        gazaAsli.add("joje");
        salad.add("Shirazi");
        salad.add("fasli");
    }
}
