using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Arrays___Sorting
{
    class Program
    {
        static Random rNumb = new Random();
        static void Main(string[] args)
        {
            int[] a = generateRandomArray(-50, 50, 10);
            printArray(a);
            selectionSort(a, false);
            Console.WriteLine();
            printArray(a);

            int[] b = generateRandomArray(-50, 50, 10);
            printArray(b);
            selectionSort(b, true);
            Console.WriteLine();
            printArray(b);


        }
        //This prints out the intager array so I can produce an array and then print it 
        public static void printArray(int[] data)
        {
            for (int i = 0; i <= data.Length - 1; i++)
            {
                Console.Write(data[i] + ",");
            }
            //System.out.println();
        }
        //Generats Random numbers 
        public static int randomNumber (int startNumb, int max)
        {
            max = max + 1;
            int nRandom = rNumb.Next(startNumb, max);
            return nRandom;
        } 
        //GENERAT RANDOM ARRAY int
        public static int[] generateRandomArray(int min, int max, int lengthArray)
        {
            int[] x = new int[lengthArray];
            for (int i = 0; i < x.Length; i++)
            {
                x[i] = randomNumber(min, max);
            }
            return x;
        }
        //Swap method so I do not need to rewirte the swap this one is with int array
        public static void swap(int[] data, int one, int two)
        {
            int holder;//just atemperary place to put the number when swaping 
            holder = data[one];
            data[one] = data[two];
            data[two] = holder;
        }
        //SELECTION SORT ascending and decending using boolean to help change it using int array
        public static void selectionSort(int[] data, bool asc)
        {
            int minIndex;//the index where the min ofthe array is
            for (int j = 0; j < data.Length; j++)
            {
                minIndex = j;
                for (int i = j + 1; i < data.Length; i++)
                {
                    if (asc)
                    {
                        if (data[minIndex] > data[i])
                        {
                            minIndex = i;
                        }
                    }
                    else if (data[minIndex] < data[i])
                    {
                        minIndex = i;
                    }
                }
                swap(data, j, minIndex);
            }
        }
    }
}
