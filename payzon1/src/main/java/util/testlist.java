package util;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import mvc.command.CommandHandler;

public class testlist implements CommandHandler {
    @Override
    public String process(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<String> testList = Arrays.asList("Apple", "Banana", "Cherry");
        request.setAttribute("testList", testList);
        return "/view/attendance/test.jsp";
    }
}
