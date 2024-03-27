public class Post {
    private String title;
    private String description;
    private int likesCount;

    public Post(String title, String description, int likesCount) {
        this.title = title;
        this.description = description;
        this.likesCount = likesCount;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public int getLikesCount() {
        return likesCount;
    }
}
