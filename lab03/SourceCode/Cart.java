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
//    public void addDigitalVideoDisc(DigitalVideoDisc... dvds){
//        for(DigitalVideoDisc dvd: dvds){
//            addDigitalVideoDisc(dvd);
//        }
//    }
    public void addDigitalVideoDisc (DigitalVideoDisc dvd1, DigitalVideoDisc dvd2){
        addDigitalVideoDisc(dvd1);
        addDigitalVideoDisc(dvd2);
    }

}
