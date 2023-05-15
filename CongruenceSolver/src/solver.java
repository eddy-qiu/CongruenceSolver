import java.util.ArrayList;

public class solver {
    public static void solve(ArrayList<Integer> vals, ArrayList<Integer> mods) {
        int m = 1, x = 0;
        if (vals != null && mods != null && vals.size() == mods.size() && vals.size() != 0) {
            for (int i = 0; i < mods.size(); i++)
                m *= mods.get(i); // multiply the modulos to get m

            for (int i = 0; i < mods.size(); i++)
                x += (vals.get(i) * (m / mods.get(i)) * (m / mods.get(i) % mods.get(i)));

            System.out.println(x);
        } else{
            System.out.println("Input Error!");
        }
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
    }
}
