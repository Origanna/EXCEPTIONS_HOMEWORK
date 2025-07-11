package HW1.Task1;

class Answer {
    public static int convertAndSum(String[] strings) {
        int sum = 0;
        for (String s : strings) {
            try {
                int number = Integer.parseInt(s);
                sum += number;
            } catch (NumberFormatException e) {
                throw new NumberFormatException("Ошибка преобразования строки в число: " + s);
            }
        }
        if (sum > 100) {
            throw new ArithmeticException("Превышен лимит суммы");
        }
        return sum;
    }
}

public class Printer {
    public static void main(String[] args) {
        // Первая попытка: корректный ввод
        try {
            String[] strings = { "10", "20", "70" };
            System.out.println(Answer.convertAndSum(strings));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        // Вторая попытка: ввод с некорректным числом
        try {
            String[] invalidStrings = { "10", "20", "abc" };
            System.out.println(Answer.convertAndSum(invalidStrings));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
        // Третья попытка: сумма превышает лимит
        try {
            String[] overLimitStrings = { "50", "60" };
            System.out.println(Answer.convertAndSum(overLimitStrings));
        } catch (NumberFormatException e) {
            System.out.println(e.getMessage());
        } catch (ArithmeticException e) {
            System.out.println(e.getMessage());
        }
    }
}
