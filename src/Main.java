//построить Набор совершенно уникальных машинок,
//заполнив туда значения из уже имеющегося ArrayList
//вывести его

import java.util.ArrayList;

import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        ArrayList<Car> cars = new ArrayList<>();
        cars.add(new Car("ЗиЛ",      60, 2000));
        cars.add(new Car("Форд",    200, 900));
        cars.add(new Car("Феррари", 300, 500));
        cars.add(new Car("Лада",    160, 1500));
        cars.add(new Car("Форд",    200, 999));
        cars.add(new Car("Феррари", 330, 500));
        cars.add(new Car("Лада",    160, 1500));
        System.out.println(cars);
        cars.sort(Comparator.comparingInt(x -> x.speed));
        System.out.println(cars);
        cars.sort(Comparator.comparing(q->q.name));
        System.out.println(cars);
      
    }
}