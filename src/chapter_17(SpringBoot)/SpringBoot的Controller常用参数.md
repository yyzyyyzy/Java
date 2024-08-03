## Spring Boot Controller层常用参数总结

### 1. `@PathVariable`

用于获取URL路径中的变量。

**示例代码：**
```java
@RestController
@RequestMapping("/api")
public class ExampleController {

    @GetMapping("/users/{userId}")
    public String getUser(@PathVariable String userId) {
        return "User ID: " + userId;
    }
}
```

**请求示例：**
```
GET /api/users/123
```

**响应示例：**
```
User ID: 123
```

---

### 2. `@RequestParam`

用于获取请求参数（query parameters）。

**示例代码：**
```java
@RestController
@RequestMapping("/api")
public class ExampleController {

    @GetMapping("/search")
    public String search(@RequestParam String query, @RequestParam(defaultValue = "10") int limit) {
        return "Search query: " + query + ", Limit: " + limit;
    }
}
```

**请求示例（带参数）：**
```
GET /api/search?query=spring&limit=5
```

**响应示例：**
```
Search query: spring, Limit: 5
```

**请求示例（使用默认值）：**
```
GET /api/search?query=spring
```

**响应示例：**
```
Search query: spring, Limit: 10
```

---

### 3. `@RequestBody`

用于获取请求体中的数据，通常用于处理JSON或XML格式的数据。

**示例代码：**
```java
@RestController
@RequestMapping("/api")
public class ExampleController {

    @PostMapping("/create")
    public String create(@RequestBody User user) {
        return "Created user: " + user.getName();
    }
}
```

**请求示例：**
```
POST /api/create
Content-Type: application/json

{
  "name": "John Doe",
  "age": 30
}
```

**响应示例：**
```
Created user: John Doe
```

---

### 4. `@RequestHeader`

用于获取请求头中的数据。

**示例代码：**
```java
@RestController
@RequestMapping("/api")
public class ExampleController {

    @GetMapping("/headers")
    public String getHeaders(@RequestHeader("User-Agent") String userAgent) {
        return "User-Agent: " + userAgent;
    }
}
```

**请求示例：**
```
GET /api/headers
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36
```

**响应示例：**
```
User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.124 Safari/537.36
```

---

### 5. `@CookieValue`

用于获取请求中的Cookie值。

**示例代码：**
```java
@RestController
@RequestMapping("/api")
public class ExampleController {

    @GetMapping("/cookies")
    public String getCookie(@CookieValue("sessionId") String sessionId) {
        return "Session ID: " + sessionId;
    }
}
```

**请求示例：**
```
GET /api/cookies
Cookie: sessionId=abc123
```

**响应示例：**
```
Session ID: abc123
```

---

### 6. `@RequestPart`

用于处理Multipart请求中的部分数据，通常与`@PostMapping`结合使用，用于处理文件上传。

**示例代码：**
```java
@RestController
@RequestMapping("/api")
public class ExampleController {

    @PostMapping("/upload")
    public String uploadFile(@RequestPart("file") MultipartFile file, @RequestPart("description") String description) {
        return "Uploaded file: " + file.getOriginalFilename() + ", Description: " + description;
    }
}
```

**请求示例：**
```
POST /api/upload
Content-Type: multipart/form-data; boundary=boundary

--boundary
Content-Disposition: form-data; name="file"; filename="test.txt"
Content-Type: text/plain

(file content)
--boundary
Content-Disposition: form-data; name="description"

A test file
--boundary--
```

**响应示例：**
```
Uploaded file: test.txt, Description: A test file
```

---

### 7. `@ModelAttribute`

用于将请求参数绑定到模型对象上，通常用于表单提交。

**示例代码：**
```java
@RestController
@RequestMapping("/api")
public class ExampleController {

    @PostMapping("/form")
    public String submitForm(@ModelAttribute User user) {
        return "Submitted user: " + user.getName();
    }
}
```

**请求示例：**
```
POST /api/form
Content-Type: application/x-www-form-urlencoded

name=Jane Doe&age=25
```

**响应示例：**
```
Submitted user: Jane Doe
```

---

### 总结

1. **`@PathVariable`**：用于从URL路径中提取数据。
2. **`@RequestParam`**：用于从请求参数中提取数据。
3. **`@RequestBody`**：用于从请求体中提取数据，通常用于JSON/XML数据。
4. **`@RequestHeader`**：用于提取请求头中的数据。
5. **`@CookieValue`**：用于提取请求中的Cookie值。
6. **`@RequestPart`**：用于处理multipart请求中的部分数据，如文件上传。
7. **`@ModelAttribute`**：用于将请求参数绑定到模型对象上，通常用于表单提交。

---