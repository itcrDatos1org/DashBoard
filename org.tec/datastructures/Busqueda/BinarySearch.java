package datastructures.Busqueda;

import datastructures.DatosLineales.ListaSimple;

public class BinarySearch
{
    public static <T> int binarySearch(ListaSimple<?> list, T data)
    {
        if (list.getHead().getData().getClass().getName().equals("java.lang.Integer"))
        {
            ListaSimple<Integer> lista = (ListaSimple<Integer>) list;
            return binarySearchAuxiliarInteger(lista, ((Integer)data).intValue(), 0, list.size());
        }
        if (list.getHead().getData().getClass().getName().equals("java.lang.String"))
        {
            ListaSimple<String> lista = (ListaSimple<String>) list;
            return binarySearchAuxiliarString(lista, (String)data, 0, list.size());
        }
        ListaSimple<Comparable> lista = (ListaSimple<Comparable>) list;
        return binarySearchAuxiliarComparable(lista, (Comparable)data, 0, list.size());
    }

    private static int binarySearchAuxiliarComparable(ListaSimple<Comparable> list, Comparable key, int minIndex, int maxIndex)
    {
        while (maxIndex > minIndex)
        {
            int middle = (maxIndex + minIndex) / 2;
            if (((Comparable)list.get(middle)).compareTo(key) < 0) {
                minIndex += middle + 1;
            } else if (((Comparable)list.get(middle)).compareTo(key) > 0) {
                maxIndex += middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    private static int binarySearchAuxiliarString(ListaSimple<String> list, String key, int minIndex, int maxIndex)
    {
        while (maxIndex > minIndex)
        {
            int middle = (maxIndex + minIndex) / 2;
            if (((String)list.get(middle)).compareTo(key) < 0) {
                minIndex = middle + 1;
            } else if (((String)list.get(middle)).compareTo(key) > 0) {
                maxIndex = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    private static int binarySearchAuxiliarInteger(ListaSimple<Integer> list, int key, int minIndex, int maxIndex)
    {
        if (((Integer)list.get(0)).intValue() == key) {
            return 0;
        }
        if (((Integer)list.get(list.size() - 1)).intValue() == key) {
            return list.size() - 1;
        }
        maxIndex = list.size() - 1;
        minIndex = 1;
        while (maxIndex > minIndex)
        {
            int middle = (maxIndex + minIndex) / 2;
            if (((Integer)list.get(middle)).compareTo(Integer.valueOf(key)) < 0) {
                minIndex = middle + 1;
            } else if (((Integer)list.get(middle)).compareTo(Integer.valueOf(key)) > 0) {
                maxIndex = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }
}

