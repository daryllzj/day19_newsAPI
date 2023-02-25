package ssf.day19_class.model;

public class News {

    private String title;
    private String url;
    private String urlToImage;

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
    public String getUrl() {
        return url;
    }
    public void setUrl(String url) {
        this.url = url;
    }
    public String getUrlToImage() {
        return urlToImage;
    }
    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
    @Override
    public String toString() {
        return "News [title=" + title + ", url=" + url + ", urlToImage=" + urlToImage + "]";
    }
    public News(String title, String url, String urlToImage) {
        this.title = title;
        this.url = url;
        this.urlToImage = urlToImage;
    }
    public News(String title, String url) {
        this.title = title;
        this.url = url;
    }

    

    
}
