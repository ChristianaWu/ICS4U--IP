using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Loop_FibonacciSeries
{
    class Program
    {
        static void Main(string[] args)
        {
            //Into 
            Console.WriteLine("Fibonacci Series\n" + "Program that will print the first twenty terms of this series\n");
            //Varables 
            int a = 1, b = 1, c;

            //Prossesing
            Console.WriteLine("1 1 ");
            do
            {
                c = a + b;
                Console.WriteLine(c + " ");
                a = b;
                b = c;

            } while (c < 6765);

        }
    }
}
