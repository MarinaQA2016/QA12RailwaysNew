package ru.stqa.selenium;

import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class DataProviders {
    //Takes data from file
    @DataProvider
    public static Iterator<Object[]> positiveSearchTrains() throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(
                DataProviders.class.getResourceAsStream("/searchTrains.data")));

        List<Object[]> userData = new ArrayList<Object[]>();
        String line = in.readLine();
        while (line != null) {
            userData.add(line.split(";"));
            line = in.readLine();
        }
        in.close();
        return userData.iterator();
    }



    @DataProvider
    public static Iterator<Object[]> anotherPositiveSearchTrain() {
        List<Object[]> data = new ArrayList<Object[]>();
        data.add(new Object[]{"Binyamina", "Atlit"});
        data.add(new Object[]{"Ashkelon", "Be'er Ya'akov"});
        data.add(new Object[]{"Bet Shemesh", "Dimona"});
        data.add(new Object[]{"Hertsliya", "Rehovot (E. Hadar)"});
        return data.iterator();
    }

    //-------DataProvider for add employee-----//


    @DataProvider
    public Iterator<Object[]> users() {
        List<Object[]> data = new ArrayList<Object[]>();
        for (int i = 0; i < 5; i++) {
            data.add(new Object[]{
                    generateRandomName(), generateRandomPassword()
            });
        }
        return data.iterator();
    }

    private Object generateRandomPassword() {
        return "pass" + new Random().nextInt();
    }
    //---------------End--------------------//

    private Object generateRandomName() {
        return "demo" + new Random().nextInt();
    }
}