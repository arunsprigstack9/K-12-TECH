package objects;

import base.BasePage;
import org.openqa.selenium.WebDriver;

public class PartsDetails {
    private String partname;
    private String price;
    private String quantity;
    private String reorderquantity;
    private String brandname;


    // Getter Methods

    public String getPartname() {
        return partname;
    }

    public String getPrice() {
        return price;
    }

    public String getQuantity() {
        return quantity;
    }

    public String getReorderquantity() {
        return reorderquantity;
    }

    public String getBrandname() {
        return brandname;
    }

    // Setter Methods

    public void setPartname(String partname) {
        this.partname = partname;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public void setReorderquantity(String reorderquantity) {
        this.reorderquantity = reorderquantity;
    }

    public void setBrandname(String brandname) {
        this.brandname = brandname;
    }
}
