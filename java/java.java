import java.util.HashMap;
import java.util.Map;

class Main {
    static void printInfo(String id) {
        if (id.length() != 10) {
            System.out.println("Invalid Registry");
            return;
        }

        Map<Character, String> mp = new HashMap<Character, String>() {{
            put('А', "Arkhangai");
            put('Б', "Bayn-Ulgii");
            put('В', "Baynkhongor");
            put('Г', "Bulgai");
            put('Д', "Govi-Altai");
            put('Е', "Dornogovi");
            put('Ж', "Dornod");
            put('З', "Dundgovi");
            put('И', "Zavkhan");
            put('Й', "Uvurkhangai");
            put('К', "Umnugovi");
            put('Л', "Sukhbaatar");
            put('М', "Selegne");
            put('Н', "Tuv");
            put('О', "Uvs");
            put('П', "Khovd");
            put('Р', "Khuvsgul");
            put('С', "Khentii");
            put('Т', "Darkhan-Uul");
            put('Ф', "Orhon");
            put('Х', "Govisumber");
            put('У', "Ulaanbaatar");
            put('Ч', "Ulaanbaatar");
        }};

        char residenceKey = id.charAt(0);
        String residence = mp.getOrDefault(residenceKey, "Unknown Region");

        int birthYear = Integer.parseInt(id.substring(2, 4));
        int birthMonth = Integer.parseInt(id.substring(4, 6));

        if (birthMonth > 20) {
            birthMonth -= 20;
            birthYear += 2000;
        } else {
            birthYear += 1900;
        }

        int birthDay = Integer.parseInt(id.substring(6, 8));
        int genderId = Character.getNumericValue(id.charAt(9));
        boolean isMale = genderId % 2 == 1;

        System.out.println("Region: " + residence);
        System.out.println("Birth Year: " + birthYear);
        System.out.println("Birth Month: " + birthMonth);
        System.out.println("Birth Day: " + birthDay);
        System.out.println("Gender: " + (isMale ? "Male" : "Female"));
    }

    public static void main(String[] args) {
        String registry = "УК08282851";
        printInfo(registry);
    }
}
