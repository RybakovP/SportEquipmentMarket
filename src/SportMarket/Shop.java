package SportMarket;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by PavelRPL on 13.04.2017.
 */
public class Shop
{
    private Map<SportEquipment,Integer> goods = new HashMap<SportEquipment,Integer>();
     private SportEquipment item;



    public void add(SportEquipment equipment,Integer count)
    {
        goods.put(equipment,count);

    }
    public  void add(SportEquipment equipment)
    {
        SportEquipment existingSportEquipment = search(equipment.Title());

        if(existingSportEquipment!=null){
            Integer countRealElements = goods.get(existingSportEquipment);
            Integer newRealElement;
            newRealElement=countRealElements +1;
            goods.replace(existingSportEquipment,countRealElements,newRealElement);
        }
        else{
            goods.put(equipment,1);
        }



    }
    public SportEquipment search(String title)
    {
        for(Map.Entry<SportEquipment,Integer> e: goods.entrySet())
        {
            SportEquipment item = e.getKey();
            if(item.Title().equals(title))
            {
                return item;
            }
        }
        System.out.println("Sport equipment does't exist");
         return  null ;
    }


    public void printAll()
    {
        for(Map.Entry<SportEquipment,Integer> e : goods.entrySet())
        {
            SportEquipment item = e.getKey();
            System.out.println(item.getCategory()+" "+item.Title()+" "+item.Price()+" "+e.getValue());
        }
    }
    public void printAllBalance()
    {
        for(Map.Entry<SportEquipment,Integer> e : goods.entrySet())
        {
            if(e.getValue()>0)
            {
                SportEquipment item = e.getKey();
                System.out.println(item.getCategory()+" "+item.Title()+" "+item.Price()+" "+e.getValue());
            }
        }
    }
    public ArrayList<SportEquipment>  rent(String title,Integer count){
        SportEquipment foundItem = search(title);
        if(foundItem !=null)
        {
            Integer countRealElements = goods.get(foundItem);
            Integer newCount;
            if(countRealElements >=count)
            {
                ArrayList<SportEquipment> rentItems = new ArrayList<SportEquipment>();
                for(int i =0;i<count;i++)
                {
                    rentItems.add(foundItem);
                }
                newCount= countRealElements - count;
                goods.replace(foundItem,countRealElements,newCount);
                return rentItems;
            }
            else
                {
                    System.out.println("Shop doesn't contains requaird counts of element");
                }
        }
        else
            {
                System.out.println("Shop doesn't contains requaird counts of element");
            }
            return null;
    }

   /* public void removeElement(String title,Integer countToRemove)
    {
        SportEquipment item = search(title);
        if(item!=null)
        {
          Integer counts =  goods.get(item);
          counts = counts-countToRemove;
        }
        goods.replace(equipment,oldCount,newCount);
    }
*/
    public Map<SportEquipment,Integer> getall()
    {
      return  goods;
    }
    public Integer getCurrentCountOfEcuipment(SportEquipment equipment)
    {
        return goods.get(equipment);
    }
}



