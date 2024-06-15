package 成员内部类;

public class MemberOuterTest {
    public static void main(String[] args) {
        成员内部类.MemberOuter outer = new 成员内部类.MemberOuter();
        outer.invokeInnerClass();
    }
}