import java.util.*;

public class Animal010{

    public static void main(String[] args){
        String str = "str";
        System.out.println("input : "+str);
    
        new Animal010().solution(str);
        System.out.println("output : "+str);
    }
    
    void solution(String str){
        Dog dog = new Dog();
        //System.out.println("dog.name : "+dog.name );
        GT<Dog> gt = new GT<Dog>(dog);
        gt.printName();
        //dog.walk();
        gt.trainning();
    }

    public class GT<T extends Animal>{
        T whoAnimal;
        GT(T t){
            this.whoAnimal = t;
        }
        void printName(){
            System.out.println("T.name : " +whoAnimal.name);
        }
        void trainning(){
            whoAnimal.walk();
        }
    }

    public class Animal{
        String name = "Animal name";
        void walk(){
            System.out.println("Animal walk()");
            
        }
    }
    public class Dog extends Animal{
        String name = "Dog name";
        void walk(){
            System.out.println("Dog walk()");
            
        }
    }

}