
public class User {
    private String name;
    private int age;
    private Post[] post;

    public User(String name, int age, Post[] post) {
        this.name = name;
        this.age = age;
        this.post = post;
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
}
