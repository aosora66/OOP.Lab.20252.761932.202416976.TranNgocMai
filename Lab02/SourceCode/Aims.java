public class Aims {
    public static void main(String[] args) {
        Cart anOrder=new Cart();

        DigitalVideoDisc dvd1= new DigitalVideoDisc("3月のライオン", "Animation", "Akiyuki Shinbo", 66, 22.22f);
        anOrder.addDigitalVideoDisc(dvd1);

        DigitalVideoDisc dvd2= new DigitalVideoDisc("Star Wars", "Science Fiction", "George Lucas", 87, 24.95f);
        anOrder.addDigitalVideoDisc(dvd2);

        DigitalVideoDisc dvd3 = new DigitalVideoDisc("葬送のフリーレン", "Animation", "Keiichirou Saitou", 99, 66.66f);
        anOrder.addDigitalVideoDisc(dvd3);

        DigitalVideoDisc dvd4= new DigitalVideoDisc("Aladin", "Animation", "Roger Allers",18.99f);
        anOrder.addDigitalVideoDisc(dvd4);

        anOrder.removeDigitalVideoDisc(dvd2);

        System.out.println("Total Cost is: " + anOrder.totalCost());
    }
}
