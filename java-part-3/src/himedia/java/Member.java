package himedia.java;

public class Member {

    private String price;
    private String email;
    private String name;

    public Member() {}
    public Member(String price, String email, String name) {
        this.price = price;
        this.email = email;
        this.name= name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
