package info.androidhive.firebase.mData;

public class Movie {


    private String name;
    private String url;
    private String number;
    private String branch;
private String deals;
    public Movie() {
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }

    public String getnumber() {
        return number;
    }
    public void setnumber(String number) {
        this.number = number;
    }

    public String getbranch() {
        return branch;
    }
    public void setbranch(String branch) {
        this.branch = branch;
    }


    public String getdeals() {
        return deals;
    }
    public void setdeals(String deals) {
        this.deals = deals;
    }

}