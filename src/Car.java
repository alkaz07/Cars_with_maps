import java.util.Objects;

class Car implements Comparable<Car> {
    String name;
    int speed;
    int gruz;
    Car(String name, int speed, int gruz){
        this.name = name;
        this.speed = speed;
        this.gruz=gruz;
    }
    public String toString()
    {
        return name+"_"+speed+"_"+gruz;
    }

    //Машинки считаются одинаковыми, если:
    //совпадает name И совпадет speed И совпадает gruz

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return speed == car.speed && gruz == car.gruz && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, speed, gruz);
    }


    @Override
    public int compareTo(Car o) {
        if(this.gruz == o.gruz)
        {
            if (this.speed == o.speed)
                return this.name.compareTo(o.name);
            else
                return this.speed-o.speed;
        }
        else
            return this.gruz-o.gruz;
    }
}




