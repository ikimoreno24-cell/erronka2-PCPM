package APLIKAZIOA;
import java.util.ArrayList;
//Gela bakoitza izena bat du("Thriller gela" adibidez) eta kolore bat ipini diogu gela bakoitzari, gelaren barruan filmen lista bat dago.
public class gelak {
    private String izena;
    private String kolorea;
    private ArrayList <pelikula> pelikulak;
    //seterrak eta getterrak
public gelak(String izena,String kolorea){
    this.izena=izena;
    this.kolorea=kolorea;
    this.pelikulak=new ArrayList<>();
}
//Izena lortzeko
public String getIzena() {
    return izena;
}
//Izena aldatzeko
public void setIzena(String izena) {
    this.izena = izena;


}
//Kolorea lortzeko
public String getKolorea() {
    return kolorea;
}
//Kolorea aldatzeko
public void setKolorea(String kolorea) {
    this.kolorea = kolorea;
} 
//Filmak lortzeko
public ArrayList<pelikula>getPelikulak(){
    return pelikulak;
}
//Filma bat gehitzeko
public void gehituPelikula(pelikula pelikula){
    pelikulak.add(pelikula);
}
//Pelikulak erakusteko
public void erakutsiPelikulak(){
        System.out.println(kolorea + izena + koloreak.RESET+":" );
        for(int i =0;i<pelikulak.size();i++){
            System.out.println((i+1)+". "+pelikulak.get(i).getKolorea() + pelikulak.get(i).getTitulua() + koloreak.RESET + "Stock-a:"+pelikulak.get(i).getStock());
        }
}
//Filma bilatu
public pelikula bilatuPelikula(int index){
    if(index>=0 && index<pelikulak.size()){
        return pelikulak.get(index);
    }
    return null;
}
//Pelikula kopurua bilatu
public int pelikulaKop(){
    return pelikulak.size();
}
}