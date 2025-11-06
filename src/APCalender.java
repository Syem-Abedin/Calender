public class APCalender {
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0) && ((year % 100 != 0) || (year % 400 == 0));
    }

    public static int numberOfLeapYears(int year1, int year2) {
        int i = 0;
        while (year1 <= year2) {
            if (isLeapYear(year1)) {
                i++;
                year1++;
            }
            year1++;
        }
        return i;
    }

    public static int firstDayOfYear(int year) {
        int day = 1;
        for (int y = 1900; y < year; y++) {
            if (isLeapYear(y)) {
                day = day + 366;
            } else {
                day = day + 365;
            }
        }
        return day % 7;
    }

    public static int dayOfYear(int month, int day, int year) {
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) {
            days[1] = 29;
        }
        int total = 0;
        for (int i = 0; i < month - 1; i++) {
            total += days[i];
        }
        total += day;
        return total;
    }

    public static int dayOfWeek(int month, int day, int year) {
        return (firstDayOfYear(year) + dayOfYear(month, day, year) - 1) % 7;
    }
}

