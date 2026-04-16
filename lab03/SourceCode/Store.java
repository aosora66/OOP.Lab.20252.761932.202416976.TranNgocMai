public class Store {
    private DigitalVideoDisc[] itemsInStore= new DigitalVideoDisc[1000000000];
    private int qtyStore;
    public void addDVD(DigitalVideoDisc dvd){
        itemsInStore[qtyStore] = dvd;
        qtyStore++;
        System.out.println("Da them vao Store");
    }
    public void removeDVD(DigitalVideoDisc disc){
        boolean flag=false;
        for(int i=0; i<qtyStore; i++){
            if(itemsInStore[i]==disc){
                flag=true;
                for(int j=i; j<qtyStore-1; j++) itemsInStore[j]=itemsInStore[j+1];
                qtyStore--;
                System.out.println("Da xoa khoi Store");
            }
        }
        if(!flag) System.out.printf("Khong tim thay trong Store");
    }
}
