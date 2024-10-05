package article.command;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import article.service.ArticleData;
import article.service.ArticleNotFoundException;
import article.service.DeleteArticleService;
import article.service.DeleteRequest;
import article.service.PermissionDeniedException;
import article.service.ReadArticleService;
import auth.service.User;
import mvc.command.CommandHandler;

public class DeleteArticleHandler implements CommandHandler {
    private static final String FORM_VIEW = "/view/deleteForm.jsp";  // 삭제 폼 뷰

    private ReadArticleService readService = new ReadArticleService();  // 게시글 조회 서비스
    private DeleteArticleService deleteService = new DeleteArticleService();  // 게시글 삭제 서비스

    @Override
    public String process(HttpServletRequest req, HttpServletResponse res) throws Exception {
        if (req.getMethod().equalsIgnoreCase("GET")) {
            return processForm(req, res);  // GET 요청 시 삭제 확인 폼 반환
        } else if (req.getMethod().equalsIgnoreCase("POST")) {
            return processSubmit(req, res);  // POST 요청 시 삭제 처리
        } else {
            res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
            return null;
        }
    }

    // GET 요청 처리 (삭제 폼 제공)
    private String processForm(HttpServletRequest req, HttpServletResponse res)
            throws IOException {
        try {
            String noVal = req.getParameter("no");
            if (noVal == null || noVal.isEmpty()) {
                throw new IllegalArgumentException("게시글 번호가 누락되었습니다.");
            }
            int no = Integer.parseInt(noVal);

            ArticleData articleData = readService.getArticle(no, false);  // 게시글 조회
            User authUser = (User) req.getSession().getAttribute("authUser");

            if (!canDelete(authUser, articleData)) {
                res.sendError(HttpServletResponse.SC_FORBIDDEN);
                return null;
            }

            // article 객체를 JSP로 전달
            req.setAttribute("article", articleData.getArticle());
            return FORM_VIEW; // deleteForm.jsp로 이동
        } catch (ArticleNotFoundException e) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return null;
        } catch (IllegalArgumentException e) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            return null;
        }
    }



    // POST 요청 처리 (실제 삭제 처리)
    private String processSubmit(HttpServletRequest req, HttpServletResponse res) throws Exception {
        User authUser = (User) req.getSession().getAttribute("authUser");
        String noVal = req.getParameter("no");

        // 로그 출력
        System.out.println("게시글 번호: " + noVal);

        if (noVal == null || noVal.isEmpty()) {
            throw new IllegalArgumentException("게시글 번호가 누락되었습니다.");
        }

        int no = Integer.parseInt(noVal);
        DeleteRequest delReq = new DeleteRequest(authUser.getId(), no);
        req.setAttribute("delReq", delReq);



        try {
        	deleteService.delete(delReq);
            return "/view/deleteSuccess.jsp";
        } catch (ArticleNotFoundException e) {
            res.sendError(HttpServletResponse.SC_NOT_FOUND);
            return null;
        } catch (PermissionDeniedException e) {
            res.sendError(HttpServletResponse.SC_FORBIDDEN);
            return null;
        } catch (IllegalArgumentException e) {
            res.sendError(HttpServletResponse.SC_BAD_REQUEST, e.getMessage());
            return null;
        }
    }

    // 삭제 권한 확인 (작성자만 삭제 가능)
    private boolean canDelete(User authUser, ArticleData articleData) {
        String writerId = articleData.getArticle().getWriter().getId();
        return authUser.getId().equals(writerId);
    }
}
