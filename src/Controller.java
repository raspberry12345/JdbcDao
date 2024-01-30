import java.util.Scanner;

public class Controller {

    public void start(){
        HouseholdDao households = new HouseholdDaoImpl();
        PersonDao persons = new PersonDaoImpl();
        PetDao pets = new PetDaoImpl();
        View view = new View();


        Scanner sc = new Scanner(System.in);
        int input1 =0;
        int input2 = 0;
        String name = "";
        while(true){
            do {
                view.menu1();
                input1 = sc.nextInt();
            } while(checkInput1(input1));
            if (input1==6){
                return;
            }
            if (input1!=5){
                do {
                    view.menu2();
                    input2 = sc.nextInt();
                } while(checkInput2(input2));
            }

            String entity ="";
            int input3 = 0;
            if (input1 == 1){
                if (input2==2){
                    entity = "der Haushalt-id und des Namen";
                    view.menu3(entity);
                    input3 = sc.nextInt();
                    sc.nextLine();
                    name = sc.nextLine();
                    persons.create(input1, input2, input3, name);
                }else if(input2==3){
                    entity = "der Person-id und des Namen";
                    view.menu3(entity);
                    input3 = sc.nextInt();
                    sc.nextLine();
                    name = sc.nextLine();
                    //--------------------------------------------
                    pets.create(input3, name);
                }else if (input2==1){
                    view.menu3(entity);

                    sc.nextLine();
                    name = sc.nextLine();
                    households.create( name);


                }


            }else if (input1==2||input1==4){
                if (input2==1){
                    entity = "haushalt-id";
                    view.menu3(entity);
                    input3 = sc.nextInt();
                    if (input1==4){
                        households.delete(input3);
                    }else{
                        System.out.println(households.read( input3));
                    }


                }else if (input2==2){
                    entity = "person-id";
                    view.menu3(entity);
                    input3 = sc.nextInt();
                    if (input1==4){
                        persons.delete(input3);
                    }else{
                        System.out.println(persons.read( input3));
                    }


                }else if (input2==3){
                    entity = "haustier-id";
                    view.menu3(entity);
                    input3 = sc.nextInt();
                    if (input1==4){
                        pets.delete(input3);
                    }else{
                        System.out.println(pets.read( input3));
                    }


                }


            }else if (input1==3){
                if (input2==1){
                    entity = "haushalt-id und den neuen Namen ein";
                    view.menu3(entity);
                    input3 = sc.nextInt();
                    sc.nextLine();
                    name = sc.nextLine();
                    households.update(input3,name);
                }else if (input2==2){
                    entity = "person-id und den neuen Namen ein";
                    view.menu3(entity);
                    input3 = sc.nextInt();
                    sc.nextLine();
                    name = sc.nextLine();
                    persons.update(input2,input3,name);
                }else if (input2==3){
                    entity = "haustier-id und den neuen Namen ein";
                    view.menu3(entity);
                    input3 = sc.nextInt();
                    sc.nextLine();
                    name = sc.nextLine();
                    pets.update(input2,input3,name);
                }


            }else if (input1==5) {
                System.out.println(households.showHouseholds());
            }
        }
    }
    public boolean checkInput1(int input){
        boolean checked;
        if (0<input && input<7){
            checked = false;
        }else{
            checked = true;
        }
        return checked;
    }
    public boolean checkInput2(int input){
        boolean checked = true;
        if (0<input && input <4){
            checked = false;
        }
        return checked;
    }

}
