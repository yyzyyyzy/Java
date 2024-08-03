## Swagger 注解使用指南

Swagger 是一个用于设计、构建和文档化 API 的强大工具，它通过注解来简化和美化 API 的描述和文档生成过程。

### 1. @Api

用于类，表示这个类是Swagger资源。

```java
@Api(value = "UserController", tags = {"User Management"})
@RestController
@RequestMapping("/users")
public class UserController {
    // Class implementation
}
```
- `value`: 用于指定类的简要说明，一般用于标识类的名称或角色。
- `tags`: 用于将该类归类到一个或多个分类标签中，方便Swagger UI显示时分类和组织API。

### 2. @ApiOperation

用于方法，表示一个HTTP请求的操作。

```java
@ApiOperation(value = "Get a user by userId", response = User.class)
@GetMapping("/{userId}")
public ResponseEntity<User> getUserById(@ApiParam(value = "User ID", required = true) @PathVariable("userId") Long userId) {
    // Method implementation
}
```
- `value`: 用于描述这个操作的功能。
- `response`: 指定返回对象的类型，用于显示在Swagger UI中。

### 3. @ApiParam

用于方法参数，说明参数的信息。

```java
@ApiOperation(value = "Update user details", response = User.class)
@PutMapping("/{userId}")
public ResponseEntity<User> updateUser(@ApiParam(value = "User ID", required = true) @PathVariable("userId") Long userId,
                                       @RequestBody User userDetails) {
    // Method implementation
}
```
- `value`: 用于描述参数的功能。
- `required`: 表示这个参数是否是必需的。

### 4. @ApiResponse 和 @ApiResponses

@ApiResponses 包含多个 @ApiResponse，用于方法，表示一组响应。

```java
@ApiOperation(value = "Delete a user by userId")
@ApiResponses(value = {
    @ApiResponse(code = 204, message = "User deleted successfully"),
    @ApiResponse(code = 404, message = "User not found")
})
@DeleteMapping("/{userId}")
public ResponseEntity<Void> deleteUser(@ApiParam(value = "User ID", required = true) @PathVariable("userId") Long userId) {
    // Method implementation
}
```
- `code`: HTTP状态码，表示响应的状态。
- `message`: 响应消息，用于描述这个响应的意义。

### 5. @ApiModel 和 @ApiModelProperty

@ApiModel 用于响应类，表示一个Swagger模型，@ApiModelProperty 用于描述属性信息。

```java
@ApiModel(value = "User", description = "User entity")
public class User {

    @ApiModelProperty(value = "User ID")
    private Long id;

    @ApiModelProperty(value = "User's first name")
    private String firstName;

    @ApiModelProperty(value = "User's last name")
    private String lastName;

    // Getters and setters
}
```
- `value`: 模型的名称。
- `description`: 对模型的详细描述。

### 总结

以上是常用的Swagger注解及其使用示例。通过合理使用这些注解，可以使你的API文档更加清晰、规范，并提升团队合作效率和API的易用性。注意，`description` 参数已经被弃用，应使用 `tags` 参数替代。