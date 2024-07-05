interface A1 {

}

interface B1 {

}

interface C1 {

}

interface D1 extends C1, B1, A1 {

}

class E1 implements D1 {
    // 接口 D 接口多继承了 C B A 接口
    // 如果我想继承 C B A 接口，我就可以直接继承 D 接口
}