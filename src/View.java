public class View {

    public void menu1(){
        System.out.println("Anlegen von");
        System.out.println("1:Erstellen (Haushalt/Person/Haustier)");
        System.out.println("2:Ausgabe (Haushalt/Person/Haustier)");
        System.out.println("3:Ändern (Haushalt/Person/Haustier)");
        System.out.println("4:Löschen (Haushalt/Person/Haustier)");
        System.out.println("5:Zeige alle Haushalte");
        System.out.println("6:Beenden");
    }
    public void menu2(){
        System.out.println("1:Haushalt");
        System.out.println("2:Person");
        System.out.println("3:Haustier");
    }
    public void menu3(String entity){
        System.out.println("Eingabe "+entity);

    }
}
