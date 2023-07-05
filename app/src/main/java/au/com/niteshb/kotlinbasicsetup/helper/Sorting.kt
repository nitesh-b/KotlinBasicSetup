package au.com.niteshb.kotlinbasicsetup.helper

class Sorting {


     fun bubbleSort(array: IntArray): IntArray {
         println("Bubble sort")
         val arrSize = array.size
         for ( i  in 0 until arrSize) {
             for (k in 0 until arrSize - i - 1) {
                 if (array[k] > array[k + 1]) {
                     val temp = array[k]
                     array[k] = array[k + 1]
                     array[k + 1] = temp
                 }
             }
             println(array.contentToString())
         }
         return  array
    }

     fun insertionSort(array: IntArray): IntArray {
         println("\nInsertion sort")
         val arrSize = array.size
         for ( i  in 1 until arrSize) {
             val key = array[i]
             var j = i - 1
             while (j >= 0 && array[j] > key) {
                 array[j+1] = array[j]
                 j--
             }
             array[j + 1] = key

             println(array.contentToString())
         }
        return array
    }

}