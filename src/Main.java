import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        User[] users = new User[10];

        for (int i = 0; i < users.length; i++) {
            String userName = "User#" + (i + 1);
            int userAge = 20 + i;
            Post[] posts = new Post[random.nextInt(1, 6)];

            for (int j = 0; j < posts.length; j++) {
                String postTitle = userName + " Post#" + (j + 1);
                String description = userName + " some description" + (j + 1);
                int likesCount = random.nextInt(0, 100_000);
                posts[j] = new Post(postTitle, description, likesCount);

            }
            users[i] = new User(userName, userAge, posts);
        }
        builder.append("[");
        for (User user : users) {
            builder.append("{")
                    .append("\"name\": \"").append(user.getName()).append("\", ")
                    .append("\"age\": ").append(user.getAge()).append(", ")
                    .append("\"posts\": [");

            for (Post post : user.getPost()) {
                builder.append("{")
                        .append("\"title\": \"").append(post.getTitle()).append("\", ")
                        .append("\"description\": \"").append(post.getDescription()).append("\", ")
                        .append("\"likes_count\": ").append(post.getLikesCount())
                        .append("}").append(",");
            }
            builder.append("]},");
        }
        builder.append("]");
        String names = builder.toString();
        System.out.println(names);

    }
}

