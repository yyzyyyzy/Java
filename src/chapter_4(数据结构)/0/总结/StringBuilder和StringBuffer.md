# StringBuilder vs StringBuffer

## 概述

`StringBuilder`和`StringBuffer`都是用来创建可变字符串的类，提供了一系列方法用于修改字符串内容，如追加、插入、替换和删除。

## 相同点

- **可变性**：`StringBuilder`和`StringBuffer`都支持可变字符串。
- **API一致**：两者的方法几乎完全一致，如`append`、`insert`、`replace`、`delete`、`reverse`等。

## 不同点

- **线程安全性**：
    - `StringBuffer`是线程安全的，所有方法都被`synchronized`修饰，适合多线程环境。
    - `StringBuilder`不是线程安全的，适合单线程环境。
- **性能**：
    - 由于`StringBuffer`在多线程环境中需要保证线程安全，其性能比`StringBuilder`稍低。
    - 在单线程环境下，`StringBuilder`的性能更高。

## 选择指南

- **单线程环境**：使用`StringBuilder`，因为它性能更高。
- **多线程环境**：使用`StringBuffer`，因为它是线程安全的。

## 常用方法

- `append(String str)`：追加字符串到当前对象。
- `insert(int offset, String str)`：在指定位置插入字符串。
- `replace(int start, int end, String str)`：替换指定范围内的字符串。
- `delete(int start, int end)`：删除指定范围内的字符串。
- `reverse()`：反转当前字符串。