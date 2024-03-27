
public class User {
    private String name;
    private int age;
    private Post[] post;
    private Post mostLikedPost;


    public User(String name, int age, Post[] post, Post mostLikedPost) {
        this.name = name;
        this.age = age;
        this.post = post;
        this.mostLikedPost = mostLikedPost;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Post[] getPost() {
        return post;
    }

    public Post getMostLikedPost() {
        return mostLikedPost;
    }
}
