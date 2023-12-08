public class Testy {
    public static <T> void main(String []args){
        LinkedList<T> list = new LinkedList<T>();
        list.insert((T) "mund");
        list.insert((T) "edmund");
        list.printAllData();

    }
}
