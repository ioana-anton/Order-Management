package model;

public class Product {
    private int id;
    private String name;
    private int quantity;

    public Product(){}

    public Product(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public Product(int id, String name, int quantity) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String[] toStringArray(){
        String[] res=new String[3];
        res[0]=Integer.toString(id);
        res[1]=name;
        res[2]=Integer.toString(quantity);
         System.out.println(res[0]+" "+res[1]+" "+res[2]);
        return res;
    }

    public boolean equalProduct(Product p2){
        if (name.compareToIgnoreCase(p2.getName())!=0) return false;
        if(quantity!=p2.getQuantity()) return false;
        return true;
    }
}
