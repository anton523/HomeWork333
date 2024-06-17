import java.util.Comparator;

public class Runner {
    public static void main(String[] args) {
        MyArrayList<String> list= new MyArrayList<>();
        MyArrayList<String> list2= new MyArrayList<>();
        list2.add("дыня");
        list2.add("арбуз");
        list2.add("тыква");
        list2.add("апельсин");
        list2.add(2,"грязь");
        System.out.println(list2);

        list.add("0");
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println(list+"\n");

        list.addAll(2,list2);

        System.out.println(list);

        list.remove(2);
        list.remove();

        System.out.println(list);
        list.add("q");
        list.add("q");
        list.add("q");
        System.out.println(list);

        list.sort(Comparator.naturalOrder()); // Сортировка по лексике

        System.out.println(list);


        System.out.println(list.get(7));
        MyArrayList<String> list3=new MyArrayList<>(0);
        list3.add("qq");
        list3.add("qq");
        list3.add("qq");
        System.out.println(list3);



    }
}
