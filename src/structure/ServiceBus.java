package structure;

public class ServiceBus {
    private String Name;
    private int cost;

    public ServiceBus(String name,int cost) {
        this.Name = name;
        this.cost=cost;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }


    public int getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }
}
