
public class Cat implements Cloneable
{
    public static final int EYES_COUNT = 2;
    public static final double MIN_WEIGHT = 1000.0;
    public static final double MAX_WEIGHT = 9000.0;

    public static int count;
    public Color color;

    private double originWeight;
    private double weight;

    private double massaFood;
    private String name;

    public Cat()
    {
        weight = 1500.0 + 3000.0 * Math.random();
        originWeight = weight;
        massaFood = 0;
        count++;
    }

    public boolean isAlive()
    {
        return (getWeight() >= MIN_WEIGHT && getWeight() <= MAX_WEIGHT);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        if (isAlive()){
            count++;
        }
        return super.clone();
    }

    public void setWeight(Double weight)
    {
        this.weight = weight;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    public Cat(Double weight){
        this();
        this.weight = weight;
        if (!isAlive()){
            count--;
        }
    }

    public void setCatColor(Color color)
    {
        this.color = color;
    }
    public Color getCatColor(){
        return color;
    }

    public static int getCount()
    {
        return count;
    }

    public void meow()
    {
        if (isAlive()){
            weight = weight - 1;
            System.out.println("Meow");
            if (!isAlive()){
                count--;
            }
        }
    }

    public void pee()
    {
        if (isAlive()){
            weight = weight - 150;
            System.out.println("Pee");

            if (!isAlive()){
                count--;
            }
        }
    }

    public void feed(Double amount)
    {
        if (isAlive()){
            weight = weight + amount;
            if (!isAlive()){
                count--;
            }
        }
        massaFood = massaFood + amount;
    }
    
    public void drink(Double amount)
    {
        if (isAlive()){
            weight = weight + amount;
            if ((!isAlive())){
                count--;
            }
        }
    }

    public Double getWeight()
    {
        return weight;
    }

    public Double massaEatenFood()
    {
        return massaFood;
    }

    public String getStatus()
    {
        if(weight < MIN_WEIGHT) {
            System.out.println("Dead");
            return "Dead";
        }
        else if(weight > MAX_WEIGHT) {
            System.out.println("Exploded");
            return "Exploded";
        }
        else if(weight > originWeight) {
            return "Sleeping";
        }
        else {
            return "Playing";
        }
    }
}