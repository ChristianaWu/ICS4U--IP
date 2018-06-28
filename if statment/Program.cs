using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace ICS4U_Christiana
{
    class Program
    {
        static void Main(string[] args)
        {
            // Into 
            Console.WriteLine("Acid rain is an environmental problem. This program determins if the pH level in the water is safe for fish.");

            //Varibles
            double pH;

            //Input
            Console.Write(" The pH of the water is: ");
            pH = double.Parse(Console.ReadLine());

            //Prossesing & Output
            if (pH <= 0)
            {
                Console.WriteLine("This is not a vaild pH.");
            }
            else if (pH <= 6.4)
            {
                Console.WriteLine("TOO ACIDIC - FISH IN STREAMS, RIVERS AND LAKES WILL NOT SURVIVE.");
            }
            else if (pH <= 7.4)
            {
                Console.WriteLine("NEUTRAL - FISH IN STREAMS, RIVERS AND LAKES WILL SURVIVE.");
            }
            else
            {
                Console.WriteLine("TOO ALKALINE - FISH IN STREAMS, RIVERS AND LAKES WILL NOT SURVIVE.");
            }
        }
    }
}
