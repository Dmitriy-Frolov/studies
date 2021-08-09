
public class Loader
{
    private String kitten;

    private static Cat getKitten()
    {
        return new Cat(1100.0);
    }

    public static void main(String[] args) throws CloneNotSupportedException
    {
        for (int i=0; i<3; i++){
            System.out.println(getKitten());
        }
        System.out.println("Three kittens created");
        System.out.println();

        Cat vasya = new Cat(2100.0);
        vasya.setName("Vasya");
        vasya.setCatColor(Color.GREY);
        vasya.feed(150.0);
        vasya.meow();
        System.out.println(vasya.getName() + " " + vasya.getWeight() + " " + vasya.getCatColor());
        System.out.println();

        Cat cat  = (Cat) vasya.clone();
        System.out.println(cat.getName() + " " + cat.getWeight() + " " + cat.getCatColor()
                      + " " + cat.massaEatenFood());
        System.out.println();

        Cat murzik = new Cat();
        System.out.println("Murzik weight: " + murzik.getWeight());
        murzik.setCatColor(Color.BLACK);
        System.out.println("Murzik color: " + murzik.getCatColor());
        System.out.println();

        Cat boris = new Cat();
        System.out.println("Boris weight: " + boris.getWeight());
        boris.feed(150.00);
        System.out.println("Boris weight: " + boris.getWeight());
        boris.feed(100.00);
        System.out.println("Boris weight: " + boris.getWeight());
        boris.pee();
        boris.pee();
        boris.pee();
        System.out.println("Boris weight: " + boris.getWeight());
        System.out.println("Boris eaten: " + boris.massaEatenFood());
        System.out.println();

        Cat musya = new Cat();
        System.out.println("Musya weight: " + musya.getWeight());
        musya.feed(100.00);
        System.out.println("Musya weight: " + musya.getWeight());
        System.out.println();

        Cat pushok = new Cat();
        System.out.println("Pushok weight: " + pushok.getWeight());
        while (!pushok.getStatus().equals("Exploded"))
        {
            System.out.println(pushok.getStatus());
            pushok.feed(540.00);
        }
        System.out.println();

        Cat afanasiy = new Cat();
        System.out.println("Afanasiy weight: " + afanasiy.getWeight());
        while (!afanasiy.getStatus().equals("Dead"))
        {
            System.out.println(afanasiy.getStatus());
            afanasiy.meow();
        }
        System.out.println();

        Cat klepa = new Cat();
        System.out.println("Klepa weight: " + klepa.getWeight());
        System.out.println();

        System.out.println(Cat.getCount());
    }
}