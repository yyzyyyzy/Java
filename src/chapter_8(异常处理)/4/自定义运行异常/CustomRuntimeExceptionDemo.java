//自定义运行时异常：
class CustomRuntimeException extends RuntimeException {
    public CustomRuntimeException(String message) {
        super(message);
    }
}

public class CustomRuntimeExceptionDemo {
    public static void main(String[] args) {
        try {
            throw new CustomRuntimeException("This is a custom runtime exception.");
        } catch (CustomRuntimeException e) {
            System.out.println("Caught custom runtime exception: " + e.getMessage());
        }
    }
}
