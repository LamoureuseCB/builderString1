import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        User[] users = new User[10];
        int postCount = 0;
        String mostActiveUser = null;
        int mostActiveUserPost = 0;
        String topLikedUser;


        for (int i = 0; i < users.length; i++) {
            String userName = "User#" + (i + 1);
            int userAge = 20 + i;
            Post[] posts = new Post[random.nextInt(1, 6)];
            int mostLikedCount = 0;
            Post mostLikedPost = null;


            for (int j = 0; j < posts.length; j++) {
                String postTitle = userName + " Post#" + (j + 1);
                String description = userName + " some description" + (j + 1);
                int likesCount = random.nextInt(0, 100_000);
                postCount++;
                posts[j] = new Post(postTitle, description, likesCount);


                if (likesCount > mostLikedCount) {
                    mostLikedCount = likesCount;
                    mostLikedPost = posts[j];
                }

            }
            users[i] = new User(userName, userAge, posts, mostLikedPost);
            if (users[i].getPost().length > mostActiveUserPost) {
                mostActiveUser = userName;
                mostActiveUserPost = users[i].getPost().length;
            }


        }
        topLikedUser = User.mostLikedUser(users);
        builder.append("{")
                .append("\"info\": {")
                .append("\"posts_count\": ").append(postCount).append(", ")
                .append("\" most_active_user\":\" ").append(mostActiveUser).append("\",")
                .append("\" top_liked_user\":\" ").append(topLikedUser).append("\"")
                .append("},")
                .append("\"results\": [");


        for (User user : users) {
            for (int k = 0; k < users.length; k++) {

                builder.append("{")
                        .append("\"id\":").append(k + 1).append(",")
                        .append("\"name\": \"").append(user.getName()).append("\", ")
                        .append("\"age\": ").append(user.getAge()).append(", ")
                        .append("\"posts\": [");

                for (Post post : user.getPost()) {
                    builder.append("{")
                            .append("\"id\":").append(k + 1).append(", ")
                            .append("\"title\": \"").append(post.getTitle()).append("\", ")
                            .append("\"description\": \"").append(post.getDescription()).append("\", ")
                            .append("\"likes_count\": ").append(post.getLikesCount())
                            .append("},");
                }
                builder.append("],");
                if (user.getMostLikedPost() != null) {
                    builder.append("\"most_liked_post\": ")
                            .append("{")
                            .append("\"title\": \"").append(user.getMostLikedPost().getTitle()).append("\", ")
                            .append("\"description\": \"").append(user.getMostLikedPost().getDescription()).append("\", ")
                            .append("\"likes_count\":").append(user.getMostLikedPost().getLikesCount())
                            .append("}");
                } else {
                    builder.append("\"most_liked_post\": null");
                }
                builder.append("},");
            }
        }

        builder.append("]}");
        String names = builder.toString();
        System.out.println(names);


    }
}

