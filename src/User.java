
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

    public static String mostLikedUser(User[] users) {
        String topLikedUser = null;
        int topLikedUserLikes = 0;

        for (User user : users) {
            int userTotalLikes = 0;
            for (Post post : user.getPost()) {
                userTotalLikes += post.getLikesCount();
            }

            if (userTotalLikes > topLikedUserLikes) {
                topLikedUser = user.getName();
                topLikedUserLikes = userTotalLikes;
            }
        }

        return topLikedUser;
    }
}
