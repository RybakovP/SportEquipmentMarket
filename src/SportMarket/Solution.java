package SportMarket;


import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by PavelRPL on 13.04.2017.
 */
public class Solution {
    public static void  main(String[] args) throws IOException {

        List<SportEquipment>  equipments = getEquipmentsFromFile();



        //Прочитать из фалика и добавить в Shop
        RentUnit rentUnit = new RentUnit();
        Shop sportmarket = new Shop();
        for(SportEquipment e: equipments)
        {
            sportmarket.add(e);
        }
      /*  SportEquipment ball = new SportEquipment(new Category("equipment"),"ball",12500);
        SportEquipment jumprope = new SportEquipment(new Category("equipment"),"jumprope",6000);
        SportEquipment dummbells = new SportEquipment(new Category("equipment"),"dummbells",11000);
        sportmarket.add(ball);
        sportmarket.add(ball);
        sportmarket.add(jumprope,1);
        sportmarket.add(dummbells,1);
       //rentUnit.add(ball);
        //rentUnit.add(jumprope);*/
        int z ;
        z=1;
        while (z!=0)
        {
            switch (menu()) {
                case 1: {
                    System.out.println("Sport equipment: ");
                    String title = reader.readLine();
                    if (!title.isEmpty()) {

                            SportEquipment item = sportmarket.search(title);
                            if(item !=null)
                            {
                            System.out.println(item.getCategory() + " " + item.Title() + " " + item.Price() + " " + sportmarket.getCurrentCountOfEcuipment(item));
                            }
                    } else {
                        System.out.println("Title is empty");
                    }
                }
                    break;
                case 2:
                    sportmarket.printAllBalance();
                    break;
                case 3:
                    sportmarket.printAll();
                    break;
                case 4:
                    rentUnit.printRent();
                    break;
                case 5:
                {
                    System.out.println("Sport equipment: ");
                    String title = reader.readLine();
                    System.out.println("Sport equipment count: ");
                    Integer count = Integer.parseInt(reader.readLine());
                    Integer rentedUnits = rentUnit.getCurrentCountOfUnit();
                    if(rentedUnits + count <=3)
                    {


                        ArrayList<SportEquipment> listofrents = sportmarket.rent(title,count);
                        if(listofrents!= null && listofrents.size() > 0)
                        {
                            for (SportEquipment e : listofrents) {
                                rentUnit.add(e);
                            }
                            System.out.println( count+" element(s) added ");
                        }
                    }

                        else
                            {
                                System.out.println(" your limit is exceed ");

                            }

                    //limint bla bl a bla
                }
                    break;
                case 0: z = 0;
                    break;
            }
        }

    }

    private static List<SportEquipment> getEquipmentsFromFile() {
        Gson gson = new Gson();

        try (Reader reader = new FileReader("D:\\test.json")) {

            // Convert JSON to Java Object
       //     JsonElement json = gson.fromJson(reader, JsonElement.class);
       //     SportEquipment se = gson.fromJson(reader, SportEquipment.class);
           List<SportEquipment> list = gson.fromJson(reader, new TypeToken<List<SportEquipment>>(){}.getType());

            return list;

            // Convert JSON to JsonElement, and later to String
            /*JsonElement json = gson.fromJson(reader, JsonElement.class);
            String jsonInString = gson.toJson(json);
            System.out.println(jsonInString);*/

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static  BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public static  int menu() throws IOException {
        System.out.println("1: Search product");
        System.out.println("2: Print information about goods in stock");
        System.out.println("3: Print inormation about all goods");
        System.out.println("4: Print information about goods in rent");
        System.out.println("5: Rent goods");
        System.out.println("0: Exit");
        int menuItem = Integer.parseInt(reader.readLine());
        return menuItem;
    }

}
