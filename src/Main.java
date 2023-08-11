//построить Набор совершенно уникальных машинок,
//заполнив туда значения из уже имеющегося ArrayList
//вывести его

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        //exemple1();
        exemple2();
        exemple3();
    }

    private static void exemple3() {
        //прочитать исходный файл и вычислить, сколько одинаковых машин каждого типа.
        //отсортировать по грузоподъемности
        //SELECT car.name, car.speed, car.gruz, count(*) FROM cars GROUP BY car.name, car.speed, car.gruz ORDER BY gruz, speed, name;
        TreeMap<Car, Integer> map1 = new TreeMap<>();
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {
                String[] words = scanner.nextLine().split(";");
                Car car = new Car(words[0], Integer.parseInt(words[1]), Integer.parseInt(words[2]));
                if(!map1.containsKey(car))
                    map1.put(car, 1);
                else
                    map1.put(car, map1.get(car)+1);
            }
            scanner.close();
            System.out.println(map1);

        } catch (IOException e) {
            System.out.println("не удалось найти файл");
        }

    }

    private static void exemple2() {
        //прочитать исходный файл и вычислить, сколько одинаковых машин каждого типа
        //SELECT car.name, car.speed, car.gruz, count(*) from cars group by car.name, car.speed, car.gruz;

        //составим словарь Машина -> число
        HashMap<Car, Integer> map1 = new HashMap<>();
        try {
            Scanner scanner = new Scanner(new File("input.txt"));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(";");
                Car car = new Car(words[0], Integer.parseInt(words[1]), Integer.parseInt(words[2]));
                if(!map1.containsKey(car))
                    map1.put(car, 1);
                else
                    map1.put(car, map1.get(car)+1);
                //map1.put(car, (map1.get(car) == null) ? 1 : map1.get(car) + 1);
            }
            scanner.close();
            System.out.println(map1);

        } catch (IOException e) {
            System.out.println("не удалось найти файл");
        }
    }

    private static void exemple1() {
        HashMap<String, Car> mapFIOCar = new HashMap<>();
        mapFIOCar.put("Вася", new Car("ЗиЛ", 60, 2000));
        mapFIOCar.put("Маша", new Car("Форд", 200, 900));
        mapFIOCar.put("Гриша", new Car("Феррари", 300, 500));
        mapFIOCar.put("Коля", new Car("Лада", 160, 1500));
        mapFIOCar.put("Миша", new Car("Форд", 200, 999));
        mapFIOCar.put("Нина", new Car("Феррари", 330, 500));
        System.out.println(mapFIOCar);
        mapFIOCar.put("Гриша", new Car("Лада", 160, 1500));
        System.out.println(mapFIOCar);

        System.out.println("введите имя");
        Scanner scanner = new Scanner(System.in);
        String fio = scanner.nextLine();
        if (mapFIOCar.containsKey(fio))
            System.out.println(fio + " ездит на " + mapFIOCar.get(fio));
        else
            System.out.println(fio + " - пешеход");
        for (Map.Entry<String, Car> currentLine : mapFIOCar.entrySet()) {
            System.out.println(currentLine);
            System.out.println(currentLine.getKey() + " ::: " + currentLine.getValue());
        }

        System.out.println("в словаре такие фамилии: " + mapFIOCar.keySet());
        System.out.println("в словаре такие машинки: " + mapFIOCar.values());
        ArrayList<Car> cars = new ArrayList<>(mapFIOCar.values());
        cars.sort(Comparator.comparing(x -> x.name));
        for (Car c : cars) {
            System.out.println(c + "\tпод управлением ???");
            for (Map.Entry<String, Car> entr : mapFIOCar.entrySet()) {
                if (entr.getValue().equals(c))
                    System.out.println("\t" + entr.getKey());
            }
        }
    }
}