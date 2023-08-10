class Car {
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
}




