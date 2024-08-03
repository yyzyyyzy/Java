# Apache POI 学习笔记

## 1. 概述
Apache POI（Poor Obfuscation Implementation）是一个强大的Java库，主要用于读写Microsoft Office文档。它支持Excel、Word、PowerPoint等文件格式。

## 2. 安装

### Maven
在你的`pom.xml`文件中添加以下依赖：

```xml
<dependency>
    <groupId>org.apache.poi</groupId>
    <artifactId>poi-ooxml</artifactId>
    <version>5.2.2</version>
</dependency>
```

### Gradle
在你的`build.gradle`文件中添加以下依赖：

```groovy
implementation 'org.apache.poi:poi-ooxml:5.2.2'
```

## 3. 基本使用示例

### 读取Excel文件

```java
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadExcelExample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("example.xlsx");
             Workbook workbook = new XSSFWorkbook(fis)) {
             
            Sheet sheet = workbook.getSheetAt(0);
            for (Row row : sheet) {
                for (Cell cell : row) {
                    switch (cell.getCellType()) {
                        case STRING:
                            System.out.print(cell.getStringCellValue() + "\t");
                            break;
                        case NUMERIC:
                            System.out.print(cell.getNumericCellValue() + "\t");
                            break;
                        case BOOLEAN:
                            System.out.print(cell.getBooleanCellValue() + "\t");
                            break;
                        default:
                            System.out.print("UNKNOWN\t");
                            break;
                    }
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 写入Excel文件

```java
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteExcelExample {
    public static void main(String[] args) {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet("Example");

        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("Hello, Apache POI!");

        try (FileOutputStream fos = new FileOutputStream("example.xlsx")) {
            workbook.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## 4. 常见操作

### 创建新的工作簿和工作表

```java
Workbook workbook = new XSSFWorkbook();
Sheet sheet = workbook.createSheet("MySheet");
```

### 创建行和单元格

```java
Row row = sheet.createRow(0); // 创建第一行
Cell cell = row.createCell(0); // 创建第一个单元格
cell.setCellValue("My Value"); // 设置单元格的值
```

### 设置单元格样式

```java
CellStyle style = workbook.createCellStyle();
Font font = workbook.createFont();
font.setBold(true);
style.setFont(font);
cell.setCellStyle(style);
```

### 读取单元格数据

```java
for (Row row : sheet) {
    for (Cell cell : row) {
        switch (cell.getCellType()) {
            case STRING:
                System.out.print(cell.getStringCellValue());
                break;
            case NUMERIC:
                System.out.print(cell.getNumericCellValue());
                break;
            // 处理其他类型
        }
    }
}
```

## 5. 处理复杂的Excel操作

### 合并单元格

```java
sheet.addMergedRegion(new CellRangeAddress(0, 0, 0, 2));
```

### 自动调整列宽

```java
sheet.autoSizeColumn(0);
```

### 添加公式

```java
Cell cell = row.createCell(1);
cell.setCellFormula("SUM(A1:A10)");
```

## 6. 处理Word文档

### 读取Word文档

```java
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileInputStream;
import java.io.IOException;

public class ReadWordExample {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream("example.docx");
             XWPFDocument document = new XWPFDocument(fis)) {

            for (XWPFParagraph paragraph : document.getParagraphs()) {
                System.out.println(paragraph.getText());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

### 写入Word文档

```java
import org.apache.poi.xwpf.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;

public class WriteWordExample {
    public static void main(String[] args) {
        XWPFDocument document = new XWPFDocument();
        XWPFParagraph paragraph = document.createParagraph();
        XWPFRun run = paragraph.createRun();
        run.setText("Hello, Apache POI!");

        try (FileOutputStream fos = new FileOutputStream("example.docx")) {
            document.write(fos);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
```

## 7. 参考文档
- [Apache POI 官方文档](https://poi.apache.org/)
- [Apache POI GitHub 仓库](https://github.com/apache/poi)