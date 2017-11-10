package datastructures.Ordenamiento;

import datastructures.DatosLineales.ListaSimple;
import datastructures.DatosLineales.NodeLista;
/**
 * Created by HP Probook 6475b on 10/11/2017.
 */
public class RadixSort
{
    public static void sort(ListaSimple<?> lista)
    {
        if (lista.size() > 0) {
            if (lista.getHead().getData().getClass().getName().equals("java.lang.Integer"))
            {
                ListaSimple<Integer> list = (ListaSimple<Integer>) lista;
                list.setHead(RadixSortAuxiliarInteger(list, largerNumberSize(list), 1));
            }
            else if (lista.getHead().getData().getClass().getName().equals("java.lang.String"))
            {
                ListaSimple<String> list = (ListaSimple<String>) lista;
                fixString(list);
                list.setHead(RadixSortAuxiliarString(list, ((String)list.getHead().getData()).length(), 1));
            }
            else
            {
                ListaSimple<String> stringList = stringList(lista);
                ListaSimple<Comparable> comparableList = (ListaSimple<Comparable>) lista;
                fixString(stringList);
                comparableList.setHead(RadixSortAuxiliarComparable(stringList, comparableList, ((String)stringList.getHead().getData()).length(), 1));
            }
        }
    }

    public static void sort(ListaSimple<?> lista, boolean descendant)
    {
        sort(lista);
        if (descendant)
        {
            ListaSimple<Comparable> comparableList = (ListaSimple<Comparable>) lista;
            ListaSimple<Comparable> emptyComparableList = new ListaSimple();
            for (int i = comparableList.size() - 1; i >= 0; i--) {
                emptyComparableList.add((Comparable)comparableList.get(i));
            }
            comparableList.setHead(emptyComparableList.getHead());
        }
    }

    private static NodeLista<String> RadixSortAuxiliarString(ListaSimple<String> list, int larger, int mod)
    {
        if (mod <= larger)
        {
            int[] counter = new int['?'];
            countString(counter, list, mod);
            fixCount(counter);
            ListaSimple<String> emptyList = newEmptyList(" ", list.size());
            for (int i = list.size() - 1; i >= 0; i--)
            {
                String string = (String)list.get(i);
                String changeString = (String)list.get(i);
                for (int toMod = mod - 1; toMod > 0; toMod--) {
                    changeString = changeString.substring(0, changeString.length() - 1);
                }
                char c = changeString.charAt(changeString.length() - 1);
                int ascii = c;
                counter[ascii] -= 1;
                int index = counter[ascii];
                emptyList.getNode(index).setData(string);
            }
            return RadixSortAuxiliarString(emptyList, larger, mod + 1);
        }
        return list.getHead();
    }

    private static NodeLista<Comparable> RadixSortAuxiliarComparable(ListaSimple<String> stringList, ListaSimple<Comparable> comparableList, int larger, int mod)
    {
        if (mod <= larger)
        {
            int[] counter = new int['?'];
            countString(counter, stringList, mod);
            fixCount(counter);
            ListaSimple<String> emptyStringList = newEmptyList(" ", stringList.size());
            ListaSimple<Comparable> emptyComparableList = newEmptyList(null, stringList.size());
            for (int i = stringList.size() - 1; i >= 0; i--)
            {
                String string = (String)stringList.get(i);
                Comparable comparable = (Comparable)comparableList.get(i);
                String changeString = (String)stringList.get(i);
                for (int toMod = mod - 1; toMod > 0; toMod--) {
                    changeString = changeString.substring(0, changeString.length() - 1);
                }
                char c = changeString.charAt(changeString.length() - 1);
                int ascii = c;
                counter[ascii] -= 1;
                int index = counter[ascii];
                emptyStringList.setDATA(string, index);
                emptyComparableList.setDATA(comparable, index);
            }
            return RadixSortAuxiliarComparable(emptyStringList, emptyComparableList, larger, mod + 1);
        }
        return comparableList.getHead();
    }

    private static NodeLista<Integer> RadixSortAuxiliarInteger(ListaSimple<Integer> list, int larger, int mod)
    {
        if (mod <= larger)
        {
            int[] counter = new int[10];
            count(counter, list, mod);
            fixCount(counter);
            ListaSimple<Integer> emptyList = newEmptyList(Integer.valueOf(0), list.size());
            for (int i = list.size() - 1; i >= 0; i--)
            {
                int number = ((Integer)list.get(i)).intValue();
                int digit = ((Integer)list.get(i)).intValue();
                for (int toMod = mod - 1; toMod > 0; toMod--) {
                    digit /= 10;
                }
                counter[(digit % 10)] -= 1;
                int index = counter[(digit % 10)];
                emptyList.getNode(index).setData(Integer.valueOf(number));
            }
            return RadixSortAuxiliarInteger(emptyList, larger, mod + 1);
        }
        return list.getHead();
    }

    private static void countString(int[] counter, ListaSimple<String> list, int mod)
    {
        for (int i = 0; i < list.size(); i++)
        {
            String string = (String)list.get(i);
            for (int j = 0; j < mod - 1; j++) {
                string = string.substring(0, string.length() - 1);
            }
            String last = string.substring(string.length() - 1);
            char c = last.charAt(last.length() - 1);
            int ascii = c;
            counter[ascii] += 1;
        }
    }

    private static void count(int[] counter, ListaSimple<Integer> list, int mod)
    {
        for (int i = 0; i < list.size(); i++)
        {
            int number = ((Integer)list.get(i)).intValue();
            for (int j = 1; j < mod; j++) {
                number /= 10;
            }
            counter[(number % 10)] += 1;
        }
    }

    private static void fixCount(int[] counter)
    {
        for (int i = 1; i < counter.length; i++) {
            counter[i] += counter[(i - 1)];
        }
    }

    private static int largerStringSize(ListaSimple<String> list)
    {
        String larger = (String)list.getHead().getData();
        for (int i = 1; i < list.size() - 1; i++)
        {
            String compare = (String)list.get(i + 1);
            if (((String)list.get(i)).length() < compare.length()) {
                larger = compare;
            }
        }
        return larger.length();
    }

    private static void fixString(ListaSimple<String> list)
    {
        fixStringAux(list, largerStringSize(list));
    }

    private static void fixStringAux(ListaSimple<String> list, int largerNum)
    {
        for (int i = 0; i < list.size(); i++)
        {
            String s = (String)list.get(i);
            for (int j = 0; j < largerNum - ((String)list.get(i)).length() + 2; j++) {
                s = s + " ";
            }
            list.setDATA(s, i);
        }
    }

    private static int largerNumberSize(ListaSimple<Integer> list)
    {
        int larger = ((Integer)list.getHead().getData()).intValue();
        for (int i = 1; i < list.size() - 1; i++)
        {
            int compare = ((Integer)list.get(i + 1)).intValue();
            if (((Integer)list.get(i)).intValue() < compare) {
                larger = compare;
            }
        }
        return String.valueOf(larger).length();
    }

    private static ListaSimple<String> stringList(ListaSimple<?> list)
    {
        ListaSimple<String> stringList = new ListaSimple();
        for (int i = 0; i < list.size(); i++) {
            stringList.add(list.get(i).toString());
        }
        return stringList;
    }

    private static <V> ListaSimple<V> newEmptyList(V defaultData, int size)
    {
        ListaSimple<V> list = new ListaSimple();
        for (int i = 0; i < size; i++) {
            list.add(defaultData);
        }
        return list;
    }
}
