package HW2.Task1;

class DateValidator {
    public static String validateDate(String date) {
        try {
            // Проверка длины строки
            if (date.length() != 10) {
                return "Invalid date format. Please use YYYY-MM-DD.";
            }
            // Деление строки на компоненты
            String yearStr = date.substring(0, 4);
            String monthStr = date.substring(5, 7);
            String dayStr = date.substring(8, 10);
            // Проверка формата разделителей
            if (date.charAt(4) != '-' || date.charAt(7) != '-') {
                return "Invalid date format. Please use YYYY-MM-DD.";
            }
            // Преобразование компонентов в числа
            int year = Integer.parseInt(yearStr);
            int month = Integer.parseInt(monthStr);
            int day = Integer.parseInt(dayStr);
            // Проверка диапазона года
            if (year < 1 || year > 9999) {
                return "Year out of range. Must be between 0001 and 9999.";
            }
            // Проверка диапазона месяца
            if (month < 1 || month > 12) {
                return "Month out of range. Must be between 01 and 12.";
            }
            // Проверка диапазона дня
            int[] daysInMonth = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
            if (month == 2 && isLeapYear(year)) {
                daysInMonth[1] = 29; // Февраль в високосный год
            }
            if (day < 1 || day > daysInMonth[month - 1]) {
                return "Day out of range for the given month.";
            }
            return date;
        } catch (NumberFormatException e) {
            // Сообщение об ошибке в случае ошибки преобразования чисел
            return "Error parsing date components.";
        } catch (Exception e) {
            // Сообщение об ошибке в случае других ошибок
            return "An error occurred while validating the date.";
        }
    }

    // Метод для проверки високосного года
    private static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }
}

public class Printer {
    public static void main(String[] args) {
        String date;
        if (args.length > 0) {
            date = args[0];
        } else {
            date = "2025-07-12"; // Значение по умолчанию
        }
        String result = DateValidator.validateDate(date);
        System.out.println(result);
    }
}