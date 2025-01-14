/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sorts;

/**
 *
 * @author Profesor Lic. Gilberth Chaves A.
 */
public class Elementary {
    private int iteracionesTotales = 0;

    private int counterRepeatNumber[];

    private void setArrayLong(int number){
        counterRepeatNumber = new int[number];
    }

    public int[] getCounterRepeatNumber(){
        return this.counterRepeatNumber;
    }

    public int getTotalIteraciones(){
        return iteracionesTotales;
    }

    private String acumulaMinimo;

    private String acumulaIndiceMinimo;

    public String getMinimo() {
        return acumulaMinimo;
    }

    public String getIndiceMinimo() {
        return acumulaIndiceMinimo;
    }

    public void bubbleSort(int a[]){
        this.iteracionesTotales = 0;
        for(int i=1;i<a.length;i++)
            for(int j=0;j<a.length-i;j++){
                if(a[j]>a[j+1]){
                    int aux=a[j];
                    a[j]=a[j+1];
                    a[j+1]=aux;
                }//if
                this.iteracionesTotales++;
            }//for j
    }
    
    public void improvedBubbleSort(int a[]){
        this.iteracionesTotales = 0;
	    boolean swapped = true; //intercambiado
	    for(int i=1;swapped;i++){
            swapped = false;
            for(int j=0;j<a.length-i;j++){
                if(a[j]>a[j+1]){
                    int aux=a[j];
                    a[j]=a[j+1];
                    a[j+1]=aux;
                    swapped = true;
                }//if
                this.iteracionesTotales++;
            }//for j
	    }//for i
    }

    public void selectionSort(int a[]) {
        if (acumulaIndiceMinimo == null) {
            acumulaIndiceMinimo = "";
        }
        if (acumulaMinimo == null) {
            acumulaMinimo = "";
        }

        for (int i = 0; i < a.length - 1; i++) {
            int min = a[i];
            int minIndex = i;
            for (int j = i + 1; j < a.length; j++) {
                if (a[j] < min) {
                    min = a[j];
                    minIndex = j;
                    iteracionesTotales++;
                }
            }
            a[minIndex] = a[i];
            a[i] = min;

            if (acumulaIndiceMinimo != null) {
                acumulaIndiceMinimo += minIndex + " ";
            }
            if (acumulaMinimo != null) {
                acumulaMinimo += min + " ";
            }

        }
    }


    public void countingSort(int a[]) {
        int max = util.Utility.maxArray(a); //va de 0 hasta el elemento maximo
        // create buckets
        int counter[] = new int[max + 1];
        setArrayLong(max + 1);
        // fill buckets
        for (int element : a) {
            counter[element]++; //incrementa el num de ocurrencias del elemento
            this.counterRepeatNumber[element]++;
        }
        // sort array
        int index = 0;
        for (int i = 0; i < counter.length; i++) {
            while (counter[i]>0) { //significa q al menos hay un elemento (q existe)
                a[index++] = i;
                counter[i]--;
            }
        }//for i
    }

}
