package model;

public class InvoiceItens {

    private String stockID;
    private String name;
    private String qty;
    private String sellingPrice;
    private String exp;
    private String discount;


    public String getStockID() {
        return stockID;
    }


    public void setStockID(String stockID) {
        this.stockID = stockID;
    }




    /**
     * @return the name
     */
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public String getQty() {
        return qty;
    }


    public void setQty(String qty) {
        this.qty = qty;
    }

    
    public String getSellingPrice() {
        return sellingPrice;
    }


    public void setSellingPrice(String sellingPrice) {
        this.sellingPrice = sellingPrice;
    }


    public String getExp() {
        return exp;
    }


    public void setExp(String exp) {
        this.exp = exp;
    }


    public String getDiscount() {
        return discount;
    }


    public void setDiscount(String discount) {
        this.discount = discount;
    }

}
