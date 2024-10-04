package article.service;

import java.util.Map;

public class DeleteRequest {

    private String userId;
    private int articleNumber;

    public DeleteRequest(String userId, int articleNumber) {
        this.userId = userId;
        this.articleNumber = articleNumber;
    }

    public String getUserId() {
        return userId;
    }

    public int getArticleNumber() {
        return articleNumber;
    }

    // 검증 로직 - articleNumber가 유효한지 검사
    public void validate(Map<String, Boolean> errors) {
        if (articleNumber <= 0) {
            errors.put("articleNumber", Boolean.TRUE);
        }
    }
}
