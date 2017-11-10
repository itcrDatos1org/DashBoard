package datastructures.Ordenamiento;

import datastructures.DatosLineales.ListaSimple;
/**
 * Created by HP Probook 6475b on 10/11/2017.
 */
public class ShellSort
{
    public static void sort(ListaSimple<?> lista)
    {
        sortAuxiliar(lista, "up");
    }

    public static void sort(ListaSimple<?> lista, boolean descendant)
    {
        if (descendant) {
            sortAuxiliar(lista, "down");
        } else {
            sortAuxiliar(lista, "up");
        }
    }

    public static void sortAuxiliar(ListaSimple<?> lista, String order)
    {
        if (lista.getHead().getData().getClass().getName().equals("java.lang.Integer"))
        {
            ListaSimple<Integer> list = (ListaSimple<Integer>) lista;
            ShellSortAuxiliarInteger(list, order);
        }
        else if (lista.getHead().getData().getClass().getName().equals("java.lang.String"))
        {
            ListaSimple<String> list = (ListaSimple<String>) lista;
            ShellSortAuxiliarString(list, order);
        }
        else
        {
            ListaSimple<Comparable> list = (ListaSimple<Comparable>) lista;
            ShellSortAuxiliarComparable(list, order);
        }
    }

    private static void ShellSortAuxiliarInteger(ListaSimple<Integer> list, String order)
    {

        if (order.equals("down")) {
            for (int gap = list.size() / 2; gap > 0; gap /= 2) {
                for (int i = gap; i < list.size(); i++)
                {
                    int tmp = ((Integer)list.get(i)).intValue();
                    int j;
                    for (j = i; (j >= gap) && (tmp > ((Integer)list.get(j - gap)).intValue()); j -= gap) {
                        list.setDATA((Integer)list.get(j - gap), j);
                    }
                    list.setDATA(Integer.valueOf(tmp), j);
                }
            }
        } else {
            for (int gap = list.size() / 2; gap > 0; gap /= 2) {
                for (int i = gap; i < list.size(); i++)
                {
                    int tmp = ((Integer)list.get(i)).intValue();
                    int j;
                    for (j = i; (j >= gap) && (tmp < ((Integer)list.get(j - gap)).intValue()); j -= gap) {
                        list.setDATA((Integer)list.get(j - gap), j);
                    }
                    list.setDATA(Integer.valueOf(tmp), j);
                }
            }
        }
    }

    private static void ShellSortAuxiliarString(ListaSimple<String> list, String order)
    {
        if (order.equals("down")) {
            for (int gap = list.size() / 2; gap > 0; gap /= 2) {
                for (int i = gap; i < list.size(); i++)
                {
                    String tmp = (String)list.get(i);
                    int j;
                    for (j = i; (j >= gap) && (tmp.compareTo((String)list.get(j - gap)) > 0); j -= gap) {
                        list.setDATA((String)list.get(j - gap), j);
                    }
                    list.setDATA(tmp, j);
                }
            }
        } else {
            for (int gap = list.size() / 2; gap > 0; gap /= 2) {
                for (int i = gap; i < list.size(); i++)
                {
                    String tmp = (String)list.get(i);
                    int j;
                    for (j = i; (j >= gap) && (tmp.compareTo((String)list.get(j - gap)) < 0); j -= gap) {
                        list.setDATA((String)list.get(j - gap), j);
                    }
                    list.setDATA(tmp, j);
                }
            }
        }
    }

    private static void ShellSortAuxiliarComparable(ListaSimple<Comparable> list, String order)
    {
        if (order.equals("down")) {
            for (int gap = list.size() / 2; gap > 0; gap /= 2) {
                for (int i = gap; i < list.size(); i++)
                {
                    Comparable tmp = (Comparable)list.get(i);
                    int j;
                    for (j = i; (j >= gap) && (tmp.compareTo(list.get(j - gap)) > 0); j -= gap) {
                        list.setDATA((Comparable)list.get(j - gap), j);
                    }
                    list.setDATA(tmp, j);
                }
            }
        } else {
            for (int gap = list.size() / 2; gap > 0; gap /= 2) {
                for (int i = gap; i < list.size(); i++)
                {
                    Comparable tmp = (Comparable)list.get(i);
                    int j;
                    for (j = i; (j >= gap) && (tmp.compareTo(list.get(j - gap)) < 0); j -= gap) {
                        list.setDATA((Comparable)list.get(j - gap), j);
                    }
                    list.setDATA(tmp, j);
                }
            }
        }
    }
}

