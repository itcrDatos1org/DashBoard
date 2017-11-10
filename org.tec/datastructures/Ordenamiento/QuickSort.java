package datastructures.Ordenamiento;

import datastructures.DatosLineales.ListaSimple;
/**
 * Created by HP Probook 6475b on 10/11/2017.
 */
public class QuickSort
{
    public static void sort(ListaSimple<?> lista, boolean descendant)
    {
        if (descendant) {
            sortAuxiliar(lista, "down");
        } else {
            sortAuxiliar(lista, "up");
        }
    }

    public static void sort(ListaSimple<?> lista)
    {
        sortAuxiliar(lista, "up");
    }

    private static void sortAuxiliar(ListaSimple<?> lista, String order)
    {
        if (lista.getHead().getData().getClass().getName().equals("java.lang.Integer"))
        {
            ListaSimple<Integer> list = (ListaSimple<Integer>) lista;
            if (order.equals("up")) {
                QuickSortAuxiliarIntegerAscendent(list, 0, lista.size() - 1);
            } else {
                QuickSortAuxiliarIntegerDescendant(list, 0, lista.size() - 1);
            }
        }
        else if (lista.getHead().getData().getClass().getName().equals("java.lang.String"))
        {
            ListaSimple<String> list = (ListaSimple<String>) lista;
            if (order.equals("up")) {
                QuickSortAuxiliarStringAscendant(list, 0, lista.size() - 1);
            } else {
                QuickSortAuxiliarStringDescendant(list, 0, lista.size() - 1);
            }
        }
        else
        {
            ListaSimple<Comparable> list = (ListaSimple<Comparable>) lista;
            if (order.equals("up")) {
                QuickSortAuxiliarComparableAscendant(list, 0, lista.size() - 1);
            } else {
                QuickSortAuxiliarComparableDescendant(list, 0, lista.size() - 1);
            }
        }
    }

    private static void QuickSortAuxiliarIntegerAscendent(ListaSimple<Integer> list, int left, int last)
    {
        int pivot = ((Integer)list.get((left + last) / 2)).intValue();
        int i = left;
        int j = last;
        do
        {
            while (((Integer)list.get(i)).intValue() < pivot) {
                i++;
            }
            while (((Integer)list.get(j)).intValue() > pivot) {
                j--;
            }
            if (i <= j)
            {
                list.swap(i, j);
                i++;
                j--;
            }
        } while (

                i <= j);
        if (left < j) {
            QuickSortAuxiliarIntegerAscendent(list, left, j);
        }
        if (i < last) {
            QuickSortAuxiliarIntegerAscendent(list, i, last);
        }
    }

    private static void QuickSortAuxiliarIntegerDescendant(ListaSimple<Integer> list, int left, int last)
    {
        int pivot = ((Integer)list.get((left + last) / 2)).intValue();
        int i = left;
        int j = last;
        do
        {
            while (((Integer)list.get(i)).intValue() > pivot) {
                i++;
            }
            while (((Integer)list.get(j)).intValue() < pivot) {
                j--;
            }
            if (i <= j)
            {
                list.swap(i, j);
                i++;
                j--;
            }
        } while (

                i <= j);
        if (left < j) {
            QuickSortAuxiliarIntegerDescendant(list, left, j);
        }
        if (i < last) {
            QuickSortAuxiliarIntegerDescendant(list, i, last);
        }
    }

    private static void QuickSortAuxiliarStringAscendant(ListaSimple<String> list, int left, int last)
    {
        String pivot = (String)list.get((left + last) / 2);
        int i = left;
        int j = last;
        do
        {
            while (((String)list.get(i)).compareTo(pivot) < 0) {
                i++;
            }
            while (((String)list.get(j)).compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j)
            {
                list.swap(i, j);
                i++;
                j--;
            }
        } while (

                i <= j);
        if (left < j) {
            QuickSortAuxiliarStringAscendant(list, left, j);
        }
        if (i < last) {
            QuickSortAuxiliarStringAscendant(list, i, last);
        }
    }

    private static void QuickSortAuxiliarStringDescendant(ListaSimple<String> list, int left, int last)
    {
        String pivot = (String)list.get((left + last) / 2);
        int i = left;
        int j = last;
        do
        {
            while (((String)list.get(i)).compareTo(pivot) > 0) {
                i++;
            }
            while (((String)list.get(j)).compareTo(pivot) < 0) {
                j--;
            }
            if (i <= j)
            {
                list.swap(i, j);
                i++;
                j--;
            }
        } while (

                i <= j);
        if (left < j) {
            QuickSortAuxiliarStringAscendant(list, left, j);
        }
        if (i < last) {
            QuickSortAuxiliarStringAscendant(list, i, last);
        }
    }

    private static void QuickSortAuxiliarComparableAscendant(ListaSimple<Comparable> list, int left, int last)
    {
        Comparable pivot = (Comparable)list.get((left + last) / 2);
        int i = left;
        int j = last;
        do
        {
            while (((Comparable)list.get(i)).compareTo(pivot) < 0) {
                i++;
            }
            while (((Comparable)list.get(j)).compareTo(pivot) > 0) {
                j--;
            }
            if (i <= j)
            {
                list.swap(i, j);
                i++;
                j--;
            }
        } while (

                i <= j);
        if (left < j) {
            QuickSortAuxiliarComparableAscendant(list, left, j);
        }
        if (i < last) {
            QuickSortAuxiliarComparableAscendant(list, i, last);
        }
    }

    private static void QuickSortAuxiliarComparableDescendant(ListaSimple<Comparable> list, int left, int last)
    {
        Comparable pivot = (Comparable)list.get((left + last) / 2);
        int i = left;
        int j = last;
        do
        {
            while (((Comparable)list.get(i)).compareTo(pivot) > 0) {
                i++;
            }
            while (((Comparable)list.get(j)).compareTo(pivot) < 0) {
                j--;
            }
            if (i <= j)
            {
                list.swap(i, j);
                i++;
                j--;
            }
        } while (

                i <= j);
        if (left < j) {
            QuickSortAuxiliarComparableDescendant(list, left, j);
        }
        if (i < last) {
            QuickSortAuxiliarComparableDescendant(list, i, last);
        }
    }
}

