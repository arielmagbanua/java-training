public class Service {
    String desc; //Tutor: added this part
    String name;
    int id;
    double price; //Tutor: to double

    Service(int ser_id, String name, String desc, double ser_price) {
        this.id = ser_id;
        this.name = name;
        this.desc = desc;
        this.price = ser_price;
    }

    public String getName() {
        return name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String toString(){ //Tutor: added this part
        return this.id +" - "+ this.name + " - "+this.desc +" ==> "+ this.price;
    }
}