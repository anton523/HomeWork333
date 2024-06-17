import java.util.Arrays;
import java.util.Comparator;


public class MyArrayList<E> {
    private static final int DEFAULT_CAPACITY = 10;
    private int size;
    private Object[] elementsArray;
    public MyArrayList(){
        this.elementsArray= new Object[DEFAULT_CAPACITY];
    }
    public MyArrayList(int capacity){
        this.elementsArray= new Object[capacity];
    }

    private Object[] grow(){
        int newCapacityLength =elementsArray.length / 2 + elementsArray.length + 1;
        return elementsArray = Arrays.copyOf(elementsArray, newCapacityLength);
    }
    public void add(int index, E element){
        if (index<0 || index>size) throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        if (size==elementsArray.length){
            elementsArray = grow();
        }
        System.arraycopy(elementsArray, index, elementsArray, index+1, size-index);
        elementsArray[index]=element;
        size+=1;
    }
    public void add(E element){
        add(size, element);
    }
    public E get(int index){
        if (index<0 || index>=size) throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        return (E) elementsArray[index];
    }
    public void remove(int index){
        if (index<0 || index>=size) throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        if (index==size-1) {
            elementsArray[index]=null;
        } else {
            System.arraycopy(elementsArray, index + 1, elementsArray, index, size - (index+1));
            elementsArray[size-1]=null;
        }
        size-=1;
    }
    public void remove(){
        remove(size-1);
    }
    public void addAll(int index, MyArrayList<? extends E> list){
        Object[] a = list.toArray();
        if (index<0 || index>size) throw new IndexOutOfBoundsException(outOfBoundsMsg(index));
        while (size+list.size>elementsArray.length){
            elementsArray = grow();
        }
        System.arraycopy(elementsArray, index, elementsArray, index+list.size, size-index);
        System.arraycopy(a, 0, elementsArray, index, list.size);
        size+=list.size;
    }
    public void addAll(MyArrayList<? extends E> list){
        addAll(size, list);
    }
    private String outOfBoundsMsg(int index) {
        return "Index: "+index+", Size: "+size;
    }
    public void sort(Comparator<? super E> c){
        boolean flag;
        for (int i = 0; i < size-1; i++) {
            flag = false;
            for (int j = 0; j < size-1-i; j++) {
                if (c.compare((E) elementsArray[j], (E) elementsArray[j + 1]) > 0){
                    E t=(E) elementsArray[j];
                    elementsArray[j] = elementsArray[j + 1];
                    elementsArray[j + 1] = t;
                    flag = true;
                }
            }
            if (!flag){
                break;
            }
        }

    }


    @Override
    public String toString() {
        return "MyArrayList{" +
                "elementsArray=" + Arrays.toString(elementsArray) +
                '}';
    }
    private Object[] toArray() {
        return Arrays.copyOf(elementsArray, size);
    }
}
