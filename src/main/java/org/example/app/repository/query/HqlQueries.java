package org.example.app.repository.query;

public class HqlQueries {

    public static final String GET_TASKS_BY_USER_ID =
            "SELECT t FROM Task t " +
                    "JOIN t.taskList tl " +
                    "JOIN tl.board b " +
                    "JOIN b.user u " +
                    "WHERE u.id = :userId";

    public static final String GET_TASKS_BY_LIST_ID =
            "SELECT t from Task t " +
                    "JOIN t.taskList tl" +
                    "WHERE tl.id = :taskId";

    public static final String getAllUsers = "FROM User";

    private HqlQueries() {
    }
}
