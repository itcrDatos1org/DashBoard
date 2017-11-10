package datastructures.Ordenamiento;

import datastructures.DatosLineales.ListaSimple;
import datastructures.DatosLineales.NodeLista;
/**
 * Created by HP Probook 6475b on 10/11/2017.
 */
public class InsertionSort
{
    public static void sort(ListaSimple<?> lista)
    {
        SortAuxiliar(lista, "up");
    }

    public static void sort(ListaSimple<?> lista, boolean descendent)
    {
        if (descendent) {
            SortAuxiliar(lista, "down");
        } else {
            SortAuxiliar(lista, "up");
        }
    }

    private static void SortAuxiliar(ListaSimple<?> lista, String order)
    {
        if (lista.getHead().getData().getClass().getName().equals("java.lang.Integer"))
        {
            ListaSimple<Integer> list = (ListaSimple<Integer>) lista;
            InsertionSortAuxiliarInteger(list, order);
        }
        else if (lista.getHead().getData().getClass().getName().equals("java.lang.String"))
        {
            ListaSimple<String> list = (ListaSimple<String>) lista;
            InsertionSortAuxiliarString(list, order);
        }
        else
        {
            ListaSimple<Comparable> list = (ListaSimple<Comparable>) lista;
            InsertionSortAuxiliarComparable(list, order);
        }
    }

    private static void InsertionSortAuxiliarInteger(ListaSimple<Integer> numberList, String order)
    {
        if (order.startsWith("down")) {
            for (int i = 1; i < numberList.size(); i++) {
                for (int j = i; j > 0; j--) {
                    if (((Integer)numberList.get(j)).intValue() > ((Integer)numberList.get(j - 1)).intValue()) {
                        numberList.swap(j, j - 1);
                    }
                }
            }
        } else if (order.startsWith("up")) {
            for (int i = 1; i < numberList.size(); i++) {
                for (int j = i; j > 0; j--) {
                    if (((Integer)numberList.get(j)).intValue() < ((Integer)numberList.get(j - 1)).intValue()) {
                        numberList.swap(j, j - 1);
                    }
                }
            }
        }
    }

    private static void InsertionSortAuxiliarString(ListaSimple<String> stringList, String order)
    {
        if (order.startsWith("down")) {
            for (int i = 1; i < stringList.size(); i++) {
                for (int j = i; j > 0; j--) {
                    if (((String)stringList.get(j)).compareTo((String)stringList.get(j - 1)) > 0) {
                        stringList.swap(j, j - 1);
                    }
                }
            }
        } else if (order.startsWith("up")) {
            for (int i = 1; i < stringList.size(); i++) {
                for (int j = i; j > 0; j--) {
                    if (((String)stringList.get(j)).compareTo((String)stringList.get(j - 1)) < 0) {
                        stringList.swap(j, j - 1);
                    }
                }
            }
        }
    }

    private static void InsertionSortAuxiliarComparable(ListaSimple<Comparable> list, String order)
    {
        if (order.startsWith("down")) {
            for (int i = 1; i < list.size(); i++) {
                for (int j = i; j > 0; j--) {
                    if (((Comparable)list.get(j)).compareTo(list.get(j - 1)) > 0) {
                        list.swap(j, j - 1);
                    }
                }
            }
        } else if (order.startsWith("up")) {
            for (int i = 1; i < list.size(); i++) {
                for (int j = i; j > 0; j--) {
                    if (((Comparable)list.get(j)).compareTo(list.get(j - 1)) < 0) {
                        list.swap(j, j - 1);
                    }
                }
            }
        }
    }
}

