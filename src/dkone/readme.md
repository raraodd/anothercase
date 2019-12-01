# Data Store and Load
## Input Format
Please change input variable on code.
```java
// Change input string here
String input = "key1=value1;key2=value2\nkeyA=valueA";
```

## Explanation
The code contains two functions. The first is load function that convert input file to array of HashMap. The second is store function, that convert HashMap to string-based format.

## Time Complexity
The time complexity for both load and store function depend on how many “=” appears in the input value.
For example:
```
input = "key1=value1;key2=value2\nkeyA=valueA"
The number of "=" = 3
```
Therefore, the total time complexity is O(3)

## Memory Complexity
Since we only use string, the memory usage is the length of string multiplied by 1 byte.
