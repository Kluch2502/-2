public class Main{
    
    public static void main(String []args){
        System.out.println(isStrangePair("ratio", "orator"));
        System.out.println(successShoot(0, 0, 5, 2, 2));  
        System.out.println(parityAnalysis(243));
        System.out.println(rps("rock", "paper"));
        System.out.println(bugger(39));
        Object[][] inventory = {
            {"Скакалка", 550.00, 8},
            {"Шлем", 3750.00, 4},
            {"Мяч", 2900.00, 10}
        };
        Object[] mostValuableItem = mostExpensive(inventory);
        if (mostValuableItem != null) {
            System.out.println("Наиболее ценный предмет: " + mostValuableItem[0] + " - " + mostValuableItem[1]);
        }
        System.out.println(longestUnique("abcba")); 
        System.out.println(isPrefix("automation", "auto-"));  
        System.out.println(isSuffix("arachnophobia", "-phobia")); 
        System.out.println(doesBrickFit(1, 1, 1, 1, 1));

    }

    public static boolean isStrangePair(String str1, String str2) {
        if (str1.isEmpty() && str2.isEmpty()) return true;
        if (str1.isEmpty() || str2.isEmpty()) return false;
        return str1.charAt(0) == str2.charAt(str2.length() - 1) && str1.charAt(str1.length() - 1) == str2.charAt(0);
    }


    public static boolean successShoot(int x, int y, int r, int m, int n) {
        return Math.pow(m - x, 2) + Math.pow(n - y, 2) <= Math.pow(r, 2);
    }

    public static boolean parityAnalysis(int num){
       
        int sum = 0, temp = num;
        while (temp > 0) {
            sum += temp % 10;
            temp /= 10;
        }
        return (num % 2 == sum % 2);
        
    }

    public static String rps(String p1, String p2) {
        if (p1.equals(p2)) return "Tie";
        if ((p1.equals("rock") && p2.equals("scissors")) ||
            (p1.equals("scissors") && p2.equals("paper")) ||
            (p1.equals("paper") && p2.equals("rock"))) {
            return "Player 1 wins";
        }
        return "Player 2 wins";
    }

    public static int bugger(int num) {
        int count = 0;
        while (num >= 10) {
            num = multiplyDigits(num);
            count++;
        }
        return count;
    }

    private static int multiplyDigits(int num) {
        int product = 1;
        while (num > 0) {
            product *= num % 10;
            num /= 10;
        }
        return product;
    }

    public static Object[] mostExpensive(Object[][] inventory) {
        Object[] mostValuableItem = null;
        double maxValue = 0;

        for (Object[] item : inventory) {
            String name = (String) item[0];
            double price = (double) item[1];
            int quantity = (int) item[2];

            
            double totalValue = price * quantity;

            
            if (totalValue > maxValue) {
                maxValue = totalValue;
                mostValuableItem = new Object[]{name, totalValue};
            }
        }

        return mostValuableItem;
    }

    public static String longestUnique(String s) {
        String longestSubstring = "";
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 1; j <= s.length(); j++) {
                String substring = s.substring(i, j);
                if (hasUniqueChars(substring) && substring.length() > longestSubstring.length()) {
                    longestSubstring = substring;
                }
            }
        }
        return longestSubstring;
    }
    private static boolean hasUniqueChars(String str) {
        for (int i = 0; i < str.length(); i++) {
            for (int j = i + 1; j < str.length(); j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean isPrefix(String word, String prefix) {
        return word.startsWith(prefix.substring(0, prefix.length() - 1));
    }

    public static boolean isSuffix(String word, String suffix) {
        return word.endsWith(suffix.substring(1));
    }

    public static boolean doesBrickFit(int a, int b, int c, int w, int h) {
        return (a <= w && b <= h) || (a <= h && b <= w) ||
               (a <= w && c <= h) || (a <= h && c <= w) ||
               (b <= w && c <= h) || (b <= h && c <= w);
    }

}