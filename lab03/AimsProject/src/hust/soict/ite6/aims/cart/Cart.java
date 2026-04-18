package hust.soict.ite6.aims.cart;

public class Cart {
    public static final int MAX_NUMBERS_ORDERED = 20;
    private DigitalVideoDisc[] itemsOrdered = new DigitalVideoDisc[MAX_NUMBERS_ORDERED];
    private int qtyOrdered;

    public void addDigitalVideoDisc (DigitalVideoDisc disc){
        if(qtyOrdered<MAX_NUMBERS_ORDERED){
            itemsOrdered[qtyOrdered] = disc;
            qtyOrdered++;
            System.out.println("The disc has been added");
        }
        else System.out.println("The cart is almost full");
    }
    public void removeDigitalVideoDisc(DigitalVideoDisc disc){
        boolean flag=false;
        for(int i=0; i<qtyOrdered; i++){
            if(itemsOrdered[i]==disc){
                flag=true;
                for(int j=i; j<qtyOrdered-1; j++) itemsOrdered[j]=itemsOrdered[j+1];
                qtyOrdered--;
                System.out.println("The disc has been removed");
            }
        }
        if(!flag) System.out.printf("The disc could not be found");
    }
    public float totalCost(){
        float total=0;
        for(int i=0; i<qtyOrdered; i++) total+=itemsOrdered[i].getCost();
        return total;
    }

    public void addDigitalVideoDisc(DigitalVideoDisc[] dvdList){
        for(DigitalVideoDisc dvd: dvdList){
            addDigitalVideoDisc(dvd);
        }
    }
//    public void addDigitalVideoDisc(hust.soict.ite6.aims.disc.DigitalVideoDisc... dvds){
//        for(hust.soict.ite6.aims.disc.DigitalVideoDisc dvd: dvds){
//            addDigitalVideoDisc(dvd);
//        }
//    }
    public void addDigitalVideoDisc (DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }
    public void printCart(){
        System.out.println("***********************CART***********************\nOrdered Items:");
        for(int i=0; i<qtyOrdered; i++){
            System.out.println((i+1)+". DVD - "+itemsOrdered[i].toString());
        }
        System.out.println("Total cost: "+totalCost());
        System.out.println("***************************************************");
    }
    public void searchID(int id){
        boolean t=false;
        for(int i=0; i<qtyOrdered; i++){
            if(itemsOrdered[i].getId()==id) {
                t=true;
                System.out.println((i+1)+". DVD - "+itemsOrdered[i].toString());
            }
        }
        if(!t) System.out.println("Khong tim thay!");
    }
    public void searchTitle(String title){
        boolean t=false;
        for(int i=0; i<qtyOrdered; i++){
            if(itemsOrdered[i].isMatch(title)) {
                t=true;
                System.out.println((i+1)+". DVD - "+itemsOrdered[i].toString());
            }
        }
        if(!t) System.out.println("Khong tim thay!");
    }

}
