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

### Primary Locker Robot
Task1
- Given: PrimaryLockerRobot 管理两个有空间的 Locker 
- When: 存一个 M 号的包
- Then: 成功存包到第一个 Locker，返回票据

Task2
- Given: PrimaryLockerRobot 管理两个没有空间的 Locker 
- When: 存一个 M 号的包
- Then: 存包失败，提示异常

Task3
- Given: PrimaryLockerRobot 管理两个 Locker，第一个没有空间，第二个有空间的  
- When: 存一个 M 号的包
- Then: 成功存包到第二个 Locker，返回票据

Task4
- Given: 使用从 PrimaryLockerRobot 存包返回的票据 
- When: 取包
- Then: 取包成功，返回包裹

Task5
- Given: 使用不是从 PrimaryLockerRobot 存包返回的票据 
- When: 取包
- Then: 取包失败，提示异常

Task6
- Given: 使用同一张 PrimaryLockerRobot 存包返回的票据 
- When: 取包两次
- Then: 第一次取包成功，第二次取包失败，提示异常
