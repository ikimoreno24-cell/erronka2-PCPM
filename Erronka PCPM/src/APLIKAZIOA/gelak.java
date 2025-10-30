package APLIKAZIOA;
import java.util.ArrayList;
public class gelak {
    private String izena;
    private String kolorea;
    private ArrayList <pelikula> pelikulak;
public gelak(String izena,String kolorea){
    this.izena=izena;
    this.kolorea=kolorea;
    this.pelikulak=new ArrayList<>();
}
public String getIzena() {
    return izena;
}
public void setIzena(String izena) {
    this.izena = izena;


}
public String getKolorea() {
    return kolorea;
}
public void setKolorea(String kolorea) {
    this.kolorea = kolorea;
} 
public ArrayList<pelikula>getPelikulak(){
    return pelikulak;
}
public void gehituPelikula(pelikula pelikula){
    pelikulak.add(pelikula);
}
public void erakutsiPelikulak(){
        System.out.println(kolorea + izena + koloreak.RESET+":" );
        for(int i =0;i<pelikulak.size();i++){
            System.out.println((i+1)+". "+pelikulak.get(i).getKolorea() + pelikulak.get(i).getTitulua() + koloreak.RESET + "Stock-a:"+pelikulak.get(i).getStock());
        }
}
public pelikula bilatuPelikula(int index){
    if(index>=0 && index<pelikulak.size()){
        return pelikulak.get(index);
    }
    return null;
}
public int pelikulaKop(){
    return pelikulak.size();
}
}