import lombok.Getter;

import java.io.IOException;

class ResidencePlace extends Data{

    @Getter
    private Integer postCode;

    @Getter
    private String country;

    @Getter
    private String region;

    @Getter
    private String city;

    @Getter
    private String street;

    @Getter
    private Integer house;

    @Getter
    private Integer flat;

    ResidencePlace() throws IOException {
        postCode = (int) (Math.random() * 1000000);
        country = "Россия";
        region = getRandomData("./dictionaries/Области.txt");
        city = getRandomData("./dictionaries/Города.txt");
        street = getRandomData("./dictionaries/Улицы.txt");
        house = (int) (Math.random() * 100) + 1;
        flat = (int) (Math.random() * 1000) + 1;
    }
}