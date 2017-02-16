
public class PointOfSale {

    private String name;
    private String category;
    private String description;
    String price;

    public PointOfSale(String name, String category, String description, String price) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
    @Override
    public String toString() {
        return String.format("%-25s" + "%-15s" + "%-25s" + "%-25s", name, category, description, price);
    }
}
