import java.util.Objects;

public class MyDataStructure<T> {
    Element headElement;
    Element tailElement;

    T obj;


    public boolean isEqual(MyDataStructure other) {
        Element mytemp = headElement;
        Element othertemp = other.headElement;

        while (mytemp != null) {
            if (!mytemp.isEqual(othertemp))
                return false;
            mytemp = mytemp.next;
            othertemp = othertemp.next;
        }
        return othertemp == null;
    }

    public MyDataStructure() {
        headElement = null;
        tailElement = null;

    }


    public int size() {
        Element temp = headElement;
        int j = 0;
        // count the number of elements until null is reached.
        while (temp != null) {
            temp = temp.next;
            j++;
        }
        return j;
    }

    public void add(T obj) {
        Element newTuple = new Element(obj);
        if (headElement == null) {
            headElement = newTuple;
            tailElement = newTuple;
        } else {
            tailElement.next = newTuple;
            newTuple.prev = tailElement;
            tailElement = newTuple;
        }

    }

    public void deleteLast() {
        if (headElement.isEqual(tailElement)) {
            headElement = null;
            tailElement = null;
        } else if (headElement.next == tailElement) {
            headElement.next = null;
            tailElement = headElement;
        } else {
            tailElement = tailElement.prev;
            tailElement.next = null;
        }

    }

    static class Element<T> {
        T obj;

        public boolean isEqual(Element other) {

            return other != null && obj == other.obj;
        }

        Integer index;

        Element next;
        Element prev;

        public T getObj() {
            return obj;
        }

        public void setObj(T obj) {
            this.obj = obj;
        }

        public Element(T obj) {
            this.obj = obj;
            next = null;
            prev = null;

        }

        public Element() {

        }

    }
}