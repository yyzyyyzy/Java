package 单元测试;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestAddDemoTest {

    @Test
    public void testAdd() {
        // 测试用例1: 1 + 2
        assertEquals(3, 单元测试.TestAddDemo.add(1, 2));

        // 测试用例2: -1 + 1
        assertEquals(0, 单元测试.TestAddDemo.add(-1, 1));

        // 测试用例3: 0 + 0
        assertEquals(0, 单元测试.TestAddDemo.add(0, 0));

        // 测试用例4: 123 + 456
        assertEquals(579, 单元测试.TestAddDemo.add(123, 456));
    }
}
