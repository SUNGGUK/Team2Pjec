package ExceptionHandling;

public class GlobalExceptionHandler {
    public static void handleException(Exception e) {
        // 예외 로깅
        System.out.println("Error: " + e.getMessage());
        // 사용자에게 알림 또는 화면 전환
    }
}
