package CTCI.p3;

import java.util.LinkedList;
import java.util.Queue;

class p3_6_animal_shelter {
    enum Type{
        DOG, CAT
    }
    private static class Animal{
        Type type;
        String name;
        Animal(Type type, String name){
            this.type = type;
            this.name = name;
        }

        @Override
        public String toString() {
            return type + " " + name;
        }
    }

    static class AnimalQueue{
        Queue<Animal> mainQueue = new LinkedList<>();
        Queue<Animal> subQueue = new LinkedList<>();

        void enqueue(Animal animal){
            mainQueue.add(animal);
        }

        Animal dequeueAny(){
            if (!subQueue.isEmpty()) return subQueue.remove();
            return mainQueue.remove();
        }

        Animal dequeueDog(){
            return dequeueType(Type.DOG);
        }
        Animal dequeueCat(){
            return dequeueType(Type.CAT);
        }

        Animal dequeueType(Type type){
            if (!subQueue.isEmpty() && subQueue.element().type == type){
                return subQueue.remove();
            }
            else{
                while (mainQueue.element().type != type){
                    subQueue.add(mainQueue.remove());
                }
                return mainQueue.remove();
            }
        }

    }

    public static void main(String[] args){
        AnimalQueue q = new AnimalQueue();
        q.enqueue(new Animal(Type.CAT, "1"));
        q.enqueue(new Animal(Type.DOG, "1"));
        q.enqueue(new Animal(Type.CAT, "2"));
        q.enqueue(new Animal(Type.CAT, "3"));
        q.enqueue(new Animal(Type.DOG, "2"));

        System.out.println(q.dequeueAny());
        System.out.println(q.dequeueCat());
        System.out.println(q.dequeueAny());
        System.out.println(q.dequeueDog());
        System.out.println(q.dequeueAny());
    }
}
