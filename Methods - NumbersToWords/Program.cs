using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;

namespace Methods___NumbersToWords
{
    class Program
    {
        static void Main(string[] args)
        {

            //Varables 
            int hundreds, length, findingTeens, number;
            String convertedNumber;
            Console.WriteLine("Number to Word\nThis will convert any number from 1 to 999 to its word representation");
            Console.Write("Enter an number: ");
            number = int.Parse(Console.ReadLine());

            convertedNumber = "" + number;
            length = convertedNumber.Length;

            if (length > 3)
            {
                Console.WriteLine("To big of number");
            }
            else if (length < 3)
            {
                toTwoDigits(number);
            }
            else
            {
                spellHundred(number);
            }
        }

        public static void toTwoDigits(int number)
        {
            int ten, ones;
            ten = number / 10;
            ones = number % 10;
            if (number < 20 && number > 9)
            {
                spellTeens(number);
            }
            else
            {
                if (ten > 1)
                {
                    spellTens(ten);
                }
                if (ones > 0)
                {
                    spellOnes(ones);
                }
                Console.Write(" ");
            }
        }
        public static void spellOnes(int one)
        {
            switch (one)
            {
                case 1:
                    Console.Write("One");
                    break;
                case 2:
                    Console.Write("Two");
                    break;
                case 3:
                    Console.Write("Three");
                    break;
                case 4:
                    Console.Write("Four");
                    break;
                case 5:
                    Console.Write("Five");
                    break;
                case 6:
                    Console.Write("Six");
                    break;
                case 7:
                    Console.Write("Seven");
                    break;
                case 8:
                    Console.Write("Eight");
                    break;
                case 9:
                    Console.Write("Nine");
                    break;

            }
        }

        public static void spellTens(int tens)
        {

            if (tens < 6 || tens == 8)
            {
                switch (tens)
                {
                    case 2:
                        Console.Write("Twenty ");
                        break;
                    case 3:
                        Console.Write("Thirty ");
                        break;
                    case 4:
                        Console.Write("Fourty ");
                        break;
                    case 5:
                        Console.Write("Fifty ");
                        break;
                    case 8:
                        Console.Write("Eighty ");
                        break;
                }
            }
            else if (tens != 0)
            {
                spellOnes(tens);
                Console.Write("ty ");
            }
        }
        public static void spellTeens(int teens)
        {
            int shortCut;
            if (teens < 16 || teens == 18)
            {
                switch (teens)
                {
                    case 10:
                        Console.Write("Ten");
                        break;
                    case 11:
                        Console.Write("Eleven");
                        break;
                    case 12:
                        Console.Write("Twelve");
                        break;
                    case 13:
                        Console.Write("Thirdteen");
                        break;
                    case 14:
                        Console.Write("Fourteen");
                        break;
                    case 15:
                        Console.Write("Fifteen");
                        break;
                    case 18:
                        Console.Write("Eighteen");
                        break;

                }
            }
            else
            {
                shortCut = teens % 10;
                spellOnes(shortCut);
                Console.Write("teen \n");
            }
        }
        public static void spellHundred(int number)
        {
            int hundred, twoDig;

            hundred = number / 100;
            twoDig = number % 100;

            spellOnes(hundred);
            Console.Write(" Hundred");

            if (twoDig != 0)
            {
                Console.Write(" and ");
                toTwoDigits(twoDig);
            }
        

        }

        protected void example()
        {
            Console.WriteLine("THis also works");
        }

        private static readonly int i = 1;

        public static const double e = 2.2;
    }
}
