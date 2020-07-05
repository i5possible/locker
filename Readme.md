# TDD 201 Final

## Tasking

### Locker

Task1
- Given: Locker 有空间
- When: 存一个 S 号的包
- Then: 存包成功，返回票据

Task2
- Given: Locker 没空间
- When: 存一个 S 号的包
- Then: 存包失败，提示异常

Task3
- Given: Locker 有空间
- When: 存一个 M 号的包
- Then: 存包失败，提示异常

Task4
- Given: 使用 Locker 返回的票据
- When: 取包
- Then: 取包成功，返回包裹

Task5
- Given: 使用无效票据  
- When: 取包
- Then: 取包失败，提示异常
