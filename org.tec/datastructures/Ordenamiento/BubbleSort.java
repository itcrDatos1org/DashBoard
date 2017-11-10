package datastructures.Ordenamiento;

import datastructures.DatosLineales.ListaSimple;
import datastructures.DatosLineales.NodeLista;
/**
 * Created by HP Probook 6475b on 10/11/2017.
 */
public class BubbleSort
{
    public static void sort(ListaSimple<?> lista)
    {
        SortAuxiliar(lista, "up");
    }

    public static void sort(ListaSimple<?> lista, boolean descendiente)
    {
        if (descendiente) {
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
            BubbleSortAuxiliarInteger(list, lista.size() - 1, order);
        }
        else if (lista.getHead().getData().getClass().getName().equals("java.lang.String"))
        {
            ListaSimple<String> list = (ListaSimple<String>) lista;
            BubbleSortAuxiliarString(list, lista.size() - 1, order);
        }
        else
        {
            ListaSimple<Comparable> list = (ListaSimple<Comparable>) lista;
            BubbleSortAuxiliarComparable(list, lista.size() - 1, order);
        }
    }

    private static void BubbleSortAuxiliarInteger(ListaSimple<Integer> list, int amount, String order)
    {
        if (order.equals("up")) {
            for (int out = amount; out > 0; out--) {
                for (int in = 0; in < out; in++) {
                    if (((Integer)list.get(in)).intValue() > ((Integer)list.get(in + 1)).intValue()) {
                        list.swap(in, in + 1);
                    }
                }
            }
        } else {
            for (int out = amount; out > 0; out--) {
                for (int in = 0; in < out; in++) {
                    if (((Integer)list.get(in)).intValue() < ((Integer)list.get(in + 1)).intValue()) {
                        list.swap(in, in + 1);
                    }
                }
            }
        }
    }

    private static void BubbleSortAuxiliarString(ListaSimple<String> list, int amount, String order)
    {
        if (order.equals("up")) {
            for (int out = amount; out > 0; out--) {
                for (int in = 0; in < out; in++) {
                    if (((String)list.get(in)).compareTo((String)list.get(in + 1)) > 0) {
                        list.swap(in, in + 1);
                    }
                }
            }
        } else {
            for (int out = amount; out > 0; out--) {
                for (int in = 0; in < out; in++) {
                    if (((String)list.get(in)).compareTo((String)list.get(in + 1)) < 0) {
                        list.swap(in, in + 1);
                    }
                }
            }
        }
    }

    private static void BubbleSortAuxiliarComparable(ListaSimple<Comparable> list, int amount, String order)
    {
        if (order.equals("up")) {
            for (int out = amount; out > 0; out--) {
                for (int in = 0; in < out; in++) {
                    if (((Comparable)list.get(in)).compareTo(list.get(in + 1)) > 0) {
                        list.swap(in, in + 1);
                    }
                }
            }
        } else {
            for (int out = amount; out > 0; out--) {
                for (int in = 0; in < out; in++) {
                    if (((Comparable)list.get(in)).compareTo(list.get(in + 1)) < 0) {
                        list.swap(in, in + 1);
                    }
                }
            }
        }
    }
}
