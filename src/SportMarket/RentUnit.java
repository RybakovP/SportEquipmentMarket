package SportMarket;

import java.util.Arrays;

/**
 * Created by PavelRPL on 13.04.2017.
 */
public class RentUnit {
    private SportEquipment [] units = new SportEquipment[0];

    public void add(SportEquipment item)
    {
        final int N = units.length;
        if(N <3) {
            units = Arrays.copyOf(units, N + 1);
            units[N] = item;
        }
    }

    public  void printRent()
    {
        for(int i =0;i<units.length;i++)
        {
            System.out.println(units[i].getCategory()+" "+units[i].Title()+" "+units[i].Price());
        }
    }
    public  Integer getCurrentCountOfUnit() {
      return units.length;
    }

}
