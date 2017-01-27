package CTCI.p16moderate;

import java.util.ArrayList;
import java.util.List;

class p16_10_living_people {
    private static class Person{
        int birth;
        int death;
        Person(int b, int d){
            birth = b;
            death = d;
        }
    }

    static int mostAliveYear(List<Person> list){
        int[] births = new int[101];
        int[] deaths = new int[101];
        for (Person p : list){
            births[p.birth - 1900]++;
            deaths[p.death - 1900]++;
        }

        int alive = 0;
        int max = 0;
        int maxIndex = 0;
        for (int i = 0; i < births.length; i++){
            alive += births[i];
            if (alive > max) {
                max = alive;
                maxIndex = i;
            }
            alive -= deaths[i];
        }
        return 1900 + maxIndex;
    }

    public static void main(String[] args){
        List<Person> list = new ArrayList<>();
        list.add(new Person(1908, 1909));
        list.add(new Person(1950, 2000));
        list.add(new Person(1970, 1999));
        list.add(new Person(1955, 1968));
        list.add(new Person(1900, 1999));
        list.add(new Person(1968, 1970));
        list.add(new Person(1960, 1968));
        //ans=1968
        System.out.println((mostAliveYear(list)));
    }
}
