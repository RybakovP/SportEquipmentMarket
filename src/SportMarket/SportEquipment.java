package SportMarket;


/**
 * Created by PavelRPL on 13.04.2017.
 */
public class SportEquipment {
    private Category category;
    private String title;
    private int price;

    public SportEquipment(Category category, String title, int price) {
        this.title = title;
        this.category = category;
        this.price = price;
    }

    public String Title() {
        return this.title;
    }
    public int Price()
    {
        return this.price;
    }

    public String getCategory() {
        return category.name;
    }
}
