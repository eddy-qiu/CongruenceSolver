import java.util.ArrayList;

// Solves a system of linear congruencies with the Chinese Remainder Theorem
public class solver {
    public static void solve(ArrayList<Integer> vals, ArrayList<Integer> mods) {
        int m = 1, x = 0;
        boolean valid = true;

        if (vals != null && mods != null && vals.size() == mods.size() && vals.size() != 0) {

            // check if the mods are pairwisely relatively prime
            if (vals.size() != 1) {
                for (int i = 0; i < mods.size() - 1; i++) {
                    for (int j = i + 1; j < mods.size() - i; j++) {
                        if (gcd(mods.get(i), mods.get(j)) != 1)
                            valid = false;
                    }
                }
            }

            if (valid) {
                for (int i = 0; i < mods.size(); i++)
                    m *= mods.get(i); // multiply the modulos to get m

                for (int i = 0; i < mods.size(); i++)
                    // Chinese Remainder Theorem formula
                    x += (vals.get(i) * (m / mods.get(i)) * (m / mods.get(i) % mods.get(i)));

                System.out.println(x);
            } else
                System.out.println("Mod input is not pairwise relatively prime!");
        } else {
            System.out.println("Input Error!");
        }
    }

    public static int gcd(int a, int b) {
        // if b=0, a is the GCD
        if (b == 0)
            return a;

        // call the gcd() method recursively by
        // replacing a with b and b with
        // difference(a,b) as long as b != 0
        else
            return gcd(b, Math.abs(a - b));
    }

    public static void main(String[] args) {
        // To run the program, create two lists and fill them in with the
        // corresponding modulus and value elements similar to the example below

        // ArrayList<Integer> a = new ArrayList<>();
        // a.add(2);
        // a.add(3);
        // a.add(2);
        // ArrayList<Integer> b = new ArrayList<>();
        // b.add(3);
        // b.add(5);
        // b.add(7);
        // solve(a, b);
        // prints 233
    }
}
