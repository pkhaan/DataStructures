//Program that illustates Eratosthenes' thought
class Primes {
public static void main(String[] args) {
 int N = Integer.parseInt(args[0]);
 boolean[] a = new boolean[N];
  for (int i = 2; i < N; i++) a[i] = true;
  for (int i = 2; i < N; i++)
     if (a[i])
   for (int j = i; j*i < N; j++)
 a[i*j] = false;//πολλαπλάσια του i
 //που δεν είναι πρώτοι
   for (int i = 2; i < N; i++)
        if (a[i]) System.out.printl	n(" " + i);
 System.out.println();
 }
} 