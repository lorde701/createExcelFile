import lombok.Getter;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;


class PersonData extends Data{

    @Getter
    private String name;

    @Getter
    private String lastName;

    @Getter
    private String patronymic;

    @Getter
    private Integer age;

    @Getter
    private String gender;

    @Getter
    private Date birthDate;

    @Getter
    private String birthPlace;

    private final int MALE = 1;
    private final int FEMALE = 0;
    private int intGender;


    PersonData() throws IOException {

        intGender = (int) (Math.random() * 2);
        if (intGender == FEMALE) {
            gender = "Женский";
            name = getRandomData("./dictionaries/Женские имена.txt", false);
        } else {
            gender = "Мужской";
            name = getRandomData("./dictionaries/Мужские имена.txt", true);
        }
        patronymic = getRandomData("./dictionaries/Отчества.txt", intGender == MALE);
        lastName = getRandomData("./dictionaries/Фамилии.txt", intGender == MALE);

        birthDate = getRandomDate();
        birthPlace = getRandomData("./dictionaries/Города.txt");
        age = getAge(birthDate);
    }

    private Date getRandomDate() {

        //дата 100 лет назад
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.YEAR, -60);

        //текущая дата
        Calendar currentCalendar = Calendar.getInstance();

        //генерация случайной даты
        long dateInMillis =  (long)(Math.random() * (currentCalendar.getTimeInMillis() - calendar.getTimeInMillis())) + calendar.getTimeInMillis();
        return new Date(dateInMillis);
    }

    private int getAge(Date birthDate) {
        Calendar birthCalendar = Calendar.getInstance();
        birthCalendar.setTime(birthDate);
        int birthYear = birthCalendar.get(Calendar.YEAR);
        int birthMonth = birthCalendar.get(Calendar.MONTH);

        Calendar currentCalendar = Calendar.getInstance();
        int currentYear = currentCalendar.get(Calendar.YEAR);
        int currentMonth = currentCalendar.get(Calendar.MONTH);

        int age = currentYear - birthYear;
        if (currentMonth < birthMonth) {
            age--;
        } else if (currentMonth == birthMonth) {
            int currentDay = currentCalendar.get(Calendar.DAY_OF_MONTH);
            int birthDay = birthCalendar.get(Calendar.DAY_OF_MONTH);
            if (currentDay < birthDay) {
                age--;
            }
        }
        return age;
    }
}
