package Tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;

    public class DataInput {
        public static DecimalFormat df = new DecimalFormat("#.##");

        public static long getLong(String message) throws IOException {
            String s = getString(message);

            return Long.parseLong(s);
        }

        public static char getChar(String message) {
            String s = getString(message);

            return s.charAt(0);
        }

        public static char getLetter(String message) {
            char letter;
            while (true) {
                try {
                    String s = getString(message);
                    letter = s.toLowerCase().charAt(0);
                    if ((letter >= 'a' && letter <= 'z') || (letter >= 'а' && letter <= 'я') && s.length() == 1) {
                        break;
                    } else {
                        System.out.println("Помилка. Введіть літеру українського, російського або англійського алфавіту");
                    }
                } catch (Exception e) {
                    System.out.println("Помилка. Введіть літеру українського, російського або англійського алфавіту");
                }
            }

            return letter;
        }

        public static int getInt(String message) {
            String s;
            int res;

            while (true) {
                try {
                    s = getString(message);
                    res = Integer.parseInt(s);
                    break;
                } catch (Exception e) {
                    System.out.println("Помилка вводу. Введіть ціле число");
                }
            }

            return res;
        }

        public static double getDouble(String message) {
            String s;
            double res;
            while (true) {
                try {
                    s = getString(message);
                    res = Double.parseDouble(s);
                    break;
                } catch (Exception e) {
                    System.out.println("Помилка вводу. Введіть число");
                }
            }

            return res;
        }

        public static String getString(String message) {
            System.out.print(message);
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String name;
            while (true) {
                try {
                    name = br.readLine();
                    break;
                } catch (Exception e) {
                    System.out.print("Помилка вводу. Спробуйте ще раз: ");
                }
            }

            return name;
        }
    }


