



public abstract class Book {
    private String title;
    private String author;
    private String[] genres;
    private int pageNum;
    private double price;

    public Book(String t, String a, String[] g, int pn, double p) {
        title = t;
        author = a;
        genres = g;
        pageNum = pn;
        price = p;
    }
    public void setTitle(String t) {
        title = t;
    }
    public void setAuthor(String a) {
        author = a;
    }
    public void setGenres(String[] g) {
        genres = g;
    }
    public void setPageNum(int pn) {
        pageNum = pn;
    }
    public void setPrice(double p) {
        price = p;
    }
    public String getTitle() {
        return title;
    }
    public String getAuthor() {
        return author;
    } 
    public String[] getGenres() {
        return genres;
    }
    public int getPageNum() {
        return pageNum;
    }
    public double getPrice() {
        return price;
    }
    public abstract String getDescription();
    
    public String bookToString() {
        String fPrice = String.format("%.2f", price);
        String fGenres = "";
        for(int i = 0; i < genres.length; i++) {
            fGenres += genres[i];
            if(i < genres.length - 1) {
                fGenres += ",";
            }
        }
        return "Title: "+title+"\nAuthor: "+author+"\nGenres: "+fGenres+"\nPage Number: "+pageNum+"\nPrice: "+fPrice;
    }


}
