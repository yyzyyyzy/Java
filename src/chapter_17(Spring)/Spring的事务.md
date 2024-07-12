## @Transactional 注解详解

### 1. 概述

`@Transactional` 注解是 Spring 框架中用于管理事务的关键注解之一，它可以应用于方法或类级别，用于声明事务性方法。

### 2. 内置参数

`@Transactional` 注解提供了多个参数来配置事务的属性和行为：

- **propagation**：指定事务的传播行为。
- **isolation**：指定事务的隔离级别。
- **timeout**：指定事务的超时时间（秒）。
- **readOnly**：指定事务是否只读。
- **rollbackFor**：指定哪些异常会导致事务回滚。
- **noRollbackFor**：指定哪些异常不会导致事务回滚。

### 3. 参数详解

#### 3.1 propagation（传播行为）

传播行为指定了事务方法被嵌套调用时，现有事务如何传播到当前方法的行为。

- **Propagation.REQUIRED**：如果当前存在事务，则加入该事务；如果不存在事务，则新建一个事务。
- **Propagation.REQUIRES_NEW**：每次调用方法时，都会新建一个事务，如果当前存在事务，则将其挂起。
- **Propagation.NESTED**：如果当前存在事务，则在嵌套事务内执行；如果没有事务，则与 REQUIRED 行为类似。

#### 3.2 isolation（隔离级别）

隔离级别指定了事务对数据的隔离程度，不同的隔离级别提供了不同的并发控制效果。

常用的隔离级别包括：
- **Isolation.DEFAULT**：默认的隔离级别，由底层数据源决定。
- **Isolation.READ_UNCOMMITTED**：允许读取未提交的数据修改，最低的隔离级别。
- **Isolation.READ_COMMITTED**：只能读取已提交的数据，避免脏读。
- **Isolation.REPEATABLE_READ**：确保在事务范围内多次读取数据时，结果始终一致。
- **Isolation.SERIALIZABLE**：最高的隔离级别，确保事务串行执行，避免幻读。

#### 3.3 timeout（超时设置）

timeout 参数指定事务的超时时间（单位为秒），超过指定时间后如果事务还未完成，则会自动回滚。

#### 3.4 readOnly（只读属性）

readOnly 参数指定事务是否只读，如果设置为 true，则表示只会读取数据而不会进行数据修改操作，可以提高性能。

#### 3.5 rollbackFor 和 noRollbackFor（回滚控制）

这两个参数用于指定哪些异常会导致事务回滚或不回滚。

- **rollbackFor**：指定哪些异常会触发事务回滚。
- **noRollbackFor**：指定哪些异常不会触发事务回滚。

### 4. 实现原理

`@Transactional` 注解的底层实现依赖于 Spring AOP 和 Spring 的事务管理机制。主要涉及以下几个关键点：

- **AOP 切面**：Spring 使用动态代理来创建事务性代理，将目标方法包装在事务性通知中。
- **事务管理器**：不同的数据访问技术有不同的事务管理器实现，如 `DataSourceTransactionManager`、`JpaTransactionManager` 等。
- **事务拦截器**：拦截被 `@Transactional` 注解修饰的方法调用，织入事务处理逻辑。
- **事务上下文**：检查当前线程中是否存在事务上下文，如果不存在，则创建一个新的事务；存在则继续使用现有事务。
- **提交或回滚事务**：根据方法的执行结果决定提交或回滚事务，例如方法抛出异常或符合回滚条件。

### 5. 使用示例

```java
@Transactional(propagation = Propagation.REQUIRED, isolation = Isolation.READ_COMMITTED, timeout = 30, readOnly = false, rollbackFor = {SQLException.class}, noRollbackFor = {IOException.class})
public void transactionalMethod() throws SQLException, IOException {
    // 执行事务性操作
}
```

通过合理配置 `@Transactional` 注解，可以有效地管理和控制 Spring 应用中的事务行为，确保事务的一致性和隔离性。